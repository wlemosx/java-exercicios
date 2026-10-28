package Exercicios.ExerciciosDeCollectionsEOutros.ExercicioConversor;

public class Campo {
    private final String nome;
    private final Object valor;
    private final String tipo;

    public Campo(String nome, Object valor, String tipo) {
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public Object getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }
}