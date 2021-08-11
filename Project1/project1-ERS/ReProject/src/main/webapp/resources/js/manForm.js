
window.onload = function() {
    getRequests();
}
/*
 * Used to request the data for the table on the admin home page.
 */
function getRequests() {
	// this object allows us to make requests
	// and get data back
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
				
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let list = JSON.parse(xhttp.responseText);
			// JSON parse turns it into an object
            setValues(list);
        }
    }
	// create a connection (method, url, boolean asynch or not)
    xhttp.open("GET", "http://localhost:9001/ReProject/json/viewTicket");
    xhttp.send();
}
/*
 * Used to set the values in the table (populate the table)
 */
function setValues(list) 
{
    
    let table = document.getElementById("reimbtable");
    table.innerHTML = `<tr>
                       <th>Reimb Id</th>
                       <th>Author Name</th>
                       <th>Status</th>
                       <th></th>
                       </tr>`
    
    for (r in list) 
    {
        let trNewRow = document.createElement("tr");
        let tdReimb = document.createElement("td");
        let tdName = document.createElement("td");
        let tdStatus = document.createElement("td");
        let tdButtons = document.createElement("td");
      
        
        // Author Name
        tdReimb.innerHTML = list[r].reimbId;
        tdName.innerHTML = list[r].reimbAuthor;
        tdStatus.innerHTML = list[r].reimbStatus;
        if (list[r].reimbStatus == "pending") {
            btnApprove = document.createElement("button");
            btnApprove.setAttribute("name", "btnApprove");
            btnApprove.setAttribute("value", list[r].reimbId);
            btnApprove.style.width = "100px";
            btnApprove.style.background = "green";
            btnApprove.style.color = "white";
            btnApprove.style.fontSize = "16px";
            btnApprove.innerText = "APPROVE";
            btnApprove.addEventListener('click', appRequest);

            btnDeny = document.createElement("button");
            btnDeny.setAttribute("name", "btnDeny");
            btnDeny.setAttribute("value", list[r].reimbId);
            btnDeny.style.width = "100px";
            btnDeny.style.background = "red";
            btnDeny.style.color = "white";
            btnDeny.style.fontSize = "16px";
            btnDeny.innerText = "DENY";
            btnDeny.addEventListener('click', denyRequest);
            
            tdButtons.appendChild(btnApprove);
            tdButtons.appendChild(btnDeny);
        }
            
        
      trNewRow.appendChild(tdReimb);
      trNewRow.appendChild(tdName);
      trNewRow.appendChild(tdStatus);
      trNewRow.appendChild(tdButtons);
      table.appendChild(trNewRow);
      
      //let newSelection = document.querySelector("#appDentable");
	  //newSelection.appendChild(newTR);
  }  
}
//   	xhttp6.open("POST",`http://localhost:9001/ReProject/json/viewETicket`);

function appRequest(e) 
{
    let target = e.target;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            getRequests();
        }
    }
    xhttp.open("POST", `http://localhost:9001/ReProject/json/appEmployeeTicket`);
    xhttp.setRequestHeader("Content-Type", "application/json");
    let reObj = {reimbId:e.target.value };
    console.log(reObj);
    let jsonObj = JSON.stringify(reObj);
    xhttp.send(jsonObj);
}

function denyRequest(e) 
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
}