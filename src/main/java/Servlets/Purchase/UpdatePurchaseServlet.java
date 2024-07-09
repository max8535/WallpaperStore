package Servlets.Purchase;

import Models.Delivery;
import Models.Purchase;
import Repositories.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "UpdatePurchaseServlet", value = "/UpdatePurchaseServlet")
public class UpdatePurchaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("getAllStore", StoreRepository.getAll());
        request.setAttribute("getAllCustomer", CustomerRepository.getAll());
        int idTemp = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("findPurchaseById", PurchaseRepository.findPurchaseById(idTemp));
        RequestDispatcher rd = request.getRequestDispatcher("PurchasePages/UpdatePurchase.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int store = Integer.parseInt(request.getParameter("store"));
        int customer = Integer.parseInt(request.getParameter("customer"));
        LocalDateTime date = LocalDateTime.parse(request.getParameter("date"));
        PurchaseRepository.update(new Purchase(id, store, customer,date));
        response.sendRedirect("/WallpaperStore_war/AllPurchaseServlet");
    }
}
