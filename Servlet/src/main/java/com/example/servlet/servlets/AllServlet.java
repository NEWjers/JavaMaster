package com.example.servlet.servlets;

import com.example.servlet.dao.CarDAO;
import com.example.servlet.entity.CarEntity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "allServlet", value = "/all")
public class AllServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        CarDAO carDAO = new CarDAO();
        List<CarEntity> carEntityList = carDAO.getAll();
        PrintWriter out = response.getWriter();
        out.println("<html><head><style>" +
                "table, th, td {" +
                "  border: 1px solid black;" +
                "  border-collapse: collapse;" +
                "}" +
                "</style></head><body>");
        out.println("<h1 style=\"text-align: center\">All Items</h1>");
        out.println("<h2><a style=\"text-align: justify\" href=\"http://localhost:8080\">Home</a>" +
                "    " +
                "<a style=\"text-align: justify\" href=\"match\">Matched Items</a></h2>");
        out.println("<br>");
        out.println("<table style=\"width:100%\"><tr>");
        out.println("<th>Id</th>");
        out.println("<th>Number</th>");
        out.println("<th>Mark</th>");
        out.println("<th>Model</th>");
        out.println("<th>Year</th>");
        out.println("<th>Owner</th>");
        out.println("<th>Address</th>");
        out.println("</tr>");
        carEntityList.forEach(carEntity -> {
            out.println("<tr>");
            out.println("<th>" + carEntity.getId() + "</th>");
            out.println("<th>" + carEntity.getNumber() + "</th>");
            out.println("<th>" + carEntity.getMark() + "</th>");
            out.println("<th>" + carEntity.getModel() + "</th>");
            out.println("<th>" + carEntity.getYear() + "</th>");
            out.println("<th>" + carEntity.getOwner() + "</th>");
            out.println("<th>" + carEntity.getAddress() + "</th>");
            out.println("</tr>");
        });
        out.println("</table>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}