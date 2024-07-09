package Servlets.Store;

import Models.Customer;
import Models.Store;
import Repositories.CustomerRepository;
import Repositories.StoreRepository;
import Utils.Utils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddStoreServlet", value = "/AddStoreServlet")
public class AddStoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("StorePages/AddStore.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = Utils.convertToUTF8(request.getParameter("name"));
        String number = Utils.convertToUTF8(request.getParameter("number"));
        String adress = Utils.convertToUTF8(request.getParameter("adress"));
        int open_time = Integer.parseInt(request.getParameter("open_time"));
        int close_time = Integer.parseInt(request.getParameter("close_time"));
        Store s = new Store(0, name, number, adress,open_time,close_time);
        StoreRepository.add(s);

        response.sendRedirect("/WallpaperStore_war/AllStoreServlet");
    }
}
