package main.java.Avaliacao;

public class Avaliacao {

    private final double nota1;
    private final double nota2;

    public Avaliacao(double nota1, double nota2) {

        if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10) {
            throw new IllegalArgumentException("Valor inválido");
        }

        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double calcularMedia() {
        return (nota1 + nota2) / 2.0;
    }

    public String verificarSituacao(double media){
        if (media >= 7){
            return "Aprovado";
        } else if (media >= 5){
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    
    }
}
