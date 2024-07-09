package Servlets.Category;

import Models.Category;
import Models.Customer;
import Repositories.CategoryRepository;
import Repositories.CustomerRepository;
import Utils.Utils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateCategoryServlet", value = "/UpdateCategoryServlet")
public class UpdateCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("findCategoryById", CategoryRepository.findCategoryById(id));
        RequestDispatcher rd = request.getRequestDispatcher("CategoryPages/UpdateCategory.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = Utils.convertToUTF8(request.getParameter("name"));
        CategoryRepository.update(new Category(id, name));
        response.sendRedirect("/WallpaperStore_war/AllCategoryServlet");
    }
}
