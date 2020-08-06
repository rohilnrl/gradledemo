import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Lapindrome
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		scan.nextLine();
		while (t > 0) {
		    t--;
		    
		    String str = scan.nextLine();
		    String l = str.substring(0, str.length()/2);
		    
		    	String r = str.substring((int) Math.ceil(str.length()/2.0));
		    
		    HashMap<Character, Integer> lFreq = new HashMap<>();
		    HashMap<Character, Integer> rFreq = new HashMap<>();
		    for (int i = 0; i < str.length()/2; i++) {
		        Character c = str.charAt(i);
		        Integer count = lFreq.get(c);
		        if (count == null) {
		            lFreq.put(c, 1);
		        } else {
		            lFreq.put(c, count + 1);
		        }
		    }

		    for (int i = (int) Math.ceil(str.length()/2.0); i < str.length(); i++) {
		        Character c = str.charAt(i);
		        Integer count = rFreq.get(c);
		        if (count == null) {
		            rFreq.put(c, 1);
		        } else {
		            rFreq.put(c, count + 1);
		        }
		    }
		    
		    String res = (lFreq.equals(rFreq)) ? "YES" : "NO";
		    System.out.println(res); 
		}
	}
}
