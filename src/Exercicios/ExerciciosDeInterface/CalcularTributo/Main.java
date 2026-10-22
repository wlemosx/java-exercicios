package Exercicios.ExerciciosDeInterface.CalcularTributo;

public class Main {
    public static void main(String[] args) {

        Calculo alimentacao = valor -> valor * 0.01;
        Calculo saudeBemEstar = valor -> valor * 0.015;
        Calculo vestuario = valor -> valor * 0.025;
        Calculo cultura = valor -> valor * 0.04;

        double valorProduto = 100.00;

        System.out.printf("Tributo Alimentação: R$ %.2f%n", alimentacao.calcular(valorProduto));
        System.out.printf("Tributo Saúde e bem-estar: R$ %.2f%n", saudeBemEstar.calcular(valorProduto));
        System.out.printf("Tributo Vestuário: R$ %.2f%n", vestuario.calcular(valorProduto));
        System.out.printf("Tributo Cultura: R$ %.2f%n", cultura.calcular(valorProduto));
    }
}