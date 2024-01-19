<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="fontawesome-icon/fontawesome-free-6.4.2-web/css/all.min.css">
    <script src="javascript/jquery-3.7.1.min.js"></script>
    <script src="javascript/bootstrap.bundle.min.js"></script>
    <title>Profile</title>
    <style>
        .side-bar {
            height: 93vh;
            max-width: 25vw;
        }

        .content {
            height: 93vh;
            max-width: 75vw;
        }

        .bg-active {
            background-color: #dee2e6;
        }
    </style>
</head>

<body>
<div class="header row justify-content-between px-5 py-2 bg-light border-bottom">
    <div class="logo">
        CMS
    </div>
    <div class="log-out">
        <div class="dropdown">
            <a class="dropdown-toggle p-2" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
               aria-expanded="false">
                <i class="fa-solid fa-user"></i>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="<%=request.getContextPath()%>/profile"> <i
                        class="fa-solid mr-1 fa-user"></i>User profile</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="login.jsp"><i class="fa-solid mr-1 fa-right-from-bracket"></i>Log
                    out</a>
            </div>
        </div>
    </div>
</div>
<div class="main d-flex">
    <div class="side-bar border-right bg-light">
        <div class="input-group border-bottom p-2">
            <input type="text" id="search" class="form-control" placeholder="Search..." aria-describedby="basic-addon2">
            <div class="input-group-append">
                <button class="btn btn-outline-secondary" type="button"><i
                        class="fa-solid fa-magnifying-glass"></i></button>
            </div>
        </div>
        <a href="<%=request.getContextPath()%>/content" class="border-bottom d-block text-info p-2"><i
                class="fa-solid mr-1 fa-table-cells"></i>View
            contents</a>
        <a href="content.jsp" class="border-bottom d-block text-info p-2"><i
                class="fa-solid mr-1 fa-pen-to-square"></i>Form
            content</a>
    </div>
    <div class="col content p-3 ">
        <p class="text-info"><%=request.getAttribute("info") != null ? request.getAttribute("info") : ""%>
        </p>
        <h2 class="border-bottom p-3">Edit Profile</h2>
        <div class="bg-light mt-4 border rounded">
            <div class="header py-2 pl-3 border-bottom">
                <h4 class="test m-0">Profile</h4>
            </div>
            <div class="bg-white p-3">
                <form method="post" action="<%=request.getContextPath()%>/profile" id="edit-profile-form">
                    <div class="form-group">
                        <label class="font-weight-bold">First name</label>
                        <input type="text" class="form-control" name="firstName"
                               value="<%=request.getAttribute("firstName") != null ? request.getAttribute("firstName") : ""%>"
                               id="firstname" placeholder="Enter the first name"
                               onblur="validateFirstname()"
                               oninput="alertFirstnameChange()"
                        />
                        <p class="text-danger" id="firstnameError"></p>
                    </div>
                    <div class="form-group">
                        <label class="font-weight-bold">Last name</label>
                        <input type="text" class="form-control" id="lastname" name="lastName"
                               value="<%=request.getAttribute("lastName") != null ? request.getAttribute("lastName") : ""%>"
                               placeholder="Enter the last name"
                               onblur="validateLastname()"
                               oninput="alertLastnameChange()"
                        />
                        <p class="text-danger" id="lastnameError"></p>
                    </div>
                    <div class="form-group">
                        <label class="font-weight-bold">Email</label>
                        <input type="email" class="form-control" id="email" name="email"
                               value="<%=request.getAttribute("email")%>" placeholder="Email" readonly/>
                        <p class="text-danger" id="emailError"></p>
                    </div>
                    <div class="form-group">
                        <label class="font-weight-bold">Phone</label>
                        <input type="text" id="phone" class="form-control" name="phone"
                               value="<%=request.getAttribute("phone") != null ? request.getAttribute("phone") : ""%>"
                               placeholder="Enter your phone number"
                               onblur="validatePhone()"
                               oninput="alertPhoneChange()"
                        />
                        <p class="text-danger" id="phoneError"></p>
                    </div>
                    <div class="form-group">
                        <label class="font-weight-bold">Description</label>
                        <textarea class="form-control" id="description" name="description" rows="3" onblur="validateDescription()" oninput="alertDescriptionChange()"><%=request.getAttribute("description") != null ? request.getAttribute("description") : ""%>
                        </textarea>
                        <p class="text-danger" id="descriptionError"></p>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-outline-secondary">Submit Button</button>
                        <button type="button" class="btn btn-outline-secondary" onclick="resetForm()">Reset Button
                        </button>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>
<script src="javascript/editProfile.js"></script>
</body>

</html>
