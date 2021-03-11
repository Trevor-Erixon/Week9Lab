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
                <c:if test="${activeUser == null}">
                <h1 class="addUser">Add User</h1>
                    <form action="users" method="post">
                        <input class="userInfo" type="email" placeholder="Email" name="email" required>
                        <input class="userInfo" type="text" placeholder="First Name" name="firstname" required> 
                        <input class="userInfo" type="text" placeholder="Last Name" name="lastname" required>         
                        <input class="userInfo" type="password" placeholder="Password" name="password" required>
                        <select class="userInfo" name="role">
                            <option value="System admin">System Admin</option>
                            <option value="Regular user">Regular User</option>
                            <option value="Company admin">Company Admin</option>
                        </select>

                        <input type="hidden" name="action" value="add">
                        <input class="addInput" type="submit" value="Add">
                    </form>
                </c:if>
            </div>
            
            <div class="manageForm">
                <h1 class="manageUser">Manage Users</h1>
                <table>
                    <tr>
                        <th>Email</th>
                        <th>Active</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Role</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <tr>
                        <c:forEach items="${users}" var="user">
                            <td>${user.email}</td>
                            <td>
                                <input class="userInfo chActive" type="checkbox" name="isActive" checked>                          
                            </td>
                            <td>${user.firstname}</td>
                            <td>${user.lastname}</td>
                            <td>${user.role.roleID}</td>
<!--                            <c:if test="${user.role.roleID eq 'System admin'}">
                                <td>System Admin</td>
                            </c:if>
                                <c:if test="${user.role.roleID eq 'Regular user'}">
                                <td>Regular User</td>
                            </c:if>
                                <c:if test="${user.role.roleID eq 'Company admin'}">
                                <td>Company Admin</td>
                            </c:if>-->
                            
                            <td>
                                <form action="users" method="post" >
                                    <input type="submit" name="edit" value="Edit">
                                    <input type="hidden" name="action" value="edit">
                                    <!--<i class="fa fa-pencil editBtn"></i>-->
                                </form>
                            </td>
                            <td>
                                <form action="users" method="post" >
                                    <input type="submit" name="delete" value="Delete">
                                    <input type="hidden" name="action" value="delete">
                                    <!--<i class="fa fa-close delBtn" style="color:red"></i>-->
                                </form>
                            </td>
                        </c:foreach>
                    </tr>
                </table>
            </div>
                           
            <div class="editForm">
                <c:if test="${activeUser != null}">
                <h1 class="editUser">Edit User</h1>
                    <form action="users" method="post">
                        <input class="userInfo" type="email" placeholder="Edit Email" name="email" value="${user.email}" readonly>
                        <input class="userInfo" type="text" placeholder="Edit First Name" name="firstname" value="${user.firstname}"> 
                        <input class="userInfo" type="text" placeholder="Edit Last Name" name="lastname" value="${user.lastname}">     
                        <input class="userInfo" type="password" placeholder="Password" name="password" value="${user.password}">
                        <select class="userInfo" name="role" value="${editRole}">
                            <c:if test="${user.role.roleID eq 'System admin'}">
                                <option value="System admin">System Admin</option>
                            </c:if>
                            <c:if test="${user.role.roleID ne 'Regular user'}">
                                <option value="Regular user">Regular User</option>
                            </c:if>
                            <c:if test="${user.role.roleID ne 'Company admin'}">
                                <option value="Company admin">Company Admin</option>
                            </c:if>
                        </select>

                        <input type="hidden" name="action" value="edit">
                        <input class="addInput" type="submit" value="Edit">
                        <input type="hidden" name="action" value="cancel">
                        <input class="Cancel" type="submit" value="Cancel">
                    </form>  
            </c:if>
            </div>

        </div>
    </body>
</html>
