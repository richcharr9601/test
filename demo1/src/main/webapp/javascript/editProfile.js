var flag = true;
function validateFirstname(){
    let firstname = document.getElementById("firstname").value;
    if(firstname === ""){
        document.getElementById("firstnameError").innerHTML = "Firstname cannot be empty";
        flag = false;
    }
    else if(firstname.length < 2 || firstname.length > 50){
        document.getElementById("firstnameError").innerHTML = "Firstname must have at least 2 characters and maximum 50 characters";
        flag = false;
    }
}
function alertFirstnameChange(){
    let alert = document.getElementById("firstnameError").innerHTML;
    if(alert !== "")
    {
        alert = "";
        document.getElementById("firstnameError").innerHTML = alert;
    }
}
function validateLastname(){
    let lastname = document.getElementById("lastname").value;
    if(lastname === ""){
        document.getElementById("lastnameError").innerHTML = "Lastname cannot be empty";
        flag = false;
    }
    else if(lastname.length < 2 || lastname.length > 50){
        document.getElementById("lastnameError").innerHTML = "Lastname must have at least 2 characters and maximum 50 characters";
        flag = false;
    }
}
function alertLastnameChange(){
    let alert = document.getElementById("lastnameError").innerHTML;
    if(alert !== "")
    {
        alert = "";
        document.getElementById("lastnameError").innerHTML = alert;
    }
}
function validatePhone(){
    let phone = document.getElementById("phone").value;
    if(phone === ""){
        document.getElementById("phoneError").innerHTML = "Phone cannot be empty";
        flag = false;
    }
    else if(phone.length < 10 || phone.length > 15){
        document.getElementById("phoneError").innerHTML = "Phone must have at least 10 characters and maximum 15 characters";
        flag = false;
    }
}
function alertPhoneChange(){
    let alert = document.getElementById("phoneError").innerHTML;
    if(alert !== "")
    {
        alert = "";
        document.getElementById("phoneError").innerHTML = alert;
    }
}
function validateDescription(){
    let description = document.getElementById("description").value;
    if(description.length > 150){
        document.getElementById("descriptionError").innerHTML = "Description must have maximum 150 characters";
        flag = false;
    }
}
function alertDescriptionChange(){
    let alert = document.getElementById("descriptionError").innerHTML;
    if(alert !== "")
    {
        alert = "";
        document.getElementById("descriptionError").innerHTML = alert;
    }
}

//reset form
const resetForm = () => {
    document.getElementById("firstname").value = "";
    document.getElementById("lastname").value = "";
    document.getElementById("phone").value = "";
    document.getElementById("description").value = "";
}
const form = document.getElementById("edit-profile-form");
form.addEventListener("submit", submit);
function submit(e){
    validateFirstname();
    validateLastname();
    validatePhone();
    validateDescription();
    if(!flag){
        flag = true;
        e.preventDefault();
    }
}
