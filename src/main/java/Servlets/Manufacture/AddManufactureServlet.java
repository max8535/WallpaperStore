package Servlets.Manufacture;

import Models.Customer;
import Models.Manufacture;
import Repositories.CustomerRepository;
import Repositories.ManufactureRepository;
import Utils.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet(name = "AddManufactureServlet", value = "/AddManufactureServlet")
    public class AddManufactureServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher rd = request.getRequestDispatcher("ManufacturePages/AddManufacture.jsp");
            rd.forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                String name = Utils.convertToUTF8(request.getParameter("name"));
                String adress = Utils.convertToUTF8(request.getParameter("adress"));
                Manufacture s = new Manufacture(0, name, adress);
                ManufactureRepository.add(s);

                response.sendRedirect("/WallpaperStore_war/AllManufactureServlet");
            } catch (Exception e) {
                request.setAttribute("err", e.getMessage());
                doGet(request, response);
            }
        }
    }

