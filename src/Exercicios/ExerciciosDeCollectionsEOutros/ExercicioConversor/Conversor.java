package Exercicios.ExerciciosDeCollectionsEOutros.ExercicioConversor;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Conversor {

    public static Campo criarCampo(
            String nome, String valor, String tipo) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome vazio.");
        }

        tipo = tipo.trim().toLowerCase();
        Object convertido;

        switch (tipo) {
            case "texto":
                convertido = valor;
                break;

            case "data":
                convertido = LocalDate.parse(valor).toString();
                break;

            case "datahora":
                convertido = LocalDateTime.parse(valor).toString();
                break;

            case "inteiro":
                convertido = Long.parseLong(valor);
                break;

            case "decimal":
                convertido = new BigDecimal(valor);
                break;

            case "booleano":
                if (!valor.equalsIgnoreCase("true")
                        && !valor.equalsIgnoreCase("false")) {
                    throw new IllegalArgumentException(
                            "Use true ou false.");
                }
                convertido = Boolean.parseBoolean(valor);
                break;

            case "objeto":
                convertido = new LeitorJson(valor).ler();
                if (!(convertido instanceof Map)) {
                    throw new IllegalArgumentException(
                            "O valor deve ser um objeto JSON.");
                }
                break;

            case "array_texto":
            case "array_data":
            case "array_datahora":
            case "array_inteiro":
            case "array_decimal":
            case "array_booleano":
            case "array_objeto":
                Object lista = new LeitorJson(valor).ler();

                if (!(lista instanceof List<?> itens)) {
                    throw new IllegalArgumentException(
                            "O valor deve ser um array JSON.");
                }

                List<Object> resultado = new ArrayList<>();
                String tipoItem = tipo.substring(6);

                for (Object item : itens) {
                    resultado.add(converterItem(item, tipoItem));
                }

                convertido = resultado;
                break;

            default:
                throw new IllegalArgumentException(
                        "Tipo desconhecido: " + tipo);
        }

        return new Campo(nome.trim(), convertido, tipo);
    }

    private static Object converterItem(Object item, String tipo) {
        String valor = String.valueOf(item);

        switch (tipo) {
            case "texto":
                if (!(item instanceof String)) {
                    throw new IllegalArgumentException(
                            "O array deve conter textos.");
                }
                return item;

            case "data":
                return LocalDate.parse(valor).toString();

            case "datahora":
                return LocalDateTime.parse(valor).toString();

            case "inteiro":
                return new BigDecimal(valor).longValueExact();

            case "decimal":
                if (!(item instanceof Number)) {
                    throw new IllegalArgumentException(
                            "O array deve conter números.");
                }
                return new BigDecimal(valor);

            case "booleano":
                if (!(item instanceof Boolean)) {
                    throw new IllegalArgumentException(
                            "O array deve conter booleanos.");
                }
                return item;

            case "objeto":
                if (!(item instanceof Map)) {
                    throw new IllegalArgumentException(
                            "O array deve conter objetos.");
                }
                return item;

            default:
                throw new IllegalArgumentException(
                        "Tipo de array inválido: " + tipo);
        }
    }

    // ==================== JSON ====================

    public static String gerarJson(Map<String, Object> dados) {
        return json(dados);
    }

    private static String json(Object valor) {
        if (valor == null) {
            return "null";
        }

        if (valor instanceof String || valor instanceof Character) {
            return "\"" + escaparJson(valor.toString()) + "\"";
        }

        if (valor instanceof Number || valor instanceof Boolean) {
            return valor.toString();
        }

        if (valor instanceof Map<?, ?> mapa) {
            StringBuilder sb = new StringBuilder("{");
            int i = 0;

            for (Map.Entry<?, ?> e : mapa.entrySet()) {
                if (i++ > 0) sb.append(",");
                sb.append("\n  ")
                  .append(json(String.valueOf(e.getKey())))
                  .append(": ")
                  .append(json(e.getValue()));
            }

            if (!mapa.isEmpty()) sb.append("\n");
            return sb.append("}").toString();
        }

        if (valor instanceof Iterable<?> lista) {
            StringBuilder sb = new StringBuilder("[");
            int i = 0;

            for (Object item : lista) {
                if (i++ > 0) sb.append(", ");
                sb.append(json(item));
            }

            return sb.append("]").toString();
        }

        throw new IllegalArgumentException(
                "Tipo não suportado: " + valor.getClass());
    }

    private static String escaparJson(String texto) {
        StringBuilder sb = new StringBuilder();

        for (char c : texto.toCharArray()) {
            switch (c) {
                case '"': sb.append("\\\""); break;
                case '\\': sb.append("\\\\"); break;
                case '\n': sb.append("\\n"); break;
                case '\r': sb.append("\\r"); break;
                case '\t': sb.append("\\t"); break;
                case '\b': sb.append("\\b"); break;
                case '\f': sb.append("\\f"); break;
                default:
                    if (c < 32) {
                        sb.append(String.format("\\u%04x", (int) c));
                    } else {
                        sb.append(c);
                    }
            }
        }

        return sb.toString();
    }

    // ==================== XML ====================

    public static String gerarXml(Map<String, Object> dados) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<dados>\n");

        for (Map.Entry<String, Object> e : dados.entrySet()) {
            adicionarXml(sb, e.getKey(), e.getValue(), 1);
        }

        return sb.append("</dados>").toString();
    }

    private static void adicionarXml(
            StringBuilder sb, String nome, Object valor, int nivel) {

        String espacos = "    ".repeat(nivel);
        String tag = nomeXml(nome);

        if (valor instanceof Map<?, ?> mapa) {
            sb.append(espacos).append("<").append(tag).append(">\n");

            for (Map.Entry<?, ?> e : mapa.entrySet()) {
                adicionarXml(sb, String.valueOf(e.getKey()),
                        e.getValue(), nivel + 1);
            }

            sb.append(espacos).append("</").append(tag).append(">\n");

        } else if (valor instanceof Iterable<?> lista) {
            sb.append(espacos).append("<").append(tag).append(">\n");

            for (Object item : lista) {
                adicionarXml(sb, "item", item, nivel + 1);
            }

            sb.append(espacos).append("</").append(tag).append(">\n");

        } else {
            String texto = valor == null ? "" : valor.toString();

            sb.append(espacos).append("<").append(tag).append(">")
              .append(escaparXml(texto))
              .append("</").append(tag).append(">\n");
        }
    }

    private static String nomeXml(String nome) {
        String seguro = nome.replaceAll("[^a-zA-Z0-9_.-]", "_");

        if (seguro.isEmpty()
                || (!Character.isLetter(seguro.charAt(0))
                && seguro.charAt(0) != '_')) {
            seguro = "_" + seguro;
        }

        return seguro;
    }

    private static String escaparXml(String texto) {
        return texto.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }

    // ==================== YAML ====================

    public static String gerarYaml(Map<String, Object> dados) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Object> e : dados.entrySet()) {
            adicionarYaml(sb, e.getKey(), e.getValue(), 0);
        }

        return sb.toString();
    }

    private static void adicionarYaml(
            StringBuilder sb, String nome, Object valor, int nivel) {

        String espacos = "  ".repeat(nivel);

        if (valor instanceof Map<?, ?> mapa) {
            sb.append(espacos).append(chaveYaml(nome)).append(":\n");

            for (Map.Entry<?, ?> e : mapa.entrySet()) {
                adicionarYaml(sb, String.valueOf(e.getKey()),
                        e.getValue(), nivel + 1);
            }

        } else if (valor instanceof Iterable<?> lista) {
            sb.append(espacos).append(chaveYaml(nome)).append(":\n");

            for (Object item : lista) {
                if (item instanceof Map<?, ?> || item instanceof List<?>) {
                    if (item instanceof Map<?, ?> mapaItem) {
                        sb.append(espacos).append("  -\n");

                        for (Map.Entry<?, ?> e : mapaItem.entrySet()) {
                            adicionarYaml(sb, String.valueOf(e.getKey()),
                                    e.getValue(), nivel + 2);
                        }
                    } else {
                        sb.append(espacos).append("  - ")
                          .append(escalarYaml(item)).append("\n");
                    }
                } else {
                    sb.append(espacos).append("  - ")
                      .append(escalarYaml(item)).append("\n");
                }
            }

        } else {
            sb.append(espacos).append(chaveYaml(nome)).append(": ")
              .append(escalarYaml(valor)).append("\n");
        }
    }

    private static String chaveYaml(String chave) {
        if (chave.matches("[a-zA-Z_][a-zA-Z0-9_-]*")) {
            return chave;
        }
        return "\"" + escaparJson(chave) + "\"";
    }

    private static String escalarYaml(Object valor) {
        if (valor == null) return "null";
        if (valor instanceof Number || valor instanceof Boolean) {
            return valor.toString();
        }

        String texto = valor.toString();

        if (texto.isEmpty()
                || texto.matches("(?i)null|true|false|yes|no|on|off")
                || texto.matches("[-+]?[0-9]+(\\.[0-9]+)?")
                || texto.startsWith(" ")
                || texto.endsWith(" ")
                || texto.contains(": ")
                || texto.contains(" #")
                || texto.startsWith("#")
                || texto.startsWith("- ")
                || texto.startsWith("? ")
                || texto.startsWith("[")
                || texto.startsWith("{")) {
            return "\"" + escaparJson(texto) + "\"";
        }

        return "\"" + escaparJson(texto) + "\"";
    }

    // ==================== LEITOR JSON ====================

    private static class LeitorJson {
        private final String texto;
        private int posicao = 0;

        LeitorJson(String texto) {
            this.texto = texto;
        }

        Object ler() {
            Object resultado = valor();
            espacos();

            if (posicao != texto.length()) {
                throw erro("Caracteres extras após o valor");
            }

            return resultado;
        }

        private Object valor() {
            espacos();

            if (posicao >= texto.length()) {
                throw erro("Valor ausente");
            }

            char c = texto.charAt(posicao);

            if (c == '"') return string();
            if (c == '{') return objeto();
            if (c == '[') return array();
            if (c == 't') return literal("true", true);
            if (c == 'f') return literal("false", false);
            if (c == 'n') return literal("null", null);

            if (c == '-' || Character.isDigit(c)) {
                return numero();
            }

            throw erro("Valor JSON inválido");
        }

        private Map<String, Object> objeto() {
            Map<String, Object> mapa = new LinkedHashMap<>();
            posicao++;
            espacos();

            if (aceitar('}')) return mapa;

            while (true) {
                espacos();

                if (posicao >= texto.length()
                        || texto.charAt(posicao) != '"') {
                    throw erro("Esperada chave entre aspas");
                }

                String chave = string();
                espacos();
                exigir(':');

                Object valor = valor();

                if (mapa.containsKey(chave)) {
                    throw erro("Chave duplicada: " + chave);
                }

                mapa.put(chave, valor);
                espacos();

                if (aceitar('}')) return mapa;
                exigir(',');
            }
        }

        private List<Object> array() {
            List<Object> lista = new ArrayList<>();
            posicao++;
            espacos();

            if (aceitar(']')) return lista;

            while (true) {
                lista.add(valor());
                espacos();

                if (aceitar(']')) return lista;
                exigir(',');
            }
        }

        private String string() {
            exigir('"');
            StringBuilder sb = new StringBuilder();

            while (posicao < texto.length()) {
                char c = texto.charAt(posicao++);

                if (c == '"') return sb.toString();

                if (c == '\\') {
                    if (posicao >= texto.length()) {
                        throw erro("Escape incompleto");
                    }

                    char e = texto.charAt(posicao++);

                    switch (e) {
                        case '"': sb.append('"'); break;
                        case '\\': sb.append('\\'); break;
                        case '/': sb.append('/'); break;
                        case 'b': sb.append('\b'); break;
                        case 'f': sb.append('\f'); break;
                        case 'n': sb.append('\n'); break;
                        case 'r': sb.append('\r'); break;
                        case 't': sb.append('\t'); break;

                        case 'u':
                            if (posicao + 4 > texto.length()) {
                                throw erro("Unicode incompleto");
                            }

                            String hex = texto.substring(posicao, posicao + 4);

                            try {
                                sb.append((char) Integer.parseInt(hex, 16));
                            } catch (NumberFormatException ex) {
                                throw erro("Unicode inválido");
                            }

                            posicao += 4;
                            break;

                        default:
                            throw erro("Escape inválido");
                    }
                } else {
                    if (c < 32) {
                        throw erro("Caracter de controle na string");
                    }
                    sb.append(c);
                }
            }

            throw erro("String não terminada");
        }

        private Object numero() {
            int inicio = posicao;

            if (aceitar('-') && posicao >= texto.length()) {
                throw erro("Número inválido");
            }

            if (aceitar('0')) {
                if (posicao < texto.length()
                        && Character.isDigit(texto.charAt(posicao))) {
                    throw erro("Zero inicial inválido");
                }
            } else {
                digitos();
            }

            if (aceitar('.')) digitos();

            if (aceitar('e') || aceitar('E')) {
                if (!aceitar('+')) aceitar('-');
                digitos();
            }

            try {
                return new BigDecimal(texto.substring(inicio, posicao));
            } catch (NumberFormatException e) {
                throw erro("Número inválido");
            }
        }

        private void digitos() {
            int inicio = posicao;

            while (posicao < texto.length()
                    && Character.isDigit(texto.charAt(posicao))) {
                posicao++;
            }

            if (inicio == posicao) throw erro("Esperado dígito");
        }

        private Object literal(String esperado, Object resultado) {
            if (!texto.startsWith(esperado, posicao)) {
                throw erro("Literal inválido");
            }

            posicao += esperado.length();
            return resultado;
        }

        private void espacos() {
            while (posicao < texto.length()
                    && Character.isWhitespace(texto.charAt(posicao))) {
                posicao++;
            }
        }

        private boolean aceitar(char c) {
            if (posicao < texto.length()
                    && texto.charAt(posicao) == c) {
                posicao++;
                return true;
            }

            return false;
        }

        private void exigir(char c) {
            if (!aceitar(c)) {
                throw erro("Esperado '" + c + "'");
            }
        }

        private IllegalArgumentException erro(String mensagem) {
            return new IllegalArgumentException(
                    mensagem + " na posição " + posicao);
        }
    }
}
