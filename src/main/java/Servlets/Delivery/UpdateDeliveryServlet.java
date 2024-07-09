package Servlets.Delivery;

import Models.Delivery;
import Models.Item;
import Repositories.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "UpdateDeliveryServlet", value = "/UpdateDeliveryServlet")
public class UpdateDeliveryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("getAllStore", StoreRepository.getAll());
        request.setAttribute("getAllItem", ItemRepository.getAll());
        int idTemp = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("findDeliveryById", DeliveryRepository.findDeliveryById(idTemp));
        RequestDispatcher rd = request.getRequestDispatcher("DeliveryPages/UpdateDelivery.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int store = Integer.parseInt(request.getParameter("store"));
        int item = Integer.parseInt(request.getParameter("item"));
        LocalDateTime date = LocalDateTime.parse(request.getParameter("date"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        DeliveryRepository.update(new Delivery(id, store, item,date,amount));
        response.sendRedirect("/WallpaperStore_war/AllDeliveryServlet");
    }
}
