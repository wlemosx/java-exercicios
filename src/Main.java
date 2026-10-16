import java.util.Scanner;

public class Main {

    // private final static String WELCOME_MESSAGE = "Olá, informe seu nome";

    public static void main(String[] args){
        // Scanner scanner = new Scanner(System.in);
        // System.out.println(WELCOME_MESSAGE);
        // String name = scanner.next();
        // System.out.println("Informe sua idade");
        // int age = scanner.nextInt();
        // System.out.println("Olá " + name + ", você tem " + age + " anos.");
        // System.out.printf("Olá %s, você tem %d anos.", name, age);

        // byte number = 1; //Range pequena de -127 a 127
        // short number2 = 1; //Range pequena de -32.768 a 32.767
        // int number3 = 1; //Range grande de -2.147.483.648 a 2.147.483.647
        // long number4 = 1; //Range muito grande de -9.223.372.036.854.775.808 a 9.223.372.036.854.775.807

        // var scanner = new Scanner(System.in);
        // System.out.println("Quanto é 2 + 2?");
        // var result = scanner.nextInt();
        // var isWrong = result != 4;
        // System.out.println("Resposta errada? " + isWrong);

        // var scanner = new Scanner(System.in);
        // System.out.println("informe o primeiro número");
        // var value1 = scanner.nextInt();
        // System.out.println("informe o segundo número");
        // var value2 = scanner.nextInt();
        // System.out.printf("%s + %s = %s", value1, value2, value1 + value2);
        // scanner.close();

        var value1 = 6;
        var binary = Integer.toBinaryString(value1);

        System.out.printf("Primeiro numero %s (Binário: %s)\n", value1, binary);
        var value2 = 2;
        var binary2 = Integer.toBinaryString(value2);

        System.out.printf("Segundo numero %s (Binário: %s)\n", value2, binary2);
        var result = value1 | value2;
        var binaryResult = Integer.toBinaryString(result);
        System.out.printf("%s | %s = %s\n (Binário: %s)", value1, value2, result, binaryResult);

    }

}   
