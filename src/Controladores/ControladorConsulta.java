package Controladores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import Entidades.*;

public class ControladorConsulta {

private static ArrayList<Consulta> listaDeConsultas;
	
	public ControladorConsulta(){
		listaDeConsultas = new ArrayList<Consulta>();
	}
	
	public static void menuPrincipal(){
		int opcao = 0;
		
		while (opcao != 9) {
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a opção desejada: \n" 
					+ "1 - Cadastrar Consulta \n" 
					+ "2 - Consultas Cadastradas \n"
					+ "3 - Horários Disponíveis\n"
					+ "4 - Realizar consulta\n"
					+ "5 - Visualizar consulta\n"
					+ "6 - Histórico de Consultas\n"
					+ "9 - Voltar"));
			
			switch (opcao) {
			case 1:
				cadastraConsulta();
				break;
			case 2:
				listarConsultas();
				break;
			case 3:
				ControladorHorario.listarHorariosDisponiveis();
				break;
			case 4:
				realizarConsulta();
				break;
			case 5:
				visualizarConsulta();
				break;
			case 6:
				listarHistorico();
				break;
			}
		}
		return;
	}
	
	public static void cadastraConsulta(){
		
		Consulta consulta = new Consulta();
		
		ControladorPaciente.listarPacientes();
		consulta.setPaciente(escolhePaciente());
		
		ControladorHorario.listarHorariosDisponiveis();
		consulta.setHorarioConsulta(escolheHorario());
		
		listaDeConsultas.add(consulta);
	}
	
	public static Paciente escolhePaciente(){
		
		Paciente paciente = new Paciente();
		
		try {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do paciente:"));
			paciente = ControladorPaciente.buscaPaciente(opcao);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informe um código numérico!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return paciente;
	}
	
	public static Horario escolheHorario(){
		
		Horario horario = new Horario();
		
		try {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do horário:"));
			horario = ControladorHorario.buscaHorario(opcao);
			horario.setDisponivel(false);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informe um código numérico!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return horario;
	}
	
	public static void listarConsultas(){
		
		if(!listaDeConsultas.isEmpty()){
			String lista = "";
						
			for(Consulta consulta: listaDeConsultas){
				
				String dataConsulta = new SimpleDateFormat("dd/MM/yyyy").format(consulta.getHorarioConsulta().getData());
				
				lista += listaDeConsultas.indexOf(consulta)+ " - " 
					  + "Paciente: "+consulta.getPaciente().getNome()+" - "
					  + "Horário: " + dataConsulta + " " + consulta.getHorarioConsulta().getHorario() + " - ";
				if(consulta.isRealizada()){
					lista +="Realizada\n";
				}
				else{
					lista +="Não Realizada\n";
				}
			}
			
			JOptionPane.showMessageDialog(null, lista);
		}
		else{
			JOptionPane.showMessageDialog(null, "Nenhuma consulta cadastrada!");
		}
	}
	
	public static void realizarConsulta(){
		Consulta consulta = new Consulta();
		Prontuario prontuario = new Prontuario();
		Receituario receituario = new Receituario();
		listarConsultas();
		
		try {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da consulta:"));
			consulta = listaDeConsultas.get(opcao);
			
			if(!consulta.isRealizada()){
				prontuario.setDescricao(JOptionPane.showInputDialog("Digite o prontuário:"));
				consulta.setProntuario(prontuario);
				opcao = 1;
				
				while (opcao == 1) {
					opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para uma nova receita, ou 0 para encerrar:"));
					
					if(opcao == 1){
						ControladorMedicamento.listarMedicamentos();
						Medicamento medicamento = new Medicamento();
						int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do medicamento:"));
						medicamento = ControladorMedicamento.buscaMedicamento(codigo);
						String dosagem = JOptionPane.showInputDialog("Informe a dosagem:");
						receituario.setReceita(medicamento.getNome(), dosagem);
					}
				}
				consulta.setReceitas(receituario);
				consulta.setRealizada(true);
			}
			else{
				JOptionPane.showMessageDialog(null, "Consulta já realizada!");
			}
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O código deve ser numérico!");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public static void visualizarConsulta(){
		String lista = "";
		listarConsultasRealizadas();
		try {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da consulta:"));
			Consulta consulta = listaDeConsultas.get(opcao);
			if(consulta.isRealizada()){
				lista = "Paciente\n" 
								+ "Nome: " + consulta.getPaciente().getNome()+"\n"
								+ "Idade: " + consulta.getPaciente().getIdade()+"\n"
								+ "----------------------------------------------\n"
								+ "Prontuario\n"
								+ consulta.getProntuario().getDescricao()+"\n"
								+ "----------------------------------------------\n"
								+ "Receituario\n";
				
				Collection chaves = consulta.getReceitas().getReceita().keySet();
				Collection valores = consulta.getReceitas().getReceita().values();   
			    
			    Iterator itrC = chaves.iterator();
			    Iterator itrV = valores.iterator();
			    
			    while(itrC.hasNext()){
			    	lista += "Medicamento: " + itrC.next() + " - Dosagem: " + itrV.next() + "\n";
			    }
			    JOptionPane.showMessageDialog(null, lista);
			}else{
				JOptionPane.showMessageDialog(null, "Consulta não realizada!");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O código deve ser numérico!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public static void listarConsultasRealizadas(){
		
		if(!listaDeConsultas.isEmpty()){
			String lista = "";
			
			for(Consulta consulta: listaDeConsultas){
				
				if(consulta.isRealizada()){
					lista += listaDeConsultas.indexOf(consulta)+ " - " 
						  + "Paciente: "+consulta.getPaciente().getNome()+" - "
						  + "Horário: " +consulta.getHorarioConsulta().getHorario() + " - "
						  
						  + "Realizada\n";
				}
			}
			
			JOptionPane.showMessageDialog(null, lista);
		}
		else{
			JOptionPane.showMessageDialog(null, "Nenhuma consulta realizada!");
		}
		
	}
	
	public static void listarHistorico(){
		Paciente paciente = escolhePaciente();
		String lista = "";
		
		lista = "Paciente\n" 
				+ "Nome: " + paciente.getNome()+"\n"
				+ "Idade: " + paciente.getIdade()+"\n"
				+ "----------------------------------------------\n";
		
		for(Consulta consulta: listaDeConsultas){
			if(consulta.getPaciente() == paciente && consulta.isRealizada()){
				lista += "Prontuario\n"
						+ consulta.getProntuario().getDescricao()+"\n"
						+ "Receituario\n";
		
						Collection chaves = consulta.getReceitas().getReceita().keySet();
						Collection valores = consulta.getReceitas().getReceita().values();   
					    
					    Iterator itrC = chaves.iterator();
					    Iterator itrV = valores.iterator();
					    
					    while(itrC.hasNext()){
					    	lista += "Medicamento: " + itrC.next() + " - Dosagem: " + itrV.next() + "\n";
					    }
					    lista += "----------------------------------------------\n";
			}
		}
		JOptionPane.showMessageDialog(null, lista);
	}
}
