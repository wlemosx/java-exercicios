package Exercicios.ExerciciosAbstracaoDeClasses.ContaBancaria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Conta conta = new Conta();
        var option = 0;

        while(true) {
            System.out.println("Por favor escolha uma das opções abaixo:");
            if(!conta.isAccountCreated()) {
                System.out.println("1 Criar Conta:");
                System.out.println("2 Consultar Saldo:");
                System.out.println("3 Consultar Cheque Especial:");
                System.out.println("4 Deposito:");
                System.out.println("5 Saque:");
                System.out.println("6 Pagar Boleto:");
                System.out.println("7 Ver Cheque Especial:");
                option = scanner.nextInt();

                if(option == 1) {
                    System.out.print("Digite o valor do depósito inicial: ");
                    double depositoInicial = scanner.nextDouble();
                    conta.setAccountCreated(depositoInicial);
                } else if(option >= 2 && option <= 7) {
                    System.out.println("Você precisa criar uma conta antes de realizar qualquer operação.");
                } else {
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            } else {
                System.out.println("1 Consultar Saldo:");
                System.out.println("2 Consultar Cheque Especial:");
                System.out.println("3 Deposito:");
                System.out.println("4 Saque:");
                System.out.println("5 Pagar Boleto:");
                System.out.println("6 Ver Cheque Especial:");
                option = scanner.nextInt();

                if(option == 1) {
                    conta.getSaldo();
                } else if(option == 2) {
                    conta.getChequeEspecial();
                } else if(option == 3) {
                    System.out.print("Digite o valor do depósito: ");
                    double valor = scanner.nextDouble();
                    conta.depositar(valor);
                } else if(option == 4) {
                    System.out.print("Digite o valor do saque: ");
                    double valor = scanner.nextDouble();
                    conta.sacar(valor);
                } else if(option == 5) {
                    System.out.print("Digite o valor do boleto: ");
                    double valor = scanner.nextDouble();
                    conta.pagarBoleto(valor);
                } else if(option == 6) {
                    conta.getSaldoDevedor();
                } else {
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            }
        }
    }
}