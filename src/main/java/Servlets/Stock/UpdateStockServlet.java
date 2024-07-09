package Servlets.Stock;

import Models.Delivery;
import Models.Stock;
import Repositories.DeliveryRepository;
import Repositories.ItemRepository;
import Repositories.StockRepository;
import Repositories.StoreRepository;
import Utils.Utils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "UpdateStockServlet", value = "/UpdateStockServlet")
public class UpdateStockServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("getAllItem", ItemRepository.getAll());
        int idTemp = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("findStockById", StockRepository.findStockById(idTemp));
        RequestDispatcher rd = request.getRequestDispatcher("StockPages/UpdateStock.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int item = Integer.parseInt(request.getParameter("item"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String adress = Utils.convertToUTF8(request.getParameter("adress"));
        StockRepository.update(new Stock(id, item, amount,adress));
        response.sendRedirect("/WallpaperStore_war/AllStockServlet");
    }
}
