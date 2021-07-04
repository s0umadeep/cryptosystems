import java.util.List;

public class BruteForce {
	    private Character[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	    private char[] decryption;
	    private String[] plainText;
	    List<Character> alphabetList;

	    public static void main(String[] args) {
	        BruteForce t = new BruteForce();
	        for(String pt : t.recoverplain("OAYBGFQD")) {
	            System.out.println(pt);
	        }
	    }
	    
	    public BruteForce(){
	        alphabetList = java.util.Arrays.asList(alphabet);
	        plainText = new String[alphabet.length];
	    }

	    public String[] recoverplain(String cipherText) {
	        char[] message = cipherText.toUpperCase().toCharArray();
	        for (int key = 0; key < alphabet.length; key++) {
	            decryption = new char[message.length];
	            for (int i = 0; i < message.length; i++) {
	                if (message[i] != ' ') {
	                    decryption[i] = alphabet[(alphabetList.indexOf(message[i])+key) % alphabet.length];
	                }else{
	                    decryption[i] = ' ';
	                }
	            }
	            plainText[key] = String.valueOf(decryption);
	        }
	        return plainText;
	    }

	  
}