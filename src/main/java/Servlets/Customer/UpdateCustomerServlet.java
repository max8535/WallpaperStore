package Servlets.Customer;

import Models.Customer;
import Models.Manufacture;
import Repositories.CustomerRepository;
import Repositories.ManufactureRepository;
import Utils.Utils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateCustomerServlet", value = "/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("findCustomerById", CustomerRepository.findCustomerById(id));
        RequestDispatcher rd = request.getRequestDispatcher("CustomerPages/UpdateCustomer.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fio = Utils.convertToUTF8(request.getParameter("fio"));
        String number = request.getParameter("number");
        String mail = request.getParameter("mail");
        CustomerRepository.update(new Customer(id, fio, number,mail));
        response.sendRedirect("/WallpaperStore_war/AllCustomerServlet");
    }
}
