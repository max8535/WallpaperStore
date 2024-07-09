package Servlets.Category;

import Repositories.CategoryRepository;
import Repositories.CustomerRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AllCategoryServlet", value = "/AllCategoryServlet")
public class AllCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("All", CategoryRepository.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("CategoryPages/AllCategory.jsp");
        rd.forward(request, response);
    }
}
