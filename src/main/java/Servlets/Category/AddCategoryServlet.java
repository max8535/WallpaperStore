package Servlets.Category;
import Models.Category;
import Models.Customer;
import Models.Manufacture;
import Repositories.CategoryRepository;
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

@WebServlet(name = "AddCategoryServlet", value = "/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("CategoryPages/AddCategory.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String name = Utils.convertToUTF8(request.getParameter("name"));
            Category s = new Category(0,name);
            CategoryRepository.add(s);
            response.sendRedirect("/WallpaperStore_war/AllCategoryServlet");
    }
}
