package Servlets.Review;

import Repositories.DeliveryRepository;
import Repositories.ReviewRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AllReviewServlet", value = "/AllReviewServlet")
public class AllReviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("All", ReviewRepository.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("ReviewPages/AllReview.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
