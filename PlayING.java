// In order for this to work you must either import IngAPI.java or have them in 
public class PlayING {
	
	public static void main(String[] args) throws Exception{
		IngAPI api= new IngAPI();
		//System.out.print(api.getBasic());
		//System.out.print(api.getAccount(1));
		//This response string must be first transformed into a JSON.
		//String me = api.getLoggedUserId();
		//System.out.print(me);
		api.PostcURL("");
	}
}
