package Exercicios;

import java.util.Scanner;

public class EstruturasDeControleJava {
    public static void main(String[] args){
        // exercicio1();
        // exercicio2();
        // exercicio3();
        exercicio4();
    }

    public static void exercicio1(){
        var Scanner = new java.util.Scanner(System.in);
        System.out.println("Por favor insiera um numero para a tabuada");
        var number = Scanner.nextInt();
        for(int i = 1; i <= 10; i++){
            var result = number * i;
            System.out.printf("%d x %d = %d\n", number, i, result);
        }
    }

    public static void exercicio2(){
        var Scanner = new java.util.Scanner(System.in);
        System.out.println("Por favor insira seu peso");
        var peso = Scanner.nextDouble();
        System.out.println("Por favor insira sua altura");
        var altura = Scanner.nextDouble();
        var imc = peso / (altura * altura);
        if(imc < 18.5){
            System.out.printf("Seu IMC é %.2f e você está abaixo do peso", imc);
        } else if(imc >= 18.5 && imc < 24.9){
            System.out.printf("Seu IMC é %.2f e você está com o peso normal", imc);
        } else if(imc >= 25 && imc < 29.9){
            System.out.printf("Seu IMC é %.2f e você está levemente acima do peso", imc);
        } else if(imc >= 30 && imc < 34.9){
            System.out.printf("Seu IMC é %.2f e obesidade grau I", imc);
        } else if(imc >= 35 && imc < 39.9){
            System.out.printf("Seu IMC é %.2f e obesidade grau II (severa)", imc);
        } else if(imc >= 40){
            System.out.printf("Seu IMC é %.2f e obesidade grau III (mórbida)", imc);
        } else {
            System.out.printf("Por favor tente novamente, não foi possível calcular seu IMC");
        }
    }

    public static void exercicio3(){
        var Scanner = new java.util.Scanner(System.in);
        var number = 0;
        var number2 = 0;
        var opcao = 0;

        while(true) {
            System.out.println("Por favor insira um numero");
            number = Scanner.nextInt();
            System.out.println("Por favor insira um numero maior");
            number2 = Scanner.nextInt();
            if(number > number2){
                System.out.println("O segundo numero deve ser maior que o primeiro, tente novamente");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Escolha par ou impar");
            System.out.println("1 - Par");
            System.out.println("2 - Impar");
            opcao = Scanner.nextInt();

            if(opcao == 1 || opcao == 2){
                break;
            } else {
                System.out.println("Opção inválida, tente novamente");
            }
        }

        for(int i = number2; i >= number; i--){
            if(opcao == 1 && i % 2 == 0){
                System.out.printf("%d é par\n", i);
            } else if(opcao == 2 && i % 2 != 0){
                System.out.printf("%d é impar\n", i);
            }
        }
    }

    public static void exercicio4(){
        var Scanner = new java.util.Scanner(System.in);
        var number1 = 0;
        var number2 = 0;
        var result = 0;
        while(true) {
            System.out.println("Por favor insira o primeiro numero");
            number1 = Scanner.nextInt();
            System.out.println("Por favor insira o segundo numero, maior que o primeiro");
            number2 = Scanner.nextInt();
            result = number2 % number1;
            if(result == 0){
                System.out.printf("Resultado: %d\n", result);
            } else {
                System.out.printf("Resultado: %d encerrando o programa\n", result);
                break;
            }
        }

    }
}
