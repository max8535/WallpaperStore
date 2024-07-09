package Servlets.Item;

import Models.Item;
import Models.Manufacture;
import Repositories.CategoryRepository;
import Repositories.ItemRepository;
import Repositories.ManufactureRepository;
import Utils.Utils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddItemServlet", value = "/AddItemServlet")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("getAllCategory", CategoryRepository.getAll());
        request.setAttribute("getAllManufacture", ManufactureRepository.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("ItemPages/AddItem.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int category = Integer.parseInt(request.getParameter("category"));
        int manufacture = Integer.parseInt(request.getParameter("manufacture"));
        double price = Double.parseDouble(request.getParameter("price"));
        Item s = new Item(0, category, manufacture,price);
        ItemRepository.add(s);

        response.sendRedirect("/WallpaperStore_war/AllItemsServlet");
    }
}
