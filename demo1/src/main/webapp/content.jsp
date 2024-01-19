<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="fontawesome-icon/fontawesome-free-6.4.2-web/css/all.min.css">
    <script src="javascript/jquery-3.7.1.min.js"></script>
    <script src="javascript/bootstrap.bundle.min.js"></script>

    <title>Add Content</title>
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
                <a class="dropdown-item" href="<%=request.getContextPath()%>/logout"><i
                        class="fa-solid mr-1 fa-right-from-bracket"></i>Log
                    out</a>
            </div>
        </div>
    </div>
</div>
<div class="main d-flex">
    <div class="side-bar border-right bg-light">
        <div class="input-group border-bottom p-2">
            <input type="text" class="form-control" placeholder="Search..." aria-describedby="basic-addon2">
            <div class="input-group-append">
                <button class="btn btn-outline-secondary" type="button"><i
                        class="fa-solid fa-magnifying-glass"></i></button>
            </div>
        </div>
        <a href="<%=request.getContextPath()%>/content" class="border-bottom d-block text-info p-2"><i
                class="fa-solid mr-1 fa-table-cells"></i>View
            contents</a>
        <a href="content.jsp" class="border-bottom d-block text-info p-2 bg-active"><i
                class="fa-solid mr-1 fa-pen-to-square"></i>Form
            content</a>
    </div>
    <div class="col content p-3 ">
        <h2 class="border-bottom p-3"><%=request.getAttribute("id") == null ? "Add Content" : "Edit Content"%></h2>
        <div class="bg-light mt-4 border rounded">
            <div class="header py-2 pl-3 border-bottom">
                <p class="test m-0">Content Form Elements</p>

            </div>
            <div class="bg-white p-3">
                <form id=add-content-form" method="post" action="<%=request.getContextPath()%><%=request.getAttribute("id") == null ? "/content" : "/editContent?id=" + request.getParameter("id") %>">
                    <div class="form-group">
                        <label class="font-weight-bold">Title</label>
                        <input type="text" id="title" class="form-control" name="title" placeholder="Enter Title"
                               value="<%=request.getAttribute("title") == null ? "" : request.getAttribute("title")%>"
                               onblur="validateTitle()" oninput="alertTitleChange()"/>
                        <p class="text-danger" id="titleError"></p>
                    </div>
                    <div class="form-group">
                        <label class="font-weight-bold">Brief</label>
                        <textarea class="form-control" id="brief" rows="3" name="brief" placeholder="Enter brief"
                                  onblur="validateBrief()" oninput="alertBriefChange()"><%=request.getAttribute("brief") == null ? "" : request.getAttribute("brief")%></textarea>
                        <p class="text-danger" id="briefError"></p>
                    </div>
                    <div class="form-group">
                        <label class="font-weight-bold">Content</label>
                        <textarea class="form-control" id="content" rows="6" name="content" placeholder="Enter content"
                                  onblur="validateContent()" oninput="alertContentChange()"><%=request.getAttribute("content") == null ? "" : request.getAttribute("content")%></textarea>
                        <p class="text-danger" id="contentError"></p>
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
<script src="javascript/addContent.js"></script>
</body>
</html>
