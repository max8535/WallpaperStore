package Servlets.Manufacture;

import Repositories.ManufactureRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteManufactureServlet", value = "/DeleteManufactureServlet")
public class DeleteManufactureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ManufactureRepository.delete(id);
        response.sendRedirect("/WallpaperStore_war/AllManufactureServlet");
    }
}
