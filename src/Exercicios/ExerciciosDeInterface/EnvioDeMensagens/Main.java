package Exercicios.ExerciciosDeInterface.EnvioDeMensagens;

public class Main {
    public static void main(String[] args) {

        String mensagem = "Aproveite nossas ofertas especiais!";

        ServicoMensagem sms = msg -> System.out.println("SMS: " + msg);
        ServicoMensagem email = msg -> System.out.println("E-mail: " + msg);
        ServicoMensagem redesSociais = msg -> System.out.println("Redes Sociais: " + msg);
        ServicoMensagem whatsapp = msg -> System.out.println("WhatsApp: " + msg);

        sms.enviar(mensagem);
        email.enviar(mensagem);
        redesSociais.enviar(mensagem);
        whatsapp.enviar(mensagem);
    }
}