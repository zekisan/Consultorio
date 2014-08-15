package Controladores;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import Entidades.*;

public final class ControladorPaciente {
	
	private static ArrayList<Paciente> listaDePacientes;
	
	public ControladorPaciente(){
		listaDePacientes = new ArrayList<Paciente>();
	}

	public static void menuPrincipal(){
		int opcao = 0;
		
		while (opcao != 9) {
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a opção desejada: \n" 
					+ "1 - Cadastrar Paciente \n" 
					+ "2 - Pacientes Cadastrados \n"
					+ "9 - Voltar"));
			
			switch (opcao) {
			case 1:
				cadastraPaciente();
				break;
			case 2:
				listarPacientes();
				break;
			}
		}
		return;
	}
	
	public static void cadastraPaciente(){
	
		String nome = "";
		int idade = 0;
		
		nome = JOptionPane.showInputDialog("Nome do paciente:");
		idade = Integer.parseInt(JOptionPane.showInputDialog("Idade do paciente:"));
		gravaPaciente(nome, idade);
		JOptionPane.showMessageDialog(null, "Paciente " + nome + " cadastrado com sucesso!");
	}
	
	public static void gravaPaciente(String nome, int idade){
		Paciente paciente = new Paciente();
		paciente.setNome(nome);
		paciente.setIdade(idade);
		listaDePacientes.add(paciente);
	}
	
	public static Paciente buscaPaciente(int codigo){
		
		Paciente paciente = new Paciente();
		try {
			paciente = listaDePacientes.get(codigo);
			
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Paciente não encontrado!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
		return paciente;
	}
	
	public static void listarPacientes(){
		
		String lista = "";
		
		for(Paciente paciente: listaDePacientes){
			lista += listaDePacientes.indexOf(paciente)+ " - " + paciente.getNome() + " - " + paciente.getIdade() + "\n";
		}
		
		JOptionPane.showMessageDialog(null, "Cod   Nome     Idade\n"+lista);
		
	}
	
}
