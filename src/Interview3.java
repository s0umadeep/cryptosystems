
public class Interview3 { //bubble sort

	public static void main(String args[]) {
		int ar[] = {6,9,8,1,2,4,5};
		for (int i = 0; i < ar.length-1; i++) {
			for (int j = 0; j < ar.length-i-1; j++) 
				if(ar[j]>ar[j+1]) {
					int temp = ar[j];
					ar[j] = ar[j+1];
					ar[j+1] = temp;
				}
				
			
		}
		for (int i = 0; i < ar.length; i++) {
			System.out.println("\t"+ar[i]);
		}
	}
}
