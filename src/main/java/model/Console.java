package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	
	@NamedQuery(name = "Console.todos", query ="select u from Console u"),
	@NamedQuery(name = "Console.buscaPorConsole", query ="select u from Console u where u.aConsole = :aConsole")
	
})
public class Console {

@Id
@GeneratedValue(strategy = GenerationType.AUTO) // hibernate cria uma sequencia de dados nunca da conflito registro novo
												
private Long id;
private String aConsole;
private String fabricante;
private String anoLancamento;
private String tipoMidia;
private String geracao;

//para mapear os games no console
@OneToMany(mappedBy = "console", fetch = FetchType.EAGER) //consultar os telefones por usuario
private List <Games> games;



public List<Games> getGames() {
	return games;
}
public void setGames(List<Games> games) {
	this.games = games;
}


public String getaConsole() {
	return aConsole;
}
public void setaConsole(String aConsole) {
	this.aConsole = aConsole;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public String getFabricante() {
	return fabricante;
}
public void setFabricante(String fabricante) {
	this.fabricante = fabricante;
}
public String getAnoLancamento() {
	return anoLancamento;
}
public void setAnoLancamento(String anoLancamento) {
	this.anoLancamento = anoLancamento;
}
public String getTipoMidia() {
	return tipoMidia;
}
public void setTipoMidia(String tipoMidia) {
	this.tipoMidia = tipoMidia;
}
public String getGeracao() {
	return geracao;
}
public void setGeracao(String geracao) {
	this.geracao = geracao;
}


@Override
public String toString() {
	return "Console [id=" + id + ", AConsole=" + aConsole + ", fabricante=" + fabricante + ", anoLancamento="
			+ anoLancamento + ", tipoMidia=" + tipoMidia + ", geracao=" + geracao +"]";
}



}







	


	