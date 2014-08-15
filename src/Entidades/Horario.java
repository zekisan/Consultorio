package Entidades;

public class Horario {

	private String horario;
	private boolean disponivel;
	
	public Horario(){
		disponivel = true;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
}
