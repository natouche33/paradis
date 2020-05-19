
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class validationEmail {


	/**
	 * Launch the application.
	 */

	
	public static boolean validationEmail( String email) {
		
		 boolean status= false;
		 
		 String email_pattern = "^\\w{6,30}[@]+(gmail|hotmail|yahoo|outlook).[\\w]{2,3}$";
		 Pattern pattern = Pattern.compile(email_pattern);
		 Matcher matcher =pattern.matcher(email);
	       if(matcher.matches()){
	    	   status = true;
	       }else{
	    	  
	    	   status = false;
	       }
	       
	       
	       return status;
	}	
		
		
	


}
