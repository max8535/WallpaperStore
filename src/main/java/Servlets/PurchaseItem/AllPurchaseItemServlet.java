package Servlets.PurchaseItem;

import Repositories.PurchaseItemRepository;
import Repositories.PurchaseRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AllPurchaseItemServlet", value = "/AllPurchaseItemServlet")
public class AllPurchaseItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("All", PurchaseItemRepository.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("PurchaseItemPages/AllPurchaseItem.jsp");
        rd.forward(request, response);
    }
}
