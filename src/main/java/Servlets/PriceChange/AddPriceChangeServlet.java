package Servlets.PriceChange;

import Models.Price_change;
import Models.Stock;
import Repositories.ItemRepository;
import Repositories.PriceChangeRepository;
import Repositories.StockRepository;
import Utils.Utils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "AddPriceChangeServlet", value = "/AddPriceChangeServlet")
public class AddPriceChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("getAllItem", ItemRepository.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("PriceChangePages/AddPriceChange.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int item = Integer.parseInt(request.getParameter("item"));
        LocalDateTime date = LocalDateTime.parse(request.getParameter("date"));
        double new_price = Double.parseDouble(request.getParameter("price"));
        Price_change s = new Price_change(0, item, date,new_price);
        PriceChangeRepository.add(s);

        response.sendRedirect("/WallpaperStore_war/AllPriceChangeServlet");
    }
}
