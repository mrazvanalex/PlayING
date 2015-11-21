var wrongLogin = false; //wrong login flag
var loggedIn;
function loginModal() {
    var modalText = wrongLogin ? 'Wrong username or password:' : 'Your username and password:'; 
    myApp.modalLogin(modalText, function(username, password){
        myApp.showIndicator();
        $$.post(
            'http://webratd.com/playing/ajax/check-login.php', // path to your php script
            {username: username, password: password}, //pass username and password
            function (response) {
                myApp.hideIndicator();
                if (response === 'ok') {
                    loggedIn = true;
                    // do something if correct
                }
                else {
                    wrongLogin = true; // Set wrong login flag
                    //loginModal(); // Call this function again
                }
            }
        );
    });
}
function mylogin(){
    var oForm = document.getElementById('loginform');
    var name = oForm.elements['username'].value;
    var pass = oForm.elements['password'].value;
    var modalText = wrongLogin ? 'Wrong username or password:' : 'Your username and password:'; 
   
        $$.post(
            'http://webratd.com/playing/ajax/check-login.php', // path to your php script
            {username: name, password: pass}, //pass username and password
            function (response) {
                if (response === 'ok') {
                    loggedIn = true;
                    var a = document.createElement('a');
                    var linkText = document.createTextNode("Login");
                    a.appendChild(linkText);
                    a.title = "Login";
                    a.id = "loginlink";
                    a.href = "menu.html";
                    document.body.appendChild(a);
                    a.click();
                    // do something if correct
                }
                else {
                    loggedIn=false;
                    wrongLogin = true; // Set wrong login flag
                    alert("Wrong username or password.")
                    //loginModal(); // Call this function again
                    console.log(response);
                }
            }
        );
        return loggedIn;
}
function submitForm()
 {
    mylogin();      
 }

$$('.login-modal').on('click', function () {
    if (loggedIn) {
        // load something
    }
    else {
        wrongLogin = false; //reset wrong try flag
        //loginModal(); //call login modal
    }
});
function sendGameResult(user,score){
    $$.post(
            'http://webratd.com/playing/ajax/setScore.php', // path to your php script
            {username: user, score: score}, 
            function (response) {
                console.log(response);
                if (response === 'ok') {
                    // do something if correct
                    console.log("Added game score");
                }
                else {
                    console.log("Failed to add score");
                }
            }
        );
    }
