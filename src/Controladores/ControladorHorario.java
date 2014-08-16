package Controladores;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Entidades.*;

public class ControladorHorario {
	
	private static ArrayList<Horario> listaDeHorarios = new ArrayList<Horario>();
	
	public static void gravaHorario(String horario) throws ParseException{
		Date data = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataHoje = dateFormat.format(data);
		Horario horarioConsulta = new Horario();
		horarioConsulta.setHorario(horario);
		horarioConsulta.setData(dateFormat.parse(dataHoje));
		listaDeHorarios.add(horarioConsulta);
	}

	public static void listarHorariosDisponiveis(){
		
		String lista = "";
		
		for(Horario horarioConsulta: listaDeHorarios){
			String dataConsulta = new SimpleDateFormat("dd/MM/yyyy").format(horarioConsulta.getData());
			if(horarioConsulta.isDisponivel()){
				lista += listaDeHorarios.indexOf(horarioConsulta)+ " - " + dataConsulta + " " + horarioConsulta.getHorario()+"\n";
			}
		}
		
		JOptionPane.showMessageDialog(null, "Cod Horario\n"+lista);	
	}
	
	public static Horario buscaHorario(int codigo){
		
		Horario horario = new Horario();
		try {
			horario = listaDeHorarios.get(codigo);
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Paciente não encontrado!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
		if(horario.isDisponivel()){
			return horario;
		}
		else{
			JOptionPane.showMessageDialog(null, "Horario indisponível ou não cadastrado!");
			//1+1;
			return null;
		}
	}
	
}
