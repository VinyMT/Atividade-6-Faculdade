package model.entities;

public class Manutencao {
	private int numero;
	private float custo;
	private String descricao;	
	private int tempoParado;
	
	public Manutencao(int numero, float custo, String descricao, int tempoParado) {
		this.setNumero(numero);
		this.setCusto(custo);
		this.setDescricao(descricao);
		this.setTempoParado(tempoParado);
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public float getCusto() {
		return custo;
	}
	
	public void setCusto(float custo) {
		if(custo > 0) {
			this.custo = custo;
		}
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getTempoParado() {
		return tempoParado;
	}

	public void setTempoParado(int tempoParado) {
		if(tempoParado > 0) {
			this.tempoParado = tempoParado;
		}
	}
	
	public float getCustoMedioDiario() {
		return custo / tempoParado;
	}
}
