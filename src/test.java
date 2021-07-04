import java.util.Scanner;

class Ladder {
    public static void main(String[] args) {
        int n;
        int sumeven = 0;
        int sumodd = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number until : ");
        n=sc.nextInt();
        for(int i=1;i<=n;i++){

            if(i%2==0){
                sumeven = sumeven + (i*i*i*i*i);
            }else{
                sumodd = sumodd + (i*i*i);
            }
        }
        int FinalSum = sumeven+sumodd;
        System.out.println("The Final Sum is: "+FinalSum);

    }
}