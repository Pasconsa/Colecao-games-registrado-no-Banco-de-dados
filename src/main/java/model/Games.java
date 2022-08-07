package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Games {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false) //obrigatorio ter coluna
	private String ajogo;
	
	@Column(nullable = false)
	private String genero;
	
	@Column(nullable = false)
	private String produtora;
	
	@Column(nullable = false)
	private String ano;
	
	@ManyToOne(optional = false , fetch = FetchType.EAGER)  //muitos telefones para uma pessoa
	private Console console;
	
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAjogo() {
		return ajogo;
	}

	public void setAjogo(String ajogo) {
		this.ajogo = ajogo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getProdutora() {
		return produtora;
	}

	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Console getConsole() {
		return console;
	}

	public void setConsole(Console console) {
		this.console = console;
	}

	

	
}