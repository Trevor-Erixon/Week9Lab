/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Role;
import models.User;
import services.RoleService;
import services.UserService;

/**
 *
 * @author 827637
 */
public class UserServlet extends HttpServlet {
 @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
       UserService userservice = new UserService();
       List<User> users = userservice.getAll(user);
        RoleService roleservice = new RoleService();
        List<Role> roles = roleservice.getAll(role);
     
        request.setAttribute("users", users);
        request.setAttribute("roles", roles);
         getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService us = new UserService();

        String email = request.getParameter("email");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        boolean active = true;

        if (request.getParameter("active") != null && request.getParameter("active").equals("on")) {

            active = false;

        };

        String action = request.getParameter("action");

        User selectedUser = null;
        String message = null;

        try {

            switch (action) {

                case "edit":

                    selectedUser = us.getUser(email);

                    break;

                case "add":

                    if (us.addUser(email, firstName, lastName, password, role, active)) {

                        message = "User added";

                    } else {

                        message = "Could not add new user";

                    }

                    break;

                case "save":

                    if (us.updateUser(email, firstName, lastName, password, role, active)) {

                        message = "User updated";

                    } else {

                        message = "Could not update user";

                    }
                    break;
                case "delete":
                    if (us.deleteUser(email)) {
                        message = "User deleted";
                    } else {
                        message = "Could not delete user";
                    }
                    break;
                default:
                    break;

            }
        } catch (Exception e) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("message", "error");
        }

        request.setAttribute("selectedUser", selectedUser);
        request.setAttribute("message", message);

        displayMainPage(request, response);
    }

}
