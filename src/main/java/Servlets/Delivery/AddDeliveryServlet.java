package Servlets.Delivery;

import Models.Delivery;
import Models.Item;
import Repositories.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "AddDeliveryServlet", value = "/AddDeliveryServlet")
public class AddDeliveryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("getAllStore", StoreRepository.getAll());
        request.setAttribute("getAllItem", ItemRepository.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("DeliveryPages/AddDelivery.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int store = Integer.parseInt(request.getParameter("store"));
        int item = Integer.parseInt(request.getParameter("item"));
        LocalDateTime delivery_date = LocalDateTime.parse(request.getParameter("date"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        Delivery s = new Delivery(0, store, item,delivery_date,amount);
        DeliveryRepository.add(s);

        response.sendRedirect("/WallpaperStore_war/AllDeliveryServlet");
    }
}
