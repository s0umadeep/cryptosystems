import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class VertexCover {
	int Vertex;
	LinkedList<Integer> a[];

	VertexCover(int v) {
		Vertex = v;
		a = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			a[i] = new LinkedList();
	}

	public static void main(String args[]) {
		VertexCover g = new VertexCover(7);
		int start[] = new int[6];
		int end[] = new int[6];
		Scanner sc = new Scanner(System.in);
		System.out.println("Vertex Cover Problem\n\n");
		System.out.println("Enter the starting link for vertex : \n");
		for (int i = 0; i < start.length; i++) {
			if (sc.hasNext()) {
				start[i] = sc.nextInt();
			}
		}

		System.out.println("Enter the ending link for vertex : \n");
		for (int j = 0; j < end.length; j++) {
			if (sc.hasNext()) {
				end[j] = sc.nextInt();
			}
		}
		
		int a=0,b=0;
		g.link(start[a], end[b]);
		g.link(start[++a], end[++b]);
		g.link(start[++a], end[++b]);
		g.link(start[++a], end[++b]);
		g.link(start[++a], end[++b]);
		g.link(start[++a], end[++b]);
		g.cover();
	}

	void link(int v, int w) {
		a[v].add(w);
		a[w].add(v);
	}

	void cover() {
		boolean vt[] = new boolean[Vertex];
		for (int i = 0; i < Vertex; i++)
			vt[i] = false;

		Iterator<Integer> i;
		for (int u = 0; u < Vertex; u++) {
			if (vt[u] == false) {
				i = a[u].iterator();
				while (i.hasNext()) {
					int v = i.next();
					if (vt[v] == false) {
						vt[v] = true;
						vt[u] = true;
						break;
					}
				}
			}
		}

		System.out.println("\nThe vertex cover obtained from you value : ");
		for (int j = 0; j < Vertex; j++)
			if (vt[j])
				System.out.print(j + "\n");
	}
}
