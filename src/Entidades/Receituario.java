package Entidades;

import java.util.HashMap;

import javax.swing.JOptionPane;

public class Receituario {

	private HashMap<String, String> receita;
	
	public Receituario(){
		receita = new HashMap<String, String>();
	}

	public HashMap<String, String> getReceita() {
		return receita;
	}

	public void setReceita(String medicamento, String dosagem) {
		if(!this.receita.containsKey(medicamento)){
			this.receita.put(medicamento, dosagem);
		}
		else{
			JOptionPane.showMessageDialog(null, "Este medicamento já foi receitado!");
		}
	}
	
}
