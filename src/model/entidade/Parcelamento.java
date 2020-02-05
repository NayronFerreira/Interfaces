package model.entidade;

import java.util.Date;

public class Parcelamento {
	
	private Date vencimento;
	private double valor;
	
	public Parcelamento () {
		
	}
	

	public Parcelamento(Date vencimento, double valor) {

		this.vencimento = vencimento;
		this.valor = valor;
	}


	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	

}
