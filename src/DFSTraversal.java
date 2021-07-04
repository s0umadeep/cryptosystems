import java.util.Iterator;
import java.util.LinkedList;

class DFSTraversal {
	private int V;

	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	DFSTraversal(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	void funEdge(int v, int w) {
		adj[v].add(w);
	}

	
	void DFS(int v) {
		boolean visited[] = new boolean[V];
		FunDFS(v, visited);
	}

	public static void main(String args[]) {
		DFSTraversal g = new DFSTraversal(4);
		g.funEdge(0, 1);
		g.funEdge(0, 2);
		g.funEdge(1, 2);
		g.funEdge(2, 0);
		g.funEdge(2, 3);
		g.funEdge(3, 3);

		System.out.println("Depth First Traversal is given as : ");

		g.DFS(2);
	}
	
	void FunDFS(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v + " ");

		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				FunDFS(n, visited);
		}
	}

}