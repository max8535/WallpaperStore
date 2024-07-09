package Servlets.PurchaseItem;

import Repositories.PurchaseItemRepository;
import Repositories.PurchaseRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeletePurchaseItemServlet", value = "/DeletePurchaseItemServlet")

public class DeletePurchaseItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int purchase_id = Integer.parseInt(request.getParameter("purchase_id"));
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        PurchaseItemRepository.delete(purchase_id,item_id);
        response.sendRedirect("/WallpaperStore_war/AllPurchaseItemServlet");
    }
}
