package Servlets.Purchase;

import Repositories.DeliveryRepository;
import Repositories.PurchaseRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AllPurchaseServlet", value = "/AllPurchaseServlet")
public class AllPurchaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("All", PurchaseRepository.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("PurchasePages/AllPurchase.jsp");
        rd.forward(request, response);
    }
}
