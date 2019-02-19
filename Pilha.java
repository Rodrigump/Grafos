public class Pilha implements Estrutura {

	No topo;

	public Pilha() {
		this.topo = null;
	}

	@Override
	public int insere(int n) {
		No novo = new No(n);

		if (this.topo == null) {
			this.topo = novo;
		} else {
			No aux = this.topo;
			this.topo = novo;
			novo.proximo = aux;
		}

		return n;

	}

	@Override
	public int remove() {
		int ret = this.topo.n;
		if (this.topo == null) {
			return -1;
		} else {
			No aux = this.topo;
			this.topo = aux.proximo;
			aux = null;
			return ret;
		}
	}

	@Override
	public boolean estaVazia() {
		return (this.topo == null);
	}

	@Override
	public void imprime() {

		No aux = this.topo;

		while (aux != null) {
			System.out.println(aux.n);
			aux = aux.proximo;
		}
		System.out.println();
	}

	public static void main(String[] args) {

	}

}
