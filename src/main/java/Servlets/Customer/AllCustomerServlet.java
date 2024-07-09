package Servlets.Customer;

import Repositories.CustomerRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AllCustomerServlet", value = "/AllCustomerServlet")
public class AllCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("All", CustomerRepository.getAll());
            RequestDispatcher rd = request.getRequestDispatcher("CustomerPages/AllCustomer.jsp");
            rd.forward(request, response);

    }
}
