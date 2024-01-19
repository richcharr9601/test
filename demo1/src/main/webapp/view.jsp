<%@ page import="com.example.demo1.model.Content" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="fontawesome-icon/fontawesome-free-6.4.2-web/css/all.min.css">
    <script src="javascript/jquery-3.7.1.min.js"></script>
    <script src="javascript/bootstrap.bundle.min.js"></script>

    <title>View Content</title>
    <style>
        .side-bar {
            /* height: 100vh; */
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
                <span><%=request.getAttribute("username")%></span>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="<%=request.getContextPath()%>/profile"> <i class="fa-solid mr-1 fa-user"></i>User profile</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/logout"><i class="fa-solid mr-1 fa-right-from-bracket"></i>Log
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
        <a href="" class="border-bottom d-block text-info p-2 bg-active">
            <i class="fa-solid mr-1 fa-table-cells"></i>View contents</a>
        <a href="content.jsp" class="border-bottom d-block text-info p-2"><i class="fa-solid mr-1 fa-pen-to-square"></i>Form
            content</a>
    </div>
    <div class="col content p-3 ">
        <h2 class="border-bottom p-3">View Content</h2>
        <div class="bg-light mt-4 border rounded">
            <div class="header py-2 pl-3 border-bottom">
                <p class="test m-0">View Content List</p>

            </div>
            <div class="bg-white p-3">
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th scope="col" class="text-center">#</th>
                        <th scope="col">Title</th>
                        <th scope="col">Brief</th>
                        <th scope="col" class="text-center">Created Date</th>
                        <th scope="col" class="text-center">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Content> contents = (List<Content>) request.getAttribute("contents");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                            for(int i = 0; i < contents.size(); i++){
                                Content c = contents.get(i);
                        %>
                            <tr>
                                <td class="text-center"><%=i + 1%></td>
                                <td><%=c.getTitle()%></td>
                                <td><%=c.getContent()%></td>
                                <td class="text-center"><%=c.getCreatedDate().format(formatter)%></td>
                                <td class="text-center">
                                    <a href="<%=request.getContextPath()%>/editContent?id=<%=c.getId()%>" class="btn btn-primary">Edit</a>
                                    <a href="<%=request.getContextPath()%>/deleteContent?id=<%=c.getId()%>" class="btn btn-danger">Delete</a>
                                </td>
                            </tr>
                    <% }%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
