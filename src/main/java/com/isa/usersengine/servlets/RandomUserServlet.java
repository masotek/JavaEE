package com.isa.usersengine.servlets;

import com.isa.usersengine.cdi.RandomUserCDIApplicationDao;
import com.isa.usersengine.cdi.RandomUserCDIRequestDao;
import com.isa.usersengine.cdi.RandomUserCDISessionDao;
import com.isa.usersengine.dao.UsersRepositoryDao;
import com.isa.usersengine.dao.UsersRepositoryDaoBean;
import com.isa.usersengine.domain.User;
import com.isa.usersengine.repository.UsersRepository;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/random-user")
public class RandomUserServlet extends HttpServlet{

    @Inject
    RandomUserCDIRequestDao randomUserCDIRequestDao;
    @Inject
    RandomUserCDISessionDao randomUserCDISessionDao;
    @Inject
    RandomUserCDIApplicationDao randomUserCDIApplicationDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter printWriter = resp.getWriter();

        User user = randomUserCDIRequestDao.getRandomUser();
        printWriter.write("Random User by request scoped:\n");
        printWriter.write("\n\n");
        printWriter.write("Id: "+ user.getId() +"\n");

        User user2 = randomUserCDISessionDao.getRandomUser();
        printWriter.write("Random User by session scoped:\n");
        printWriter.write("\n\n");
        printWriter.write("Id: "+ user2.getId() +"\n");

        User user3 = randomUserCDIApplicationDao.getRandomUser();
        printWriter.write("Random User by application scoped:\n");
        printWriter.write("\n\n");
        printWriter.write("Id: "+ user3.getId() +"\n");



    }




}
