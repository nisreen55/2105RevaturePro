window.addEventListener('load', () => 
{
    console.log(sessionStorage.getItem('NAME'));
    console.log(sessionStorage.getItem('ROLE'));
    document.getElementById('logU6').innerHTML = sessionStorage.getItem('NAME');
    document.getElementById('logR6').innerHTML = sessionStorage.getItem('ROLE');
    getTick();
    //document.getElementById("app-den-tick").addEventListener('click', getTicketUser);
})
function getRequests() {
	// this object allows us to make requests
	// and get data back
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() 
    {
		    if (xhttp.readyState == 4 && xhttp.status == 200) 
		    {
               let ourJSON = JSON.parse(xhttp.responseText);
               ourDOMManipulation(ourJSON);
             }
    }
    xhttp.open("GET", "http://localhost:9001/ReProject/json/viewTicket");
    xhttp.send();
}
function getTick()
{	
	fetch('http://localhost:9001/ReProject/json/viewTicket')
		.then(function(daResponse)
		{
			let convertedResponse = daResponse.json();
			return convertedResponse;
		})
		.then(function(daSecondResponse)
		{
			console.log(daSecondResponse);
			ourDOMManipulation(daSecondResponse);
		})
}
function getEmpTick()
	{	
		fetch('http://localhost:9001/ReProject/json/viewEmployeeTicket')
			.then(function(daResponse)
			{
				let convertedResponse = daResponse.json();
				return convertedResponse;
			})
		.then(function(daSecondResponse)
		{
				console.log(daSecondResponse);
				ourDOMManipulation(daSecondResponse);
		})
	}

function ourDOMManipulation(ourJSON)
{
	    let table = document.getElementById("empTable5");
	
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
		let tdButtons = document.createElement("td");
		
		//let newTD6 = document.createElement("td");//select
		
		//step 2: populate creations
		newTH.setAttribute("scope", "row");
		let myTextH = document.createTextNode(ourJSON[i].reimbId);
		let myTextD1 = document.createTextNode(ourJSON[i].reimbAmount);
		let myTextD2 = document.createTextNode(ourJSON[i].reimbType);
		let myTextD3 = document.createTextNode(ourJSON[i].reimbSubmitted);
		let myTextD4 = document.createTextNode(ourJSON[i].reimbAuthor);
		let myTextD5 = document.createTextNode(ourJSON[i].reimbStatus);
		if (ourJSON[i].reimbStatus == "pending") {
            btnApprove = document.createElement("button");
            btnApprove.setAttribute("name", "btnApprove");
            btnApprove.setAttribute("value", ourJSON[i].reimbId);
            btnApprove.style.background = "#72F95C";
            btnApprove.style.color = "black";
            btnApprove.style.fontSize = "10px";
            btnApprove.style.width = "70px";
            btnApprove.innerText = "APPROVE";
            btnApprove.addEventListener('click', appReq);

            btnDeny = document.createElement("button");
            btnDeny.setAttribute("name", "btnDeny");
            btnDeny.setAttribute("value", ourJSON[i].reimbId);
            btnDeny.style.background = "#EE5A42";
            btnDeny.style.color = "black";
            btnDeny.style.fontSize = "10px";
            btnDeny.style.width = "70px";
            btnDeny.innerText = "DENY";
            btnDeny.addEventListener('click', denyReq);
            
            tdButtons.appendChild(btnApprove);
            tdButtons.appendChild(btnDeny);
        }
		//let myTextD6 = document.createSelectNode(ourJSON[i].reimbStatus);
			
		//all appending
		newTH.appendChild(myTextH);
		newTD1.appendChild(myTextD1);
		newTD2.appendChild(myTextD2);
		newTD3.appendChild(myTextD3);
		newTD4.appendChild(myTextD4);
		newTD5.appendChild(myTextD5);
		//newTD6.appendChild(myTextD6);
		
		
		newTR.appendChild(newTH);
		newTR.appendChild(newTD1);
		newTR.appendChild(newTD2);
		newTR.appendChild(newTD3);
		newTR.appendChild(newTD4);
		newTR.appendChild(newTD5);
		newTR.appendChild(tdButtons);
		//newTR.appendChild(newTD6);
       table.appendChild(newTR);
				
		//let newSelection = document.querySelector("#empTable5");
		//newSelection.appendChild(newTR);
	}
}

function appReq(e) 
{
    let target = e.target;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) 
        {
            getRequests();
        }
    }
    xhttp.open("POST", `http://localhost:9001/ReProject/json/appEmployeeTicket`);
    xhttp.setRequestHeader("Content-Type", "application/json");
    let reObj = {reimbId:e.target.value };
    console.log(reObj);
    let jsonObj = JSON.stringify(reObj);
    xhttp.send(jsonObj);
    getTick();
    
}

function denyReq(e) 
{
    let target = e.target;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
         getRequests();
     }
    }
    xhttp.open("POST", `http://localhost:9001/ReProject/json/denEmployeeTicket`);
    xhttp.setRequestHeader("Content-Type", "application/json");
    let reObj = {reimbId:e.target.value };
    console.log(reObj);
    let jsonObj = JSON.stringify(reObj);
    xhttp.send(jsonObj);
    getTick();
    
}





   