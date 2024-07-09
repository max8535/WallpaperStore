package Servlets.Delivery;

import Repositories.DeliveryRepository;
import Repositories.ItemRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteDeliveryServlet", value = "/DeleteDeliveryServlet")
public class DeleteDeliveryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DeliveryRepository.delete(id);
        response.sendRedirect("/WallpaperStore_war/AllDeliveryServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
