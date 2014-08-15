package Principal;
import Controladores.*;

public class DadosIniciais {

	public static void gravaPacientes(){
		ControladorPaciente.gravaPaciente("Jo�o", 50);
		ControladorPaciente.gravaPaciente("Maria", 35);
		ControladorPaciente.gravaPaciente("Marcos", 16);
		ControladorPaciente.gravaPaciente("Renata", 30);
		ControladorPaciente.gravaPaciente("Juliano", 23);
		ControladorPaciente.gravaPaciente("Gl�ria", 65);
		ControladorPaciente.gravaPaciente("S�rgio", 42);
		ControladorPaciente.gravaPaciente("Vitor", 10);
		ControladorPaciente.gravaPaciente("Cristina", 29);
		ControladorPaciente.gravaPaciente("Luciano", 33);
	}
	
	public static void gravaMedicamentos(){
		ControladorMedicamento.gravaMedicamento("Paracetamol");
		ControladorMedicamento.gravaMedicamento("Benegripe");
		ControladorMedicamento.gravaMedicamento("Multigripe");
		ControladorMedicamento.gravaMedicamento("Tamiflu");
		ControladorMedicamento.gravaMedicamento("Litio");
		ControladorMedicamento.gravaMedicamento("Rivoltril");
		ControladorMedicamento.gravaMedicamento("Resfenol");
		ControladorMedicamento.gravaMedicamento("AAS");
		ControladorMedicamento.gravaMedicamento("Doril");
		ControladorMedicamento.gravaMedicamento("Aspirina");
	}
	
	public static void gravaHorarios(){
		ControladorHorario.gravaHorario("09:00 - 09:30");
		ControladorHorario.gravaHorario("09:30 - 10:00");
		ControladorHorario.gravaHorario("10:00 - 10:30");
		ControladorHorario.gravaHorario("10:30 - 11:00");
		ControladorHorario.gravaHorario("11:00 - 11:30");
		ControladorHorario.gravaHorario("11:30 - 12:00");
		ControladorHorario.gravaHorario("14:00 - 14:30");
		ControladorHorario.gravaHorario("14:30 - 15:00");
		ControladorHorario.gravaHorario("15:00 - 15:30");
		ControladorHorario.gravaHorario("15:30 - 16:00");
		ControladorHorario.gravaHorario("16:00 - 16:30");
		ControladorHorario.gravaHorario("16:30 - 17:00");
	}
}
