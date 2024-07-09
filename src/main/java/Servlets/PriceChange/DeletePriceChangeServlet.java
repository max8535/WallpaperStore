package Servlets.PriceChange;

import Repositories.PriceChangeRepository;
import Repositories.StockRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeletePriceChangeServlet", value = "/DeletePriceChangeServlet")
public class DeletePriceChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        PriceChangeRepository.delete(id);
        response.sendRedirect("/WallpaperStore_war/AllPriceChangeServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
