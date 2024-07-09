package Servlets.Item;

import Models.Customer;
import Models.Item;
import Repositories.CategoryRepository;
import Repositories.CustomerRepository;
import Repositories.ItemRepository;
import Repositories.ManufactureRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateItemServlet", value = "/UpdateItemServlet")
public class UpdateItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("getAllCategory", CategoryRepository.getAll());
        request.setAttribute("getAllManufacture", ManufactureRepository.getAll());
        int idTemp = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("findItemById", ItemRepository.findItemById(idTemp));
        RequestDispatcher rd = request.getRequestDispatcher("ItemPages/UpdateItem.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int category = Integer.parseInt(request.getParameter("category"));
        int manufacture = Integer.parseInt(request.getParameter("manufacture"));
        double price = Double.parseDouble(request.getParameter("price"));
        ItemRepository.update(new Item(id, category, manufacture,price));
        response.sendRedirect("/WallpaperStore_war/AllItemsServlet");
    }
}
