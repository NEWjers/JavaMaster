package com.example.servlet.servlets;

import com.example.servlet.dao.CarDAO;
import com.example.servlet.entity.CarEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addCarServlet", value = "/add")
public class AddCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        CarEntity newEntity = new CarEntity(request.getParameter("number"),
                request.getParameter("mark"),
                request.getParameter("model"),
                Long.parseLong(request.getParameter("year")),
                request.getParameter("owner"),
                request.getParameter("address"));
        CarDAO carDAO = new CarDAO();
        carDAO.create(newEntity);

        response.sendRedirect("http://localhost:8080/all");
    }
}
