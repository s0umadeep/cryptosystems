
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KnapSack {

  public static void main(String[] args) {

    int n;
    int wt = 0;
    int W;
    double maxValue = 0;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size : ");
    n = sc.nextInt();

    System.out.println("Enter the maximum weight of sack : ");
    W = sc.nextInt();


    int[] price = new int[n];

    System.out.println("Enter the prices : ");
    for (int i = 0; i < n; i++) {

      if (sc.hasNext()) {
        price[i] = sc.nextInt();
      }
    }

    System.out.println("Enter the weights : ");

    int[] wtlist = new int[n];

    for (int j = 0; j < n; j++) {

      if (sc.hasNext()) {
        wtlist[j] = sc.nextInt();
      }
    }

      KnapSack.ItemValue[] iVal = new KnapSack.ItemValue[wtlist.length];

    for (int i = 0; i < wtlist.length; i++) {
      iVal[i] = new KnapSack.ItemValue(wtlist[i], price[i], i);
    }

    //sorting items by value;
    Arrays.sort(iVal, new Comparator<KnapSack.ItemValue>() {
      @Override
      public int compare(KnapSack.ItemValue o1, KnapSack.ItemValue o2) {
        return o2.cost.compareTo(o1.cost);
      }
    });


    double totalValue = 0d;
    double res=0d;
    double pwt=0d;


    int Weight = W;
    for (KnapSack.ItemValue i : iVal) {

      int curWt = (int) i.wt;
      int curVal = (int) i.val;
      if (W - curWt >= 0) {
        // this weight can be picked while
        W = W - curWt;
        totalValue += curVal;

      } else {
        // item cant be picked whole
        double fraction = ((double) Weight / (double) curWt);
        maxValue += (curVal * fraction);
        pwt = (double) (Weight - (curWt / fraction));
      }
      res = pwt + totalValue;
    }
    System.out.println("The Highest value a sack can contain is : "+res);

  }
    static class ItemValue
    {
      Double cost;
      double wt, val, ind;

      // item value function
      public ItemValue(int wt, int val, int ind)
      {
        this.wt = wt;
        this.val = val;
        this.ind = ind;
        cost = new Double(val/wt );
      }
    }
}

