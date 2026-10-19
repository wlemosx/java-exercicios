package Exercicios.ExercicioFundamentos;
import java.time.Year;

public class Main {

    public static void main(String[] args){
        // exercicio1();
        // exercicio2();
        // exercicio3();
        exercicio4();
    }

    public static void exercicio1(){
        var Scanner = new java.util.Scanner(System.in);
        System.out.println("Por favor, informe seu nome:");
        var name = Scanner.nextLine();
        System.out.println("Por favor, informe seu ano de nascimento:");
        var userYear = Scanner.nextInt();
        var currentYear = Year.now().getValue();
        var age = currentYear - userYear;
        System.out.printf("Olá %s, você tem %d anos.", name, age);
    }

    public static void exercicio2(){
        var lado1 = 5;
        var lado2 = 5;
        var result = lado1*lado2;
        System.out.printf("A área do quadrado é: %d", result);
    }

    public static void exercicio3(){
        var Scanner = new java.util.Scanner(System.in);
        System.out.println("Por favor, informe a largura do retangulo:");
        var lado1 = Scanner.nextInt();
        System.out.println("Por favor, informe a altura do retangulo:");
        var lado2 = Scanner.nextInt();
        var result = lado1*lado2;
        System.out.printf("A área do retângulo é: %d", result);
    }

    public static void exercicio4(){
        var Scanner = new java.util.Scanner(System.in);
        System.out.println("Por favor informe o nome da primeira pessoa");
        var persona1 = Scanner.nextLine();
        System.out.println("Por favor informe a idade da primeira pessoa");
        var idade1 = Scanner.nextInt();
        System.out.println("Por favor informe o nome da segunda pessoa");
        var persona2 = Scanner.next();
        System.out.println("Por favor informe a idade da segunda pessoa");
        var idade2 = Scanner.nextInt();
        var diferenca = idade1 - idade2;
        System.out.printf("A diferença de idade entre %s e %s é: %d anos", persona1, persona2, diferenca);
    }
}
