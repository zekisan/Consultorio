package Entidades;

public class Consulta {

	private Paciente paciente;
	private boolean realizada;
	private Receituario receitas;
	private Horario horarioConsulta;
	private Prontuario prontuario;
	
	public Consulta(){
		realizada = false;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public boolean isRealizada() {
		return realizada;
	}

	public void setRealizada(boolean realizada) {
		this.realizada = realizada;
	}

	public Receituario getReceitas() {
		return receitas;
	}

	public void setReceitas(Receituario receitas) {
		this.receitas = receitas;
	}

	public Horario getHorarioConsulta() {
		return horarioConsulta;
	}

	public void setHorarioConsulta(Horario horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}

	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}
}
