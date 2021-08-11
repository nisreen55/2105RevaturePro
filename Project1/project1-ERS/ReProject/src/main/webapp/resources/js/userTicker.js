window.addEventListener('load', () => 
{
    //var curname = sessionStorage.getItem('NAME');
    console.log(sessionStorage.getItem('NAME'));
     console.log(sessionStorage.getItem('ROLE'));
    
   // console.log(curname);
    //let rolex = sessionStorage.getItem('ROLE');
      document.getElementById('logU1').innerHTML = sessionStorage.getItem('NAME');
      document.getElementById('logR1').innerHTML = sessionStorage.getItem('ROLE');
    
   GetAllTick();
   //document.getElementById("view-tick").addEventListener('click', getTicketUser);
  // getTicketUser();
})

function getTicketUser()
{
    var cname = sessionStorage.getItem('NAME');
    var xhttp1 = new XMLHttpRequest();
    xhttp1.onreadystatechange = function() 
    {
        if(xhttp1.readyState===4 && xhttp1.status===200)
        {
            let userObj = JSON.parse(xhttp1.responseText);
            console.log("Success parse");
            console.log(userObj);
        }
    };
 	xhttp1.open("POST",`http://localhost:9001/ReProject/json/viewTicket`);
    xhttp1.setRequestHeader("content-type", "application/json");
    let userObj = {name:cname };
    let jsonStr = JSON.stringify(userObj);
    console.log("before parse");
    console.log(jsonStr);
    xhttp1.send(jsonStr); 
    //GetAllTick();
    
}

function GetAllTick()
{	
	fetch('http://localhost:9001/ReProject/json/viewAllTicket')
		.then(function(daResponse){
					let convertedResponse = daResponse.json();
					return convertedResponse;
				})
		.then(function(daSecondResponse){
					console.log(daSecondResponse);
					ourDOMManipulation(daSecondResponse);
				})


}

function ourDOMManipulation(ourJSON){
	
	
	for(let i = 0; i< ourJSON.length; i++){
		////////////CREATE ELEMENTS DYNAMICALLY////////////////
		
		//step1: creating our new element
		let newTR = document.createElement("tr");
		let newTH = document.createElement("th");
		
		let newTD1 = document.createElement("td");
		let newTD2 = document.createElement("td");
		let newTD3 = document.createElement("td");
		let newTD4 = document.createElement("td");
		let newTD5 = document.createElement("td");
		
		
		//step 2: populate creations
		newTH.setAttribute("scope", "row");
		let myTextH = document.createTextNode(ourJSON[i].reimbId);
		let myTextD1 = document.createTextNode(ourJSON[i].reimbAmount);
		let myTextD2 = document.createTextNode(ourJSON[i].reimbType);
		let myTextD3 = document.createTextNode(ourJSON[i].reimbSubmitted);
		let myTextD4 = document.createTextNode(ourJSON[i].reimbAuthor);
		let myTextD5 = document.createTextNode(ourJSON[i].reimbStatus);
		if (ourJSON[i].reimbStatus == "pending")
		{
		            newTD4.style.color = "brown";
		}
		if (ourJSON[i].reimbStatus == "approved")
		{
		            newTD4.style.color = "green";
		}
		if (ourJSON[i].reimbStatus == "denied")
		{
		            newTD4.style.color = "red";
		}
		
		//all appending
		newTH.appendChild(myTextH);
		newTD1.appendChild(myTextD1);
		newTD2.appendChild(myTextD2);
		newTD3.appendChild(myTextD3);
		newTD4.appendChild(myTextD4);
		newTD5.appendChild(myTextD5);
		
		
		newTR.appendChild(newTH);
		newTR.appendChild(newTD1);
		newTR.appendChild(newTD2);
		newTR.appendChild(newTD3);
		newTR.appendChild(newTD4);
		newTR.appendChild(newTD5);
		
		
		
		let newSelection = document.querySelector("#empTable2");
		newSelection.appendChild(newTR);
	}
}


function logout() {
    localStorage.removeItem("jwt");
    Session["NAME"] = null;
    location.reload();
}




   