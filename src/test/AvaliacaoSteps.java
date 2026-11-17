package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Locale;

import main.java.Avaliacao.Avaliacao;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class AvaliacaoSteps {

	private double nota1;
	private double nota2;
	private double media;
	private String situacao;
	private IllegalArgumentException erro;

	@Dado("que o aluno tirou as notas {double} e {double}")
	public void alunoTirouAsNotas(double primeiraNota, double segundaNota) {
		nota1 = primeiraNota;
		nota2 = segundaNota;
		erro = null;
	}

	@Quando("eu calculo a média e verifico a situação")
	public void calcularMediaEVerificarSituacao() {
		try {
			Avaliacao avaliacao = new Avaliacao(nota1, nota2);
			media = avaliacao.calcularMedia();
			situacao = avaliacao.verificarSituacao(media);
		} catch (IllegalArgumentException exception) {
			erro = exception;
		}
	}

	@Entao("a média deve ser {double}")
	public void mediaDeveSer(double mediaEsperada) {
		assertEquals(mediaEsperada, media, 0.0001);
	}

	@Entao("a situação deve ser {string}")
	public void situacaoDeveSer(String situacaoEsperada) {
		assertEquals(
				situacaoEsperada.toUpperCase(Locale.ROOT),
				situacao.toUpperCase(Locale.ROOT));
	}

	@Entao("deve ocorrer o erro {string}")
	public void deveOcorrerErro(String mensagemEsperada) {
		assertNotNull(erro, "Era esperado um erro de nota inválida");
		assertEquals(mensagemEsperada, erro.getMessage());
	}
}
