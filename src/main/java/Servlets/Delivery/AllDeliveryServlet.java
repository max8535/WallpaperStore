package Servlets.Delivery;

import Repositories.DeliveryRepository;
import Repositories.ItemRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AllDeliveryServlet", value = "/AllDeliveryServlet")
public class AllDeliveryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("All", DeliveryRepository.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("DeliveryPages/AllDelivery.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
