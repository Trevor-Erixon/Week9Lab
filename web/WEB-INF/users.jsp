<%-- 
    Document   : users
    Created on : Mar 9, 2021, 1:26:36 PM
    Author     : 815822
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week8 Lab</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <div class="container">
            <div class="addForm">
                <h1 class="addUser">Add User</h1>
                <form action="users" method="post">
                    <input class="userInfo" type="email" placeholder="Email" name="email" required>        
                    <input class="userInfo" type="text" placeholder="First Name" name="firstname" required> 
                    <input class="userInfo" type="text" placeholder="Last Name" name="lastname" required>         
                    <input class="userInfo" type="password" placeholder="Password" name="password" required>
                    <select class="userInfo" name="role">
                        <option value="System Admin">System Admin</option>
                        <option value="Regular User">Regular User</option>
                        <option value="Company Admin">Company Admin</option>
                    </select>

                    <input type="hidden" name="action" value="add">
                    <input class="addInput" type="submit" value="Save">
                </form>
            </div>
            
            <div class="manageForm">
                <h1 class="manageUser">Manage Users</h1>
                <table>
                    <tr>
                        <th>Email</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Role</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <tr>
                        <c:forEach items="${users}" var="user">
                            <td>${user.email}</td>
                            <td>${user.firstname}</td>
                            <td>${user.lastname}</td>
                            <td>${user.role}</td>
                            <td><i class="fa fa-pencil"></i></td>
                            <td><i class="fa fa-close" style="color:red"></i></td>
                        </c:foreach>
                    </tr>
                </table>
            </div>
            <div class="editForm">
                <h1 class="editUser">Edit User</h1>
                <form action="users" method="post">
                    <input class="userInfo" type="email" placeholder="Edit Email" name="email" value="${user.email}">        
                    <input class="userInfo" type="text" placeholder="Edit First Name" name="firstname" value="${user.firstname}"> 
                    <input class="userInfo" type="text" placeholder="Edit Last Name" name="lastname" value="${user.lastname}">     
                    <select class="userInfo" name="role">
                        <option value="System Admin">System Admin</option>
                        <option value="Regular User">Regular User</option>
                        <option value="Company Admin">Company Admin</option>
                    </select>

                    <input type="hidden" name="action" value="edit">
                    <input class="addInput" type="submit" value="Save">
                    <input class="Cancel" type="button" value="Cancel">
                </form>     
            </div>

        </div>
    </body>
</html>
