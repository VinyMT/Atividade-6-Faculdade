package model.entities;
import java.util.ArrayList;
import java.util.Date;

public class Veiculo {
	private String placa;
	private String modelo;
	private Date dataAquisicao;
	private ArrayList<Manutencao> manutencoes = new ArrayList<>();
	
	public Veiculo(String placa, String modelo, Date dataAquisicao) {
		this.setPlaca(placa);
		this.setModelo(modelo);
		this.setDataAquisicao(dataAquisicao);
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Date getDataAquisicao() {
		return dataAquisicao;
	}
	
	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}
	
	public void addManutencao(Manutencao m) {
		manutencoes.add(m);
	}
	
	public ArrayList<Manutencao> getManutencoes() {
		ArrayList<Manutencao> copia = new ArrayList<>(manutencoes);
		return copia;
	}
	
	public int getQtdServico(String descricao) {
		int qtd = 0;
		for(Manutencao m : manutencoes) {
			if(m.getDescricao().equals(descricao)) {
				qtd++;
			}
		}
		return qtd;
	}
	
	public float getCustoMedio() {
		float media = 0;
		
		for(Manutencao m : manutencoes) {
			media += m.getCusto();
		}
		
		return media / manutencoes.size();
	}
	
	
	private int getTempoParadoTotal() {
		int tempoParadoTotal = 0;
		
		for(Manutencao m : manutencoes) {
			tempoParadoTotal += m.getTempoParado();
		}
		
		return tempoParadoTotal;
	}
	
	public float indiceDeSucateamento() {	
		if(getTempoParadoTotal() < 20) {
			return 0;
		} else if(getTempoParadoTotal() < 50) {
			return 0.5f;
		} else if(getTempoParadoTotal() < 80) {
			return 1;
		} else if(getTempoParadoTotal() < 120) {
			return 1.5f;
		} else {
			return 2;
		}
	}
	
	public int comparaVeiculo(Veiculo v) {
		if(v.indiceDeSucateamento() > this.indiceDeSucateamento()) {
			return -1;
		} else if(v.indiceDeSucateamento() < this.indiceDeSucateamento()) {
			return 1;
		} else {
			return 0;
		}
	}
}
