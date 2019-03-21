package gestaodecontas;

public class CadastroContas {
	
	private ContaProxy contas[];
	private int numeroDeContas;
	
	public CadastroContas(int numeroDeContas) {
		this.contas = new ContaProxy[numeroDeContas + 1];
	}
	
	public boolean insereConta(ContaProxy conta) {
		if (this.numeroDeContas >= this.contas.length) {
			return false;
		} else {
			for (int i = 1; i <= this.numeroDeContas; i++) {
				if (conta.getNumero() == this.contas[i].getNumero()) {
						return false;
				}
			}
			this.numeroDeContas++;
			this.contas[numeroDeContas] = conta;
			return true;
		}
	}
	
	public ContaProxy buscaConta(int numcta) {
		for (int i = 1; i <= this.numeroDeContas; i++) {
			if (numcta == this.contas[i].getNumero()) {
				return this.contas[i];
			}
		}
		return null;
	}
	
}
