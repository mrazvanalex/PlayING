import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
//Must import JSON Object

public class IngAPI {
	public String BASE_URL="http://213.157.170.77/";
	public String getBasic() throws Exception{
		return PrintcURL("");
	}
	public String getAccount(int id) throws Exception{
		/*
		 * Reads a specific Account.
		 */
		String dummyOutput = "\n"+"Please check http://pastebin.com/CX1eXhZy for output";
		return dummyOutput;
		//return PrintcURL("NL/commonapi/accounts/"+id);
	}
	public String getPerson(int id)throws Exception{
		/*
		 * Reads a person.
		 */
		String dummyOutput = "\n"+"Please check http://pastebin.com/Bdatnn8F for output";
		return dummyOutput;
		//return PrintcURL("NL/commonapi/persons/"+id);
	}
	public String getTransaction(int id)throws Exception{
		/*
		 * Reads a single transaction.
		 */
		String dummyOutput = "\n"+"Please check http://pastebin.com/tmViRpVc for output";
		return dummyOutput;
		//return PrintcURL("NL/commonapi/transactions/"+id);
	}
	public String getPersonAccount(int id)throws Exception{
		/*
		 * read the list of Accounts where a given subject has a role in.
		*  It's an alias of /{id}/products?productType=account
		 */
		String dummyOutput = "\n"+"Please check http://pastebin.com/dzqVLsi7 for output";
		return dummyOutput;
		//return PrintcURL("NL/commonapi/persons/"+id+"/accounts
	}
	public String getLoggedUserId()throws Exception{
		/*
		 * Returns the ID of the logged in User
		 */
		return PrintcURL("NL/commonapi/me");
	}
	
	//Check Lithium Service. What is that?!
	public String PrintcURL(String option) throws Exception {
		//Returns the given output from given option;
 		URL ing = new URL(BASE_URL+option);
    	BufferedReader in = new BufferedReader(
    	new InputStreamReader(ing.openStream()));

    	String inputLine;
    	String ObjectString="";
    	while ((inputLine = in.readLine()) != null){
    		ObjectString+=inputLine;
    	}
        in.close();
        return ObjectString;
       
    }
}

