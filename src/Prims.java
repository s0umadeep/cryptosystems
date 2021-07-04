class Prims {
	private static final int V = 5;

	int minKey(int key[], Boolean mstSet[]) {
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}

		return min_index;
	}

	void funcPrim(int gr[][]) {
		int parent[] = new int[V];

		int key[] = new int[V];

		Boolean mstSet[] = new Boolean[V];

		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		key[0] = 0;
		parent[0] = -1;

		for (int count = 0; count < V - 1; count++) {
			int u = minKey(key, mstSet);
			mstSet[u] = true;
			for (int v = 0; v < V; v++)
				if (gr[u][v] != 0 && mstSet[v] == false && gr[u][v] < key[v]) {
					parent[v] = u;
					key[v] = gr[u][v];
				}
		}
		MSTfunction(parent, gr);
	}

	public static void main(String[] args) {
		Prims t = new Prims();
		int gr[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 } };

		t.funcPrim(gr);
	}

	void MSTfunction(int parent[], int gr[][]) {
		System.out.println("E \tDistance");
		for (int i = 1; i < V; i++)
			System.out.println(parent[i] + " - " + i + "\t" + gr[i][parent[i]]);
	}

}