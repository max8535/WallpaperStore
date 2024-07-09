package Servlets.Store;

import Repositories.CustomerRepository;
import Repositories.StoreRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteStoreServlet", value = "/DeleteStoreServlet")
public class DeleteStoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StoreRepository.delete(id);
        response.sendRedirect("/WallpaperStore_war/AllStoreServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
