public class PlayING {
	
	public static void main(String[] args) throws Exception{
		IngAPI api= new IngAPI();
		
		String response = api.getBasic();
		// String response = api.getWeMakeOtherFunctions();
		
		System.out.print(response);
		//This response string must be first transformed into a JSON.
	}
}
