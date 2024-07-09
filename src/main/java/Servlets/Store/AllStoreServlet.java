package Servlets.Store;

import Repositories.CustomerRepository;
import Repositories.StoreRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AllStoreServlet", value = "/AllStoreServlet")
public class AllStoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("All", StoreRepository.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("StorePages/AllStores.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
