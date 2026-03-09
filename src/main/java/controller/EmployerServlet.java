package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import model.Employer;
import services.EmployerService;

@WebServlet("/employers")
public class EmployerServlet extends HttpServlet {

    private EmployerService employerService = new EmployerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Employer> employers = employerService.getAllEmployers();

        request.setAttribute("employers", employers);

        request.getRequestDispatcher("/WEB-INF/views/Employers.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String socialReason = request.getParameter("socialReason");
        String activity = request.getParameter("activity");

        Employer employer = new Employer();
        employer.setSocialReason(socialReason);
        employer.setActivity(activity);

        employerService.addEmployer(socialReason, activity);

        response.sendRedirect("employers");
    }
}