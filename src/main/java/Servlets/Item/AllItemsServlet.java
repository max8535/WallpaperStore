package Servlets.Item;

import Repositories.ItemRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AllItemsServlet", value = "/AllItemsServlet")
public class AllItemsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("All", ItemRepository.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("ItemPages/AllItems.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
