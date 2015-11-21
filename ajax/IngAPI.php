<?php
class IngAPI{ 
	const API_URL_RO = "commonapi.hackathon2015.ing.ro-int/RO/commonapi/";
	const API_URL_ES = "commonapi.hackathon2015.ing.ro-int/ES/commonapi/";
	const API_URL_IT = "commonapi.hackathon2015.ing.ro-int/IT/commonapi/";
	const API_URL_NL = "commonapi.hackathon2015.ing.ro-int/NL/commonapi/";

	private static $errorCodes = array(0   => 'NO_RESPONSE',
									   400 => 'BAD_REQUEST',
									   401 => 'UNAUTHORIZED',
									   403 => 'ACCESS_DENIED',
									   404 => 'NOT_FOUND',
									   429 => 'RATE_LIMIT_EXCEEDED',
									   500 => 'SERVER_ERROR',
									   503 => 'UNAVAILABLE');
	// Whether or not you want returned queries to be JSON or decoded JSON.
	// honestly I think this should be a public variable initalized in the constructor, but the style before me seems definitely to use const's.
	// Remove this commit if you want. - Ahubers
	const DECODE_ENABLED = TRUE;

	public function getAccount($id){
		$call = 'accounts/'.$id;
		//add API URL to the call
		$call = self::API_URL_RO . $call;
		return $this->request($call);
	}
	public function getPerson($id){
		$call = 'persons/'.$id;
		//add API URL to the call
		$call = self::API_URL_RO . $call;
		return $this->request($call);
	}
	public function getMe(){
		$call = 'me';
		//add API URL to the call
		$call = self::API_URL_RO . $call;
		return $this->request($call);
	}
	public function getTransaction($id){
		$call = 'transactions/'.$id;
		$call = self::API_URL_RO . $call;
		return $this->request($call);
	}
	public function getTransfer($id){
		$call = 'transfers/'.$id;
		$call = self::API_URL_RO . $call;
		return $this->request($call);
	}
	public function getTransactions(){
		$call = 'transactions';
		$call = self::API_URL_RO . $call;
		return $this->request($call);
	}
	public function getServer(){
		$call = 'server/status';
		$call = self::API_URL_RO . $call;
		return $this->request($call);
	}
	public function getSupport(){
		$call = 'support';
		$call = self::API_URL_RO . $call;
		return $this->request($call);
	}


	private function request($call) {
		//format the full URL
		$url = $this->format_url($call);


		//call the API and return the result
		$ch = curl_init($url);
		curl_setopt($ch, CURLOPT_URL, $url );
		curl_setopt($ch, CURLOPT_IPRESOLVE, CURL_IPRESOLVE_V4 );
		curl_setopt($ch, CURLOPT_HTTPHEADER, array(
			'Accept: application/json',
			'Authorization: Bearer eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0NDcyNzc5MjksIm5vbmNlIjoiNDNkYmRmOTQtOTg2ZC00NWQwLWExNjctMDEwOWM2ZmEzNzBmIiwiYXVkIjpbIjEiXSwiaXNzIjoiNDExNSIsImp0aSI6ImI1ZjNmZDQzLWI4MzQtNGRlOS05OThhLWJmYWFjMWI2ZTI4OCIsImlhdCI6MTQ0ODA1NTE4Mn0.Or8y-e4f2jIriavexvwicB6ikMadfCpG8haP4hOqg9I' // token needed
		));		
		$result = curl_exec($ch);
		$curl_all = curl_getinfo($ch);
		$this->responseCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
		curl_close($ch);
	}
	//creates a full URL you can query on the API
	private function format_url($call){
		//because sometimes your url looks like .../something/foo?query=blahblah&api_key=dfsdfaefe
		return $call;
	}
} 
$ing = new IngAPI(); 
print_r($ing->getSupport());
//print_r($ing->getMe());
//print_r($ing->getTransactions());
//print_r($ing->getTransfer(1));
//print_r($ing->getServer());
?> 
