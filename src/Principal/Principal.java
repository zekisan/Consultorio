package Principal;

import java.text.ParseException;

import javax.swing.JOptionPane;
import Controladores.*;

public class Principal {

	/**
	 * @param args
	 */
	static ControladorPaciente controlaPacientes = new ControladorPaciente();
	static ControladorMedicamento controlaMedicamentos = new ControladorMedicamento();
	static ControladorConsulta controlaConsultas = new ControladorConsulta();
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		DadosIniciais.gravaPacientes();
		DadosIniciais.gravaMedicamentos();
		DadosIniciais.gravaHorarios();
		
		int opcao = 0;
		
		while (opcao != 9) {

			opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a op��o desejada: \n" 
																+ "1 - Pacientes \n" 
																+ "2 - Medicamentos \n"
																+ "3 - Consultas\n"
																+ "9 - Sair"));
			
			switch (opcao) {
			case 1:
				controlaPacientes.menuPrincipal();
				break;
			case 2:
				controlaMedicamentos.menuPrincipal();
				break;
			case 3:
				controlaConsultas.menuPrincipal();
				break;
			}
		}
	}

}
