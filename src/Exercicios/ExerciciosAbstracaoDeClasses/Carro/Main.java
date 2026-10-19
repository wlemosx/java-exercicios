package Exercicios.ExerciciosAbstracaoDeClasses.Carro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var option = 0;
        Carro carro = new Carro();
        carro.createCar();
        while(true) {
            System.out.println("Por favor escolha uma das opções abaixo:\n");
            System.out.println("1 Ligar o carro:");
            System.out.println("2 Desligar o carro:");
            System.out.println("3 Acelerar o carro:");
            System.out.println("4 Desacelerar o carro:");
            System.out.println("5 Ver velocidade do carro:");
            System.out.println("6 Ver marcha do carro:");
            System.out.println("7 Mudar marcha para cima:");
            System.out.println("8 Mudar marcha para baixo:");
            System.out.println("9 Virar para a esquerda:");
            System.out.println("10 Virar para a direita:");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    carro.turnOnCar();
                    break;
                case 2:
                    carro.turnOffCar();
                    break;
                case 3:
                    carro.accelerateCar();
                    break;
                case 4:
                    carro.decelerateCar();
                    break;
                case 5:
                    carro.getCarSpeed();
                    break;
                case 6:
                    carro.getCarGear();
                    break;
                case 7:
                    carro.changeUpCarGear();
                    break;
                case 8:
                    carro.changeDownCarGear();
                    break;
                case 9:
                    carro.turnLeft();
                    break;
                case 10:
                    carro.turnRight();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
