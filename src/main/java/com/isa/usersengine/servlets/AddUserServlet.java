package com.isa.usersengine.servlets;

import com.isa.usersengine.dao.UsersRepositoryDao;
import com.isa.usersengine.dao.UsersRepositoryDaoBean;
import com.isa.usersengine.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet{


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int age = Integer.parseInt(req.getParameter("age"));
        int id = Integer.parseInt(req.getParameter("id"));
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User u = new User();

        u.setAge(age);
        u.setId(id);
        u.setLogin(login);
        u.setName(name);
        u.setPassword(password);

        UsersRepositoryDao newUser = new UsersRepositoryDaoBean();
        newUser.addUser(u);
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<!DOCTYPE html>");
        printWriter.write("<html><body>");
        printWriter.write("id:"+u.getId());
        printWriter.write("name:"+u.getName());
        printWriter.write("age:"+u.getAge());
        printWriter.write("login:"+u.getLogin());
        printWriter.write("password:"+u.getPassword());
        printWriter.write("</body>");
        printWriter.write("</html>");




    }
}
