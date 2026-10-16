import java.util.Scanner;

public class Main {

    // private final static String WELCOME_MESSAGE = "Olá, informe seu nome";

    public static void main(String[] args){
        var Scanner = new Scanner(System.in);
        System.out.println("Por favor, informe seu nome:");
        var name = Scanner.nextLine();
        System.out.println("Informe sua idade");
        var age = Scanner.nextInt();

        if(age >= 18){
            System.out.printf("Olá %s, você tem %d anos e pode dirigir", name, age);
        } else {
            System.out.printf("Olá %s, você tem %d anos e não pode dirigir", name, age);
        }
    }

}   
