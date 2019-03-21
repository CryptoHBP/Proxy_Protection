package gestaodecontas;

public interface ProxyInterface {
	public int getNumero();
	public int getSenha();
	public double getSaldo(int senha);
	public boolean debitaValor(int senha, double valor, String operacao);
	public boolean creditaValor(int senha, double valor, String operacao);
	public String extrato(int senha);
}
