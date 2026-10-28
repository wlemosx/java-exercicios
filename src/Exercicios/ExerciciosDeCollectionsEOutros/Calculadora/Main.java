package Exercicios.ExerciciosDeCollectionsEOutros.Calculadora;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CALCULADORA ===");
        System.out.println("Escolha a operação:");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.print("Opção: ");

        int operacao = Integer.parseInt(scanner.nextLine());

        if (operacao != 1 && operacao != 2) {
            System.out.println("Operação inválida.");
            scanner.close();
            return;
        }

        System.out.print("Digite os números separados por vírgula: ");
        String entrada = scanner.nextLine();

        String[] valores = entrada.split(",", -1);

        if (valores.length < 2) {
            System.out.println("Informe pelo menos dois números.");
            scanner.close();
            return;
        }

        double resultado;

        try {
            resultado = Double.parseDouble(valores[0].trim());

            for (int i = 1; i < valores.length; i++) {
                double numero = Double.parseDouble(valores[i].trim());

                if (operacao == 1) {
                    resultado += numero;
                } else {
                    resultado -= numero;
                }
            }

            System.out.println("Resultado: " + resultado);

        } catch (NumberFormatException e) {
            System.out.println("Erro: informe somente números válidos.");
        }

        scanner.close();
    }
}


