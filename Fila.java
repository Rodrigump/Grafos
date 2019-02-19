public class Fila implements Estrutura {

	No inicio;
	No fim;

	public Fila() {
		this.inicio = null;
		this.fim = null;
	}

	@Override
	public int insere(int n) {

		No novo = new No(n);

		if (inicio == null) {
			this.inicio = novo;
			this.fim = novo;
		} else {
			this.fim.proximo = novo;
			this.fim = novo;
		}

		return n;

	}

	@Override
	public int remove() {
		if (this.inicio == null) {
			return -1;
		} else {
			int ret = this.inicio.n;
			No aux = this.inicio;
			this.inicio = aux.proximo;
			return ret;
		}

	}

	@Override
	public boolean estaVazia() {
		return (this.inicio == null);
	}

	@Override
	public void imprime() {
		No aux = this.inicio;

		while (aux != null) {
			System.out.print(aux.n + " ");
			aux = aux.proximo;
		}
		System.out.println();
	}

	public static void main(String[] args) {

	}

}