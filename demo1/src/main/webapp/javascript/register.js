var flag = true;
function validateUsername(){
    var username = document.getElementById("username").value;
    if(username == ""){
        document.getElementById("validate-username").innerHTML = "Username cannot be empty";
        flag = false;
    }
    else if(username.length < 5 || username.length > 50){
        document.getElementById("validate-username").innerHTML = "Username must have at least 5 characters and maximum 50 characters";
        flag = false;
    }
}

function validateEmail(){
    var email = document.getElementById("email").value;
    if(email == ""){
        document.getElementById("validate-email").innerHTML = "E-mail cannot be empty";
        flag = false;
    }
    // regex email
    // else if(!email.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)){
    //     document.getElementById("validate-email").innerHTML = "E-mail is invalid";
    // }
    // length not small then 5
    else if(email.length < 5){
        document.getElementById("validate-email").innerHTML = "E-mail must have at least 5 characters";
        flag = false;
    }
}

function validatePassword(){
    var password = document.getElementById("password").value;
    if(password == ""){
        document.getElementById("validate-password").innerHTML = "Password cannot be empty";
        flag = false;
    }
    else if(password.length < 8 || password.length > 30){
        document.getElementById("validate-password").innerHTML = "Password must have at least 8 characters and maximum 30 characters";
        flag = false;
    }

}

function validateRePassword(){
    var password = document.getElementById("password").value;
    var rePassword = document.getElementById("rePassword").value;
    if(rePassword == ""){
        document.getElementById("validate-rePassword").innerHTML = "Re-Password cannot be empty";
        flag = false;
    }
    else if(rePassword != password){
        document.getElementById("validate-rePassword").innerHTML = "Re-Password is not correct";
        flag = false;
    }
}


function alertUsernameChange(){
    var alert = document.getElementById("validate-username").innerHTML;
    if(alert != "")
    {
        alert = "";
        document.getElementById("validate-username").innerHTML = alert;
    }
}

function alertPasswordChange(){
    var alert = document.getElementById("validate-password").innerHTML;
    if(alert != "")
    {
        alert = "";
        document.getElementById("validate-password").innerHTML = alert;
    }
}

function alertEmailChange(){
    var alert = document.getElementById("validate-email").innerHTML;
    if(alert != "")
    {
        alert = "";
        document.getElementById("validate-email").innerHTML = alert;
    }
}

function alertRePasswordChange(){
    var alert = document.getElementById("validate-rePassword").innerHTML;
    if(alert != "")
    {
        alert = "";
        document.getElementById("validate-rePassword").innerHTML = alert;
    }
}

function onSubmit(e){
    flag = true;
    e.preventDefault();
    validateUsername();
    validateEmail();
    validatePassword();
    validateRePassword();
    if(!flag){
        return false;
    }
    let data = JSON.parse(localStorage.getItem("data"));
    const user = {
        firstname: "",
        lastname: "",
        username: document.getElementById("username").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
        phone: "",
        description: ""
    };
    data.push(user);
    localStorage.setItem("data", JSON.stringify(data));
    window.location.href = "login.html";
}