package Servlets.Stock;

import Repositories.DeliveryRepository;
import Repositories.StockRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteStockServlet", value = "/DeleteStockServlet")
public class DeleteStockServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StockRepository.delete(id);
        response.sendRedirect("/WallpaperStore_war/AllStockServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
