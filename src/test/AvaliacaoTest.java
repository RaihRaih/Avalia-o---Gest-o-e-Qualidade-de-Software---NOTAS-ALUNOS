package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import main.java.avaliacao.Avaliacao;
import org.junit.jupiter.api.Test;

class AvaliacaoTest {

    @Test
    void calculaMediaDasNotas() {
        Avaliacao avaliacao = new Avaliacao(8, 6);

        assertEquals(7.0, avaliacao.calcularMedia(), 0.0001);
    }

    @Test
    void identificaAlunoEmRecuperacao() {
        Avaliacao avaliacao = new Avaliacao(6, 6);

        assertEquals("Recuperação", avaliacao.verificarSituacao(avaliacao.calcularMedia()));
    }

    @Test
    void rejeitaNotaMaiorQueDez() {
        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> new Avaliacao(11, 8));

        assertEquals("NOTA INVÁLIDA: 11.0", erro.getMessage());
    }
}
