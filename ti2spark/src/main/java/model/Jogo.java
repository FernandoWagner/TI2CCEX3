package model;

public class Jogo {

	private int id;
	private String nome;
	private int downloads;
	private String estudio;
	
	
	public Jogo() {
		this.id = -1;
		this.nome = "";
		this.downloads = 0;
		this.estudio = "";
	}
	
	public Jogo(int id, String nome, int downloads, String estudio) {
		this.id = id;
		this.nome = nome;
		this.downloads = downloads;
		this.estudio = estudio;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getDownloads() {
		return downloads;
	}
	
	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}
	
	public String getEstudio() {
		return estudio;
	}
	
	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}
	
	@Override
	public String toString() {
		return "Jogo [id=" + id + ", nome=" + nome + ", downloads=" + downloads + ", estudio=" + estudio + "]";
	}
	
	
	
}
