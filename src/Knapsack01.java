
public class Knapsack01 {

  public static void main(String[] args) {

    int price[] = {15, 10, 20};
    int wt[] = {1, 2, 3};
    int W = 10;
    int N = wt.length;
    int[][] x = new int[N + 1][W + 1];
    for (int j = 0; j <= W; j++) {

      x[0][j] = 0;

    }
    System.out.println("The price for the item is : ");
    for (int i = 0; i < 3; i++) {
      System.out.println(price[i]);
    }

    for (int row = 0; row <= N; row++) {

      x[row][0] = 0;
    }
    System.out.println("The weight for the item is : ");
    for (int i = 0; i < 3; i++) {
      System.out.println(wt[i]);
    }
    System.out.println("The weight for the sack is : "+W);

    for (int i = 1; i <= N; i++) {

      for (int Wt = 1; Wt <= W; Wt++) {

        if (wt[i - 1] <= Wt) {

          x[i][Wt] = Math.max(price[i - 1] + x[i - 1][Wt - wt[i - 1]], x[i - 1][Wt]);
        }

        else {

          x[i][Wt] = x[i - 1][Wt];
        }
      }

    }
    System.out.println("The maximum value for the sack can accomodate is : "+x[N][W]);

  }

}
