package model.servico;

import java.util.Calendar;
import java.util.Date;

import model.entidade.Contrato;
import model.entidade.Parcelamento;



public class ServicoContrato {
	
	private TaxaOnline taxaOnline;
	
	
	
	public ServicoContrato(TaxaOnline taxaOnline) {

		this.taxaOnline = taxaOnline;
	}




	public void processaContrato (Contrato contrato, int mes) {
		
		Calendar c = Calendar.getInstance();
		c.setTime(contrato.getData());
		c.set(Calendar.MONTH, c.get(Calendar.MONTH)+1);
		Date venci = c.getTime();
		
		double valorP = contrato.getValorTotal()/mes;
		
		
		
		for (int cc= 1; cc<=mes;cc++) {
			c.setTime(venci);
			double valorTaxado = taxaOnline.taxaPayPal (valorP, mes);
			double parcelaFinalTaxada = taxaOnline.taxa2(valorTaxado);
			Parcelamento parcelamento = new Parcelamento(c.getTime(), parcelaFinalTaxada);
			contrato.getLista().add(parcelamento);
			c.set(Calendar.MONTH, c.get(Calendar.MONTH)+1);
		}
		
	}

}
