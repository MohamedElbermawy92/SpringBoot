import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	 public static void main(String[] args) {
	        
	        //Scanner sc=new Scanner(System.in);
	      //  String A=sc.next();
	       // String B=sc.next();
	       //System.out.println(A.length()+B.length());
	       //System.out.println(A.compareTo(B)>0 ? "Yes" : "No");
	       //System.out.println(String.valueOf(A.charAt(0)).toUpperCase()+A.substring(1)+ " "+String.valueOf(B.charAt(0)).toUpperCase()+B.substring(1));
	       
	        String input = "The the string String string stringing.";
	        
	        String regex = "\\b(\\w+)(\\s+\\1\\b)+";
	 
	        // Use compile(regex) if you want case sensitive.
	        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	 
	        Matcher m = p.matcher(input);
	        while (m.find()) {
	            input = input.replaceAll(m.group(), m.group(1));
	        }
	 
	        System.out.println(input);
	    }
	      
	     //   String S = sc.next();
	      //  int start = sc.nextInt();
	       // int end = sc.nextInt();
	       // System.out.println(S.substring(start,end));
	       
	       //sc.close();
	    
	
}
