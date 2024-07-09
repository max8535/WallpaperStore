package Servlets.PriceChange;

import Repositories.PriceChangeRepository;
import Repositories.StockRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AllPriceChangeServlet", value = "/AllPriceChangeServlet")
public class AllPriceChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("All", PriceChangeRepository.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("PriceChangePages/AllPriceChange.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
