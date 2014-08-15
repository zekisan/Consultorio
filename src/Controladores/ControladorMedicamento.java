package Controladores;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entidades.Medicamento;
import Entidades.Paciente;

public class ControladorMedicamento {
	
	private static ArrayList<Medicamento> listaDeMedicamentos;
	
	public ControladorMedicamento(){
		listaDeMedicamentos = new ArrayList<Medicamento>();
	}

	public static void menuPrincipal(){
		int opcao = 0;
		
		while (opcao != 9) {
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a opção desejada: \n" 
					+ "1 - Cadastrar Medicamento \n" 
					+ "2 - Medicamentos Cadastrados \n"
					+ "9 - Voltar"));
			
			switch (opcao) {
			case 1:
				cadastraMedicamento();
				break;
			case 2:
				listarMedicamentos();
				break;
			}
		}
		return;
	}
	
	public static void cadastraMedicamento(){
		String nome = "";
		
		nome = JOptionPane.showInputDialog("Nome do paciente:");
		JOptionPane.showMessageDialog(null, "Medicamento " + nome + " cadastrado com sucesso!");
	}
	
	public static void gravaMedicamento(String nome){
		Medicamento medicamento = new Medicamento();
		medicamento.setNome(nome);
		listaDeMedicamentos.add(medicamento);
	}
	
	public static void listarMedicamentos(){
		
		String lista = "";
		
		for(Medicamento medicamento: listaDeMedicamentos){
			lista += listaDeMedicamentos.indexOf(medicamento)+ " - " + medicamento.getNome() + "\n";
		}
		
		JOptionPane.showMessageDialog(null, "Cod   Nome\n"+lista);
	}
	
	public static Medicamento buscaMedicamento(int codigo){
		
		Medicamento medicamento = new Medicamento();
		try {
			medicamento = listaDeMedicamentos.get(codigo);
			
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Medicamento não encontrado!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
		return medicamento;
	}
	
}
