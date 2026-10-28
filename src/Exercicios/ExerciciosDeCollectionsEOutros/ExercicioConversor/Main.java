package Exercicios.ExerciciosDeCollectionsEOutros.ExercicioConversor;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> dados = new LinkedHashMap<>();

        System.out.println("=== CONVERSOR DE DADOS ===");
        System.out.println("Formato: NOME_CAMPO;VALOR;TIPO;");
        System.out.println("Digite sair para finalizar.");

        while (true) {
            System.out.print("\nCampo: ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            if (entrada.endsWith(";")) {
                entrada = entrada.substring(
                        0, entrada.length() - 1);
            }

            String[] partes = entrada.split(";", 3);

            if (partes.length != 3) {
                System.out.println(
                        "Formato inválido. Use NOME;VALOR;TIPO;");
                continue;
            }

            String nome = partes[0].trim();
            String valor = partes[1].trim();
            String tipo = partes[2].trim();

            if (dados.containsKey(nome)) {
                System.out.println("Campo já cadastrado.");
                continue;
            }

            try {
                Campo campo = Conversor.criarCampo(
                        nome, valor, tipo);

                dados.put(campo.getNome(), campo.getValor());

                System.out.println("Campo adicionado.");

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        if (dados.isEmpty()) {
            System.out.println("Nenhum campo informado.");
            scanner.close();
            return;
        }

        try {
            System.out.println("\n=== JSON ===");
            System.out.println(Conversor.gerarJson(dados));

            System.out.println("\n=== XML ===");
            System.out.println(Conversor.gerarXml(dados));

            System.out.println("\n=== YAML ===");
            System.out.println(Conversor.gerarYaml(dados));

        } catch (Exception e) {
            System.out.println(
                    "Erro ao gerar os formatos: " + e.getMessage());
        }

        scanner.close();
    }
}