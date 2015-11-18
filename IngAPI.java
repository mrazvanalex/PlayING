import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;
import java.net.*;
import java.util.*;
import org.json.JSONObject;

//Must import JSON Object

import org.omg.CORBA.portable.OutputStream;

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
		//We actually have real output here!
		return PrintcURL("NL/commonapi/me");
	}
	public String PrintcURL(String option) throws Exception {
		System.out.print(GetcURL(option));
		return GetcURL(option);
    }
	private String GetcURL(String option) throws Exception{
		//Returns the given output from given option;
 		URL ing = new URL(BASE_URL+option);
    	BufferedReader in = new BufferedReader(new InputStreamReader(ing.openStream()));

    	String inputLine;
    	String ObjectString="";
    	while ((inputLine = in.readLine()) != null){
    		ObjectString+=inputLine;
    	}
        in.close();
        return ObjectString;
	}
	//Check Lithium Service. What is that?!
	public void PostcURL(String curl)throws Exception{
		//Send a POST HTTP Request
		URL url = new URL("http://86.127.40.240/ing.php");
		
        JSONObject jo = new JSONObject();
        JSONObject joMin = new JSONObject();
        jo.put("firstName", "Marele");
        jo.put("lastName", "Bagabont");
        joMin.put("age", "13");
        joMin.put("age2", "15");
        jo.put("details", joMin);
        
        //postData is now encoded in bytes;
        byte[] postDataBytes = jo.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);
        
        //See the output response
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        System.out.println("Response Code(200 means OK) : "+conn.getResponseCode());
        System.out.println("Time of request : "+conn.getHeaderField(1));
        System.out.println("Server on which request was made : "+conn.getHeaderField(2));
        System.out.println("Server Lang : "+conn.getHeaderField(3));
        System.out.println("Server Lang : "+conn.getHeaderField(8));
        System.out.println("Date(UNIX Time) : "+conn.getDate());
        for ( int c = in.read(); c != -1; c = in.read() ){
        	 System.out.print((char)c);    
        }	
	}
	

	
	
	/*
   curl -X POST --header "Content-Type: application/json" --header "Accept: application/json" --header "X-CAPI-CIF: UID10101" -d "{
  \"sourceProductId\": \"string\",
  \"sourceProductIdentification\": \"string\",
  \"targetProductId\": \"string\",
  \"targetProductIdentification\": \"string\",
  \"targetCodeType\": {
    \"code\": \"string\",
    \"label\": \"string\"
  },
  \"targetCode\": \"string\",
  \"targetBICCode\": \"string\",
  \"targetCustomerName\": \"string\",
  \"amount\": {
    \"value\": 0,
    \"currency\": {
      \"code\": \"string\",
      \"label\": \"string\"
    }
  },
  \"commission\": {
    \"value\": 0,
    \"currency\": {
      \"code\": \"string\",
      \"label\": \"string\"
    }
  },
  \"executionDate\": {
    \"datetime\": \"string\"
  },
  \"transferType\": {
    \"code\": \"string\",
    \"label\": \"string\"
  },
  \"description\": \"string\",
  \"paymentReference\": \"string\",
  \"flagReversal\": {
    \"code\": \"string\",
    \"label\": \"string\"
  },
  \"reversalTransaction\": {
    \"id\": \"string\",
    \"href\": \"string\",
    \"referenceCreateDate\": {
      \"datetime\": \"string\"
    },
    \"transactionType\": {
      \"code\": \"string\",
      \"label\": \"string\"
    },
    \"transactionSubType\": {
      \"code\": \"string\",
      \"label\": \"string\"
    },
    \"direction\": {
      \"code\": \"string\",
      \"label\": \"string\"
    },
    \"description\": \"string\",
    \"amount\": {
      \"value\": 0,
      \"currency\": {
        \"code\": \"string\",
        \"label\": \"string\"
      }
    }
  }
}" "http://213.157.170.77/NL/commonapi/transfers"
	 */
}

