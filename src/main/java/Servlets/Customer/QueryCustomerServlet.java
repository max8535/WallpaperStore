package Servlets.Customer;

import Models.Customer;
import Repositories.CustomerRepository;
import Utils.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static Repositories.CustomerRepository.findCustomerQuery;

@WebServlet(name = "QueryCustomerServlet", value = "/QueryCustomerServlet")
public class QueryCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("getCustomer", CustomerRepository.findCustomerQuery(id));
        request.setAttribute("All", CustomerRepository.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("CustomerPages/AllCustomer.jsp");
        rd.forward(request, response);
    }

}
