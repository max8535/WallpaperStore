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

@WebServlet(name = "AddCustomerServlet", value = "/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("CustomerPages/AddCustomer.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String fio = Utils.convertToUTF8(request.getParameter("fio"));
            String number = Utils.convertToUTF8(request.getParameter("number"));
            String email = Utils.convertToUTF8(request.getParameter("email"));
            Customer s = new Customer(0, fio, number, email);
            CustomerRepository.add(s);

            response.sendRedirect("/WallpaperStore_war/AllCustomerServlet");
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            doGet(request, response);
        }
    }
}
