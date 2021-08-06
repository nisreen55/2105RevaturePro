window.addEventListener('load', () => 
{
     
  
})

function addTicket()
{
    var xhttp2 = new XMLHttpRequest();
    xhttp2.onreadystatechange = function() 
    {
        if(xhttp2.readyState===4 && xhttp2.status===200)
        {
            let tickObj = JSON.parse(xhttp2.responseText);
            console.log("Success parse");
            console.log(tickObj);
        }
    };
 	xhttp2.open("POST",`http://localhost:9001/ReProject/json/adTicket`);
    xhttp2.setRequestHeader("content-type", "application/json");
    
    let rid=document.getElementById("rId").value;  
    let reimbAmnt=document.getElementById("rAmount").value;
    let reimbDesc=document.getElementById("rDesc").value;
    let reimbType=document.getElementById("rType").value;
    
    let reimbObj = {reimbId:rid, 
    			   reimbAmount:reimbAmnt,
    			   reimbDes:reimbDesc,
    			   reimbType:reimbType};
    			   
    let reimStr = JSON.stringify(reimbObj);
    console.log("before parse");
    console.log(reimStr);
    xhttp2.send(reimStr);
    //GetAllTicket(); 
}

function GetAllTicket()
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
		
		
		//step 2: populate creations
		newTH.setAttribute("scope", "row");
		let myTextH = document.createTextNode(ourJSON[i].reimbId);
		let myTextD1 = document.createTextNode(ourJSON[i].reimbAmount);
		let myTextD2 = document.createTextNode(ourJSON[i].reimbType);
		let myTextD3 = document.createTextNode(ourJSON[i].reimbSubmitted);
		let myTextD4 = document.createTextNode(ourJSON[i].reimbStatus);
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
		
		
		newTR.appendChild(newTH);
		newTR.appendChild(newTD1);
		newTR.appendChild(newTD2);
		newTR.appendChild(newTD3);
		newTR.appendChild(newTD4);
		
		
		let newSelection = document.querySelector("#empTable");
		newSelection.appendChild(newTR);
	}
}







   