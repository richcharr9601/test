let flag = true;
function validateTitle() {
    const title = document.getElementById("title").value;
    if (title === "") {
        document.getElementById("titleError").innerHTML = "Please enter title";
        flag = false;
    } else if (title.length < 10 || title.length > 200) {
        document.getElementById("titleError").innerHTML = "Title must have at least 10 characters and maximum 200 characters"
        flag = false;
    }
}

function validateBrief() {
    const brief = document.getElementById("brief").value;
    if (brief === "") {
        document.getElementById("briefError").innerHTML = "Please enter brief";
        flag = false;
    } else if (brief.length < 10 || brief.length > 150) {
        document.getElementById("briefError").innerHTML = "Brief must have at least 10 characters and maximum 150 characters";
        flag = false;
    }

}

function alertTitleChange() {
    let alert = document.getElementById("titleError").innerHTML;
    if (alert !== "") {
        alert = "";
        document.getElementById("titleError").innerHTML = alert;
    }
}

function alertBriefChange() {
    let alert = document.getElementById("briefError").innerHTML;
    if (alert !== "") {
        alert = "";
        document.getElementById("briefError").innerHTML = alert;
    }
}
//validate content
function validateContent() {
    const content = document.getElementById("content").value;
    if (content === "") {
        document.getElementById("contentError").innerHTML = "Please enter content";
        flag = false;
    } else if (content.length < 10) {
        document.getElementById("contentError").innerHTML = "Content must have at least 10 characters";
        flag = false;
    }
}

//alert content
function alertContentChange() {
    let alert = document.getElementById("contentError").innerHTML;
    if (alert !== "") {
        alert = "";
        document.getElementById("contentError").innerHTML = alert;
    }
}

const resetForm = () => {
    document.getElementById("title").value = "";
    document.getElementById("brief").value = "";
    document.getElementById("content").value = "";
}

//submit form
const form = document.getElementById("add-content-form");
form.addEventListener("submit", submit);
function submit(e) {
    validateTitle();
    validateBrief();
    validateContent();
    if (!flag) {
        flag = true;
        e.preventDefault();
    }
}