gamelength=30;
timerID=null
var playing=false;
var numholes=4*4;
var currentpos=-1;

function clrholes() {
	for(var k=0;k<numholes;k++)
	{
		var a=document.getElementById("button"+k);
		a.setAttribute("style", "background-image:url('button-inactive.png')");
		a.setAttribute("data-checked","0");
	}

}

function stoptimer() {
	if(playing)
		clearTimeout(timerID);
}



function showtime(remtime) {
	document.cpanel.timeleft.value=remtime;
	if(playing) {
		if(remtime==0) {
			stopgame();
			return;
		}
		else {
			temp=remtime-1;
			timerID=setTimeout("showtime(temp)",1000);
		}
	}
}
function stopgame() {
	stoptimer();
	playing=false;
	document.cpanel.timeleft.value=0;
	clrholes();
	sendGameResult("Iolanta-Hotoboc",totalhits)
	alert('Game Over.\nYour score is:  '+totalhits);

}
function play() {
	stoptimer();
	if(playing) {
		stopgame();
		return;
	}
	playing=true;
	clrholes();
	totalhits=0;
	document.cpanel.score.value=totalhits;
	launch();
	showtime(gamelength);
}


function launch() {
	var launched=false;
	while(!launched) {
		mynum=random();
		if(mynum!=currentpos) {
			document.getElementById("button"+mynum).setAttribute("data-checked","1");
			document.getElementById("button"+mynum).setAttribute("style","background-image:url('button-active.png')");
			currentpos=mynum;
			launched=true;
		}
	}
}


function hithead(id) {
	if(playing==false) {
		clrholes();
		return;
	}
	if(currentpos!=id) {
		totalhits+=-1;
		document.cpanel.score.value=totalhits;
	}
	else {
		totalhits+=1;
		document.cpanel.score.value=totalhits;
		launch();
		document.getElementById("button"+id).setAttribute("data-checked","0");
		document.getElementById("button"+id).setAttribute("style","background-image:url('button-inactive.png')");
	}
}

function random() {
	return(Math.floor(Math.random()*100%numholes));
}
//Donate Form

var donation;

function getdonation(x)
{
	donation=x;
}

function setdonation()
{
	var x;
	x=document.getElementById('other').value;
	if(+x!=0)
		donation=+x;

}