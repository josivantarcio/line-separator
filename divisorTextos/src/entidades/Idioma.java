package entidades;

import java.util.Objects;

public class Idioma {

	private String english;
	private String portugues;

	private String caminhoEntrada;
	private String caminhoSaida;

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getPortugues() {
		return portugues;
	}

	public void setPortugues(String portugues) {
		this.portugues = portugues;
	}

	public String getCaminhoEntrada() {
		return caminhoEntrada;
	}

	public void setCaminhoEntrada(String caminhoEntrada) {
		this.caminhoEntrada = caminhoEntrada;
	}

	public String getCaminhoSaida() {
		return caminhoSaida;
	}

	public void setCaminhoSaida(String caminhoSaida) {
		this.caminhoSaida = caminhoSaida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(caminhoEntrada, caminhoSaida, english, portugues);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Idioma other = (Idioma) obj;
		return Objects.equals(caminhoEntrada, other.caminhoEntrada) && Objects.equals(caminhoSaida, other.caminhoSaida)
				&& Objects.equals(english, other.english) && Objects.equals(portugues, other.portugues);
	}

}
