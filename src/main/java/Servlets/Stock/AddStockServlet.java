package Servlets.Stock;

import Models.Delivery;
import Models.Stock;
import Repositories.DeliveryRepository;
import Repositories.ItemRepository;
import Repositories.StockRepository;
import Repositories.StoreRepository;
import Utils.Utils;
import dto.StockDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "AddStockServlet", value = "/AddStockServlet")
public class AddStockServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("getAllItem", ItemRepository.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("StockPages/AddStock.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int item = Integer.parseInt(request.getParameter("item"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String adress = Utils.convertToUTF8(request.getParameter("adress"));
        Stock s = new Stock(0, item, amount,adress);
        StockRepository.add(s);

        response.sendRedirect("/WallpaperStore_war/AllStockServlet");
    }
}
