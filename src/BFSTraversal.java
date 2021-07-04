import java.util.Iterator;
import java.util.LinkedList;

class BFSTraversal {
	private int V;
	private LinkedList<Integer> adj[];

	BFSTraversal(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void BFS(int s) {
		boolean visited[] = new boolean[V];

		LinkedList<Integer> q = new LinkedList<Integer>();

		visited[s] = true;
		q.add(s);

		while (q.size() != 0) {
			s = q.poll();
			System.out.print(s + " ");

			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					q.add(n);
				}
			}
		}
	}

	public static void main(String args[]) {
		BFSTraversal g = new BFSTraversal(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Breadth First Search is given as : ");

		g.BFS(2);
	}
}
