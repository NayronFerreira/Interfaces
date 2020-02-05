package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Contrato;
import model.entidade.Parcelamento;
import model.servico.PayPal;
import model.servico.ServicoContrato;
import model.servico.TaxaOnline;

public class Programa {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Entre com os dados do contrato: ");
			System.out.print("Numero: ");
			int num = leia.nextInt();
			leia.nextLine();
			System.out.print("Data (dd/mm/aaaa): ");
			Date data = d.parse(leia.nextLine());
			System.out.print("Valor do contrato: ");
			double valorT = leia.nextDouble();

			Contrato contrato = new Contrato(num, data, valorT);

			System.out.print("Entre com a quantidade de parcelas: ");
			int parcelas = leia.nextInt();

			ServicoContrato servicoContrato = new ServicoContrato(new PayPal());
			servicoContrato.processaContrato(contrato, parcelas);
			
			System.out.println("Parcelas: ");
			for(Parcelamento x:contrato.getLista()) {
				System.out.println(x.getVencimento());
				System.out.println("  -  "+ x.getValor());
			}

		} catch (ParseException x) {

		}
		leia.close();
	}

}
