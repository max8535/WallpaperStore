package Servlets.Manufacture;

import Repositories.ManufactureRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AllManufactureServlet", value = "/AllManufactureServlet")
public class AllManufactureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("All", ManufactureRepository.getAll());
        RequestDispatcher rd = req.getRequestDispatcher("ManufacturePages/AllManufacture.jsp");
        rd.forward(req, resp);
    }
}
