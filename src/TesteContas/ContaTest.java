package TesteContas;

import Contas.Conta;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContaTest {

	@Test
	public void deve_conseguir_criar_uma_conta_com_titular_e_numero() {
		// 1. Configura��o
		String titular = "Jo�o da Silva";
		String numeroConta = "001-002";
		
		// 2. Execu��o
		Conta conta = new Conta(titular, numeroConta);
		
		// 3. Valida��o / Asser��o
		assertNotNull(conta);
		assertEquals(titular, conta.getTitular());
		assertEquals(numeroConta, conta.getNumerodaConta());
	}
	
	@Test
	public void uma_nova_conta_deve_ter_saldo_zero() {
		//1. Configura��o
		Conta conta = new Conta("Jo�o da Silva", "123-456");
		
		//2. Execu��o
		double saldo = conta.getSaldo();
		
		//3. Valida��o / Asser��o
		assertEquals(0, saldo);
	}
	
	@Test
	public void devo_conseguir_depositar_um_valor_na_conta() {
		//1. Configura��o
		Conta conta = new Conta("Jo�o da Silva", "123-456");
		double valorADepositar = 100;
		
		//2. Execu��o
		conta.depositar(valorADepositar);
		
		//3. Valida��o / Asser��o
		assertEquals(valorADepositar, conta.getSaldo());
	}
	
	@Test
	public void devo_conseguir_retirar_um_valor_da_conta() {
		//1. Configura��o
		Conta conta = new Conta("Jo�o da Silva", "123-456");
		conta.depositar(100);
		double valorARetirar = 70;
		double saldoFinalEsperado = 30;
		
		//2. Execu��o
		double valorRetirado = conta.sacar(valorARetirar);
		
		//3. Valida��o / Asser��o
		assertEquals(valorARetirar, valorRetirado);
		assertEquals(saldoFinalEsperado, conta.getSaldo());
	}
	
	@Test
	public void devo_conseguir_transferir_valores_para_outra_conta() {
		//1. Configura��o
		Conta contaOrigem = new Conta("Jo�o da Silva", "123-456");
		contaOrigem.depositar(1000);
		double valorATransferir = 150;
		double saldoEsperadoOrigem = 1000 - valorATransferir;
		double saldoEsperadoDestino = valorATransferir;
		
		Conta contaDestino = new Conta("Maria da Silva", "123-457");
		
		
		//2. Execu��o
		contaOrigem.transferirPara(contaDestino, valorATransferir);
		
		//3. Valida��o / Asser��o
		assertEquals(saldoEsperadoOrigem, contaOrigem.getSaldo());
		assertEquals(saldoEsperadoDestino, contaDestino.getSaldo());
		
	}

}
