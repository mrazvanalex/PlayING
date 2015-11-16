import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
//Must import JSON Object

public class IngAPI {
	
	public String getBasic() throws Exception{
		return PrintcURL("");
	}
	public String PrintcURL(String option) throws Exception {
        URL oracle = new URL("http://213.157.170.77/"+option);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        String ObjectString="";
        while ((inputLine = in.readLine()) != null){
        	ObjectString+=inputLine;
        }
        in.close();
        return ObjectString;
       
    }

}

