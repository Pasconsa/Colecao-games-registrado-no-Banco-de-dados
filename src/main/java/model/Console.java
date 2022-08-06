package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Console {

@Id
@GeneratedValue(strategy = GenerationType.AUTO) // hibernate cria uma sequencia de dados nunca da conflito registro novo
												
private Long id;
private String AConsole;
private String fabricante;
private String anoLancamento;
private String tipoMidia;


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getAConsole() {
	return AConsole;
}
public void setAConsole(String AConsole) {
	this.AConsole = AConsole;
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



@Override
public String toString() {
	return "Console [id=" + id + ", AConsole=" + AConsole + ", fabricante=" + fabricante + ", anoLancamento="
			+ anoLancamento + ", tipoMidia=" + tipoMidia + "]";
}



}







	


	