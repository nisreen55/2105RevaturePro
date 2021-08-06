window.addEventListener('load', () => 
{
    console.log(sessionStorage.getItem('NAME'));
    console.log(sessionStorage.getItem('ROLE'));
    document.getElementById('logU2').innerHTML = sessionStorage.getItem('NAME');
    document.getElementById('logR2').innerHTML = sessionStorage.getItem('ROLE');
    getTick();
    //document.getElementById("app-den-tick").addEventListener('click', getTicketUser);
})

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
		let newTD6 = document.createElement("td");//select
		
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
		            newTD5.style.color = "brown";
		}
		if (ourJSON[i].reimbStatus == "approved")
		{
		            newTD5.style.color = "green";
		}
		if (ourJSON[i].reimbStatus == "denied")
		{
		            newTD5.style.color = "red";
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
		//newTR.appendChild(newTD6);
				
		let newSelection = document.querySelector("#empTable3");
		newSelection.appendChild(newTR);
	}
}







   