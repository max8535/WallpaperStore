package Servlets.PurchaseItem;

import Models.Purchase;
import Models.Purchase_item;
import Repositories.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "AddPurchaseItemServlet", value = "/AddPurchaseItemServlet")
public class AddPurchaseItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("getAllPurchase", PurchaseRepository.getAll());
        request.setAttribute("getAllItem", ItemRepository.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("PurchaseItemPages/AddPurchaseItem.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int purchase = Integer.parseInt(request.getParameter("purchase"));
        int item = Integer.parseInt(request.getParameter("item"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        Purchase_item s = new Purchase_item(purchase, item, amount);
        PurchaseItemRepository.add(s);

        response.sendRedirect("/WallpaperStore_war/AllPurchaseItemServlet");
    }
}
