 let btnLogin = document.getElementById("log");
 let uname = document.getElementById("username");
 let pword = document.getElementById("password");
 

 

 btnLogin.onclick = function(){
     signIn.classList.add("active");
     signUp.classList.add("inActive");
 }

 btnSignUp.onclick = function(){
    signIn.classList.remove("active");
    signUp.classList.remove("inActive");
}