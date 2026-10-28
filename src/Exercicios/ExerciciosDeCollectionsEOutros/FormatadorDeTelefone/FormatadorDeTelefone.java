package Exercicios.ExerciciosDeCollectionsEOutros.FormatadorDeTelefone;


public class FormatadorDeTelefone {

    public static String formatar(String entrada) {
        if (entrada == null || entrada.isBlank()) {
            return "Entrada inválida: nenhum número informado.";
        }

        // Extrai somente os dígitos.
        String numeros = entrada.replaceAll("\\D", "");

        // Valida a quantidade de dígitos e aplica a máscara.
        switch (numeros.length()) {
            case 8:
                return "Telefone fixo: "
                        + numeros.substring(0, 4)
                        + "-"
                        + numeros.substring(4);

            case 9:
                return "Celular: "
                        + numeros.substring(0, 5)
                        + "-"
                        + numeros.substring(5);

            case 10:
                return "Telefone fixo: ("
                        + numeros.substring(0, 2)
                        + ")"
                        + numeros.substring(2, 6)
                        + "-"
                        + numeros.substring(6);

            case 11:
                return "Celular: ("
                        + numeros.substring(0, 2)
                        + ")"
                        + numeros.substring(2, 7)
                        + "-"
                        + numeros.substring(7);

            default:
                return "Entrada inválida: quantidade de dígitos incorreta.";
        }
    }
}
