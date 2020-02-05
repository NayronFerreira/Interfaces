package model.servico;

public class PayPal implements TaxaOnline {
	
	public PayPal() {
		
	}
	
	public double taxaMes (double amount, int parcelas) {
		return ((amount /100)* parcelas)+amount;
	}
	
	public double taxa2 (double amount) {
		return ((amount/100)*2)+amount;
	}

	@Override
	public double taxaPayPal(double amount, int quantidade) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
