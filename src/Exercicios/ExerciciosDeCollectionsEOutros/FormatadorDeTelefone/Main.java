package Exercicios.ExerciciosDeCollectionsEOutros.FormatadorDeTelefone;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== FORMATADOR DE TELEFONES ===");
        System.out.print("Digite o telefone: ");

        String entrada = scanner.nextLine();

        System.out.println(FormatadorDeTelefone.formatar(entrada));

        scanner.close();
    }
}
