package Servlets.Stock;

import Repositories.DeliveryRepository;
import Repositories.StockRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AllStockServlet", value = "/AllStockServlet")
public class AllStockServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("All", StockRepository.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("StockPages/AllStock.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
