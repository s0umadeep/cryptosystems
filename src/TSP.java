import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class TSP {

	static int N = Integer.MAX_VALUE;
	static int travllingSalesmanProblem(int graph[][], int s) {
		Vector<Integer> node = new Vector<>();
		for (int i = 0; i < N; i++)
			if (i != s)
				node.add(i);

		int min_path = Integer.MAX_VALUE;
			int current_pathweight = 0;
			int k = s;
			for (int i = 0; i < node.size(); i++) {
				current_pathweight += graph[k][node.get(i)];
				k = node.get(i);
			}
			current_pathweight += graph[k][s];
			min_path = Math.min(min_path, current_pathweight);

		return min_path;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter order n :");
		int N = scan.nextInt();
		System.out.println("Enter N order matrix 1\n");

		int[][] A = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				A[i][j] = scan.nextInt();
			}
		int s = 0;
		System.out.println(travllingSalesmanProblem(A, s));
	}
}