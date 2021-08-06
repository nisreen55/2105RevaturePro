//reads user role
function select_changex() 
{
	let act = document.getElementById("logform_action").selectedIndex;
	let actionValue = document.getElementsByTagName("option")[act].value;
}

//validate user name, password
function validLogin() 
{
	let lUser = document.getElementById("logName").value;
	let lPass = document.getElementById("logPass").value;
	///let d = document.getElementsByTagName("option")[z].value;
	if ((lUser === '') || (lPass === '') || (actionValue === ''))
	{
		alert("Sorry, enter all fields");
		console.log("Please enter the required fields...!!!!!!");
		return false;
	} 
	else
		return true;
}

function handleSubmitx() 
{
    if(validLogin)
    {
    	let  currUser= document.getElementById("logName").value;
    	sessionStorage.setItem("NAME",currUser);
    	console.log("current user is : ", currUser);
    	let currAct = document.getElementById("logform_action").selectedIndex;
    	let currActionValue = document.getElementsByTagName("option")[currAct].value;
    	console.log("currActionValue from js");
    	console.log(currActionValue);
    	if(currActionValue=="Employee")
		{
    	   	sessionStorage.setItem("ROLE", "Employee");
    	}
    	else
    	{
   			sessionStorage.setItem("ROLE", "Manager");
   		}
   		console.log("current user role is : ", currActionValue);
   		
    	
   }
   return;
}
