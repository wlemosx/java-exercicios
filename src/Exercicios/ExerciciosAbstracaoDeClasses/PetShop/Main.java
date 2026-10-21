package Exercicios.ExerciciosAbstracaoDeClasses.PetShop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var dog = new Dog();
        var washMachine = new WashMachine();
        var option = 0;

        while(true) {
            System.out.println("Por favor escolha uma opção!");
            System.out.println("1  -  Chama um cachorro");
            System.out.println("2  -  Checar sujeira do cachorro");
            System.out.println("3  -  Checar limpeza da maquina");
            System.out.println("4  -  Checar vaga na maquina");
            System.out.println("5  -  Checar abastecimento da maquina");
            System.out.println("6  -  Abastecer a maquina");
            System.out.println("7  -  Colocar o cachorro na maquina");
            System.out.println("8  -  Remover o cachorro da maquina");
            System.out.println("9  -  Ligar a maquina");
            System.out.println("10 -  Desligar a maquina");
            System.out.println("11 -  Devolver o cachorro");
            System.out.println("12 -  Lava a maquina");
            option = scanner.nextInt();
            switch(option) {
                case 1:
                    dog.getDog();
                    break;
                case 2:
                    dog.checkDog();
                    break;
                case 3:
                    washMachine.checkWashMachine();
                    break;
                case 4:
                    washMachine.checkWashMachineRoom();
                    break;
                case 5:
                    washMachine.checkWashMachineProducts();
                    break;
                case 6:
                    washMachine.refilWashMachine();
                    break;
                case 7:
                    washMachine.putDogInMachine();
                    break;
                case 8:
                    washMachine.removeDogInMachine();
                    break;
                case 9:
                    washMachine.turnOnMachine(dog);
                    break;
                case 10:
                    washMachine.turnOffMachine();
                    break;
                case 11:
                    dog.deliveryDog();
                    break;
                case 12:
                    washMachine.washWashMachine();
                    break;
            }
        }
    }
}
