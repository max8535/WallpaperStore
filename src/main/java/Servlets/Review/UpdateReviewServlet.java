package Servlets.Review;

import Models.Delivery;
import Models.Review;
import Repositories.*;
import Utils.Utils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "UpdateReviewServlet", value = "/UpdateReviewServlet")
public class UpdateReviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("getAllCustomer", CustomerRepository.getAll());
        request.setAttribute("getAllItem", ItemRepository.getAll());
        int idTemp = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("findReviewById", ReviewRepository.findReviewById(idTemp));
        RequestDispatcher rd = request.getRequestDispatcher("ReviewPages/UpdateReview.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int customer = Integer.parseInt(request.getParameter("customer"));
        int item = Integer.parseInt(request.getParameter("item"));
        LocalDateTime date = LocalDateTime.parse(request.getParameter("date"));
        String text = Utils.convertToUTF8(request.getParameter("text"));
        int rate = Integer.parseInt(request.getParameter("rate"));
        ReviewRepository.update(new Review(id, customer, item,date,text,rate));
        response.sendRedirect("/WallpaperStore_war/AllReviewServlet");
    }
}
