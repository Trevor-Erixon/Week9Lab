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
                
            </div>
            
            <h1>Edit User</h1> 
            
        </div>
    </body>
</html>
