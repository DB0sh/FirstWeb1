package controller;

import entity.User;
import repository.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LogIn")
public class LogIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserRepository userRepository = new UserRepository();

        User regularUser = userRepository.findByEmail(email);

        if (regularUser.getEmail().equals(email) && regularUser.getPassword().equals(password)) {
            RequestDispatcher dispatch = req.getRequestDispatcher("/pageTwoUser.jsp");
            dispatch.forward(req, resp);
        } else {
            RequestDispatcher dispatch = req.getRequestDispatcher("/ErrorData.jsp");
            dispatch.forward(req, resp);
        }




        /*List<User> users = userRepository.findAll();  // todo - сделать без файндолл (чтоб не перебирать всех юзеров в БД)  findByEmail

        int j = 0;
        for (User user : users) {     *//* for (int i = 0; i < users.size(); i++) {   User user = users.get(i);*//*
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                RequestDispatcher dispatch = req.getRequestDispatcher("/pageTwoUser.jsp");
                dispatch.forward(req, resp);
                j++;
            }
        }
        if (j == 0) {
            RequestDispatcher dispatch = req.getRequestDispatcher("/ErrorData.jsp");
            dispatch.forward(req, resp);
        }*/

    }
}
