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

@WebServlet(name = "AddPurchaseServlet", value = "/AddPurchaseServlet")
public class AddPurchaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("getAllStore", StoreRepository.getAll());
        request.setAttribute("getAllCustomer", CustomerRepository.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("PurchasePages/AddPurchase.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int store = Integer.parseInt(request.getParameter("store"));
        int customer = Integer.parseInt(request.getParameter("customer"));
        LocalDateTime purchase_date = LocalDateTime.parse(request.getParameter("date"));
        Purchase s = new Purchase(0, store, customer,purchase_date);
        PurchaseRepository.add(s);

        response.sendRedirect("/WallpaperStore_war/AllPurchaseServlet");
    }
}
