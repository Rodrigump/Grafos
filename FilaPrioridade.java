public class FilaPrioridade implements Estrutura {
	
	No inicio;
	No fim;
	
	public FilaPrioridade() {
		this.inicio = null;
		this.fim = null;
	}

	@Override
	public int insere(int n) {
		No novo = new No(n);
		
		if(this.inicio == null) {
			this.inicio = novo;
			this.fim = novo;
		}
		else {
			if(n < this.inicio.n) {
				novo.proximo = this.inicio;
				this.inicio = novo;
			}
			else {
				No aux = this.inicio;
				while((aux.proximo != null) && (aux.proximo.n < n) ) {
					aux = aux.proximo;
				}
				novo.proximo = aux.proximo;
				aux.proximo = novo;
			}
		}
		return n;
	}

	@Override
	public int remove() {
		if(this.inicio == null) {
			return -1;
		}
		else {
			int res = this.inicio.n;
			No aux = this.inicio;
			this.inicio = aux.proximo;
			return res;
		}
	}

	@Override
	public boolean estaVazia() {
		return (this.inicio == null);
	}

	@Override
	public void imprime() {
		No aux = this.inicio;
		
		while(aux != null) {
			System.out.print(aux.n + " ");
			aux = aux.proximo;	
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		FilaPrioridade fp = new FilaPrioridade();
		fp.insere(10);
		fp.insere(5);
		fp.insere(8);
		fp.insere(32);
		fp.insere(2);
		fp.imprime();
		fp.remove();
		fp.imprime();
	}
	
}
