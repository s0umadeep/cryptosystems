import java.util.Scanner;

public class Merging {

  public static void main(String[] args) {

    int N = 0;
    int a = 0, b = 0;

    System.out.println("Enter the numbers you want in the list 1 in sorted order :: ");
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    int[] numberList1 = new int[N];

    System.out.println("Enter the  " + N + " numbers in the list 1:: ");
    for (int i = 0; i < N; i++) {
      if (sc.hasNextInt()) {
        numberList1[i] = sc.nextInt();
      }
    }

    System.out.println("Enter the numbers you want in the list 2 in sorted order :: ");
    int M = sc.nextInt();
    int[] numberList2 = new int[M];

    int mainSize = M + N;

    int[] numberListFinal = new int[mainSize];

    System.out.println("Enter the  " + M + " numbers in the list 2:: ");

    for (int j = 0; j < M; j++) {
      if (sc.hasNextInt()) {
        numberList2[j] = sc.nextInt();
      }
    }
    int i = 0, j = 0, k = 0;
    while (i < N && j < M) {
      if (numberList1[i] < numberList2[j]) {
        numberListFinal[k++] = numberList1[i++];
      } else {
        numberListFinal[k++] = numberList2[j++];
      }
    }
    
    while (i < N)
      numberListFinal[k++] = numberList1[i++];

    while (j < M)
      numberListFinal[k++] = numberList2[j++];

    System.out.println("Sorted Array is : ");

    for (int l = 0; l < mainSize; l++)
      System.out.print(numberListFinal[l] + " ");
    sc.close();
  }

}
