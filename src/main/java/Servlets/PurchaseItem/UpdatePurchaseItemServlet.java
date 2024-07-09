package Servlets.PurchaseItem;

import Models.Purchase;
import Models.Purchase_item;
import Repositories.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "UpdatePurchaseItemServlet", value = "/UpdatePurchaseItemServlet")
public class UpdatePurchaseItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("getAllPurchase", PurchaseRepository.getAll());
        request.setAttribute("getAllItem", ItemRepository.getAll());
        int purchase_id = Integer.parseInt(request.getParameter("purchase_id"));
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        request.setAttribute("findPurchaseItemById", PurchaseItemRepository.findPurchaseItemById(purchase_id,item_id));
        RequestDispatcher rd = request.getRequestDispatcher("PurchaseItemPages/UpdatePurchaseItem.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int purchase_id = Integer.parseInt(request.getParameter("purchase_id"));
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        PurchaseItemRepository.update(new Purchase_item(purchase_id, item_id, amount));
        response.sendRedirect("/WallpaperStore_war/AllPurchaseItemServlet");
    }
}
