let flag = true;
function validateUsername(e) {
    let username = document.getElementById("username").value;
    if (username === "") {
        document.getElementById("validate-username").innerHTML = "Username cannot be empty";
        flag = false;
    }
    else if (username.length < 5 || username.length > 50) {
        document.getElementById("validate-username").innerHTML = "Username must have at least 5 characters and maximum 50 characters";
        flag = false;
    }
}

function validatePassword() {
    let password = document.getElementById("password").value;
    if (password === "") {
        document.getElementById("validate-password").innerHTML = "Password cannot be empty";
        flag = false;
    }
    else if (password.length < 8 || password.length > 30) {
        document.getElementById("validate-password").innerHTML = "Password must have at least 8 characters and maximum 30 characters";
        flag = false;
    }

}
function alertUsernameChange() {
    let alert = document.getElementById("validate-username").innerHTML;
    if (alert !== "") {
        alert = "";
        document.getElementById("validate-username").innerHTML = alert;
    }
}

function alertPasswordChange() {
    let alert = document.getElementById("validate-password").innerHTML;
    if (alert !== "") {
        alert = "";
        document.getElementById("validate-password").innerHTML = alert;
    }
}

const form = document.getElementById("login-form");
form.addEventListener("submit", submit);
function submit(e) {

    validateUsername();
    validatePassword();
    if (!flag) {
        flag = true;
        e.preventDefault();
    }
}

//get input on change
