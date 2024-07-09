package Servlets.Manufacture;

import Models.Manufacture;
import Repositories.ManufactureRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateManufactureServlet", value = "/UpdateManufactureServlet")

public class UpdateManufactureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("findManufactureById", ManufactureRepository.findManufactureById(id));
        RequestDispatcher rd = request.getRequestDispatcher("ManufacturePages/UpdateManufacture.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String adress = request.getParameter("adress");
            ManufactureRepository.update(new Manufacture(id, name, adress));

            response.sendRedirect("/WallpaperStore_war/AllManufactureServlet");
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            doGet(request, response);
        }
    }
}
