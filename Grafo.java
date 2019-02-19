public class Grafo {
	
	int vertices;
	No[] adj;

	public Grafo (int vertices) {
		this.vertices = vertices;
		this.adj = new No[vertices];
	}
	
	void insere (int v, int w) {
		
		No novo = new No(w);
		
		if(this.adj[v] == null) {
			this.adj[v] = novo;
		}
		else {
			No aux = this.adj[v];
			while(aux.proximo != null) {
				aux = aux.proximo;
			}
			aux.proximo = novo;
		}
	}
	
	void insere2 (int v, int w) {
		insere(v,w);
		insere(w,v);
	}
	
	void imprime() {
		for(int i=0; i < this.vertices; i++) {
			No aux = this.adj[i];
			System.out.print(i + " ");
			while(aux != null) {
				System.out.print(aux.n + " ");
				aux = aux.proximo;
			}
			System.out.println();
		}
	}
	
	int[] BFS (int origem) {
		int time = 1;
		int[] ordem_visita = new int[this.vertices];
		String[] cor = new String[this.vertices];
		
		for(int i=0; i < this.vertices; i++) {
			cor[i] = "branco";
		}
		cor[origem] = "cinza";
		Fila f = new Fila();
		f.insere(origem);
		while(f.estaVazia() == false) {
			int u = f.remove();
			No v = this.adj[u];
			while(v != null) {
				if(cor[v.n].equals("branco")) {
					cor[v.n] = "cinza";
					f.insere(v.n);
					
				}
				v = v.proximo;
			}
			cor[u] = "preto";
			ordem_visita[u] = time;
			time++;
		}
		return ordem_visita;
	}
	
	int[] DFS (int origem) {
		int time = 1;
		int[] ordem_visita = new int[this.vertices];
		String[] cor = new String[this.vertices];
		
		for(int i=0; i < this.vertices; i++) {
			cor[i] = "branco";
		}
		cor[origem] = "cinza";
		Pilha p = new Pilha();
		p.insere(origem);
		while(p.estaVazia() == false) {
			int u = p.remove();
			No v = this.adj[u];
			while(v != null) {
				if(cor[v.n].equals("branco")) {
					cor[v.n] = "cinza";
					p.insere(v.n);
					
				}
				v = v.proximo;
			}
			cor[u] = "preto";
			ordem_visita[u] = time;
			time++;
		}
		return ordem_visita;
	}
	
	public static void main(String[] args) {
		
		Grafo g = new Grafo(7);
		g.insere(0, 1);
		g.insere(1, 2);
		g.insere(0, 3);
		g.insere(3, 4);
		g.insere(0, 5);
		g.insere(0, 6);
		g.imprime();
		
		int[] largura = g.BFS(0);
		int[] profundidade = g.DFS(0);
		
		//imprime o índice do vértice e sua ordem de visitação na busca em largura
		for(int k=0; k < g.vertices; k++) {
			System.out.println(k + " " + largura[k]);
		}
		System.out.println();
		//imprime o índice do vértice e sua ordem de visitação na busca em profundidade
		for(int k=0; k < g.vertices; k++) {
			System.out.println(k + " " + profundidade[k]);
		}
		
	}

}
