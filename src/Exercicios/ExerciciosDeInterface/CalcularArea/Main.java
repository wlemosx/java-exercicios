package Exercicios.ExerciciosDeInterface.CalcularArea;

public class Main {
    public static void main(String[] args) {

        double lado = 5;
        double base = 10;
        double altura = 4;
        double raio = 3;

        Calculo quadrado = () -> lado * lado;
        Calculo retangulo = () -> base * altura;
        Calculo circulo = () -> Math.PI * raio * raio;

        System.out.printf("Área do quadrado: %.2f%n", quadrado.calcular());
        System.out.printf("Área do retângulo: %.2f%n", retangulo.calcular());
        System.out.printf("Área do círculo: %.2f%n", circulo.calcular());
    }
}