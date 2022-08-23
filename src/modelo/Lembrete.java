package modelo;

import java.util.*;

public class Lembrete {
	private String hora;
	private String diaDaSemana;
	private Date data;
	
	public Lembrete(String hora, String diaDaSemana, Date data) {
		super();
		this.hora = hora;
		this.diaDaSemana = diaDaSemana;
		this.data = data;
	}

	public String getHora() {
		return hora;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String getDiaDaSemana() {
		return diaDaSemana;
	}
	
	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
}
