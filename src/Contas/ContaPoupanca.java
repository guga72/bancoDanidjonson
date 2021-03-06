package Contas;

import Contas.Conta;

public class ContaPoupanca extends Conta {
    public String NumerodaConta;
    public String Titular;
    public double Saldo;
    public static double taxaRendimento;

    public ContaPoupanca(String n, String t) {
        super(n, t);
    }

    public void aplicarRendimento(){
	if(taxaRendimento == 0){
		throw new TaxaZerado("Taxa esta zerada");
	}
	else{
        this.saldo = this.saldo + (this.saldo + this.taxaRendimento);
	}
    }


}
