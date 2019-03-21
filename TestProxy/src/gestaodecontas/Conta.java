package gestaodecontas;
import java.util.Arrays;

public class Conta implements ProxyInterface{
	
	private int numero;
	private int senha;
	private double saldo;
	private String[] historico = new String[11];
	private double valorLancamento[] = new double[11];
	private int ultimoLancamento; 
		
	public Conta(int numero, int senha, double saldo,String[] historico,double[] valorLancamento,int ultimoLancamento) {
		this.numero = numero;
		this.senha = senha;
		this.saldo = saldo;
		this.historico = historico;
		this.valorLancamento = valorLancamento;
	}
	
	public int getNumero() {
		return this.numero;
	}
	public int getSenha() {
		return this.senha;
	}
	public double getSaldo(int senha) {
		return this.saldo;
	}
	public String[] gethistorico() {
		return this.historico;
	}
	public double[] getvalorLancamento() {
		return this.valorLancamento;
	}
	
	public boolean debitaValor(int senha, double valor, String operacao) {
		if(this.ultimoLancamento == 10){
			for (int i = 0; i < 10; i++) {
				this.historico[i] = this.historico[i+1];
				this.valorLancamento[i] = this.valorLancamento[i+1];
			}
		}
		else{
			this.ultimoLancamento++;
		}
		this.historico[this.ultimoLancamento] = operacao;
		this.valorLancamento[this.ultimoLancamento] = -valor;
		this.saldo -= valor;
		return true;
	}
	
	//Adcionado
	public boolean creditaValor(int senha, double valor, String operacao) {
		if(this.ultimoLancamento == 10){
			for (int i = 0; i < 10; i++) {
				this.historico[i] = this.historico[i+1];
				this.valorLancamento[i] = this.valorLancamento[i+1];
			}
		} else {
			this.ultimoLancamento++;
		}
		this.historico[this.ultimoLancamento] = operacao;
		this.valorLancamento[this.ultimoLancamento] = +valor;
		this.saldo += valor;
		return true;
		
	}
	
	//Adcionado
	public boolean transferePara(Conta destino, int  senha, double valor, String operacao) {
		if(this.debitaValor(senha, valor, operacao) && destino.creditaValor(destino.senha, valor, "Creditado")) 
			return true;
		else 
			return false;
	}
	
	//adcionado
	public boolean creditaCheque(Conta conta, double valor) {
		if (conta.debitaValor(conta.senha, valor, "Debito Cheque") && this.creditaValor(this.senha, valor, "Creditado")) 
			return true;
		else 
			return false;
	}
	
	
	// Extrato
	public String extrato(int senha) {  
		return ("Numero: " + this.numero + "\n" +
					"Saldo:"   + this.saldo  + "\n" +
					"Ultimo Lançamento: " + this.ultimoLancamento + "\n" + 
					"Historico:" + Arrays.toString(this.historico) + "\n" +
					"Valor dos Lançamentos: " + Arrays.toString(valorLancamento) + "\n");
	}
	
	/*Criar Metodo Private em trechos repetidos*/

}
