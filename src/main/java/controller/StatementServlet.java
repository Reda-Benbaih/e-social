package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import dao.EmployerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import model.Statement;
import model.Employer;
import services.StatementService;

@WebServlet("/statements")
public class StatementServlet extends HttpServlet {

    private StatementService statementService = new StatementService();
    private EmployerDAO employerDAO = new EmployerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Statement> statements = statementService.getAllStatement();

        request.setAttribute("statements", statements);

        request.getRequestDispatcher("/WEB-INF/views/statements.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int employerId = Integer.parseInt(request.getParameter("employerId"));
        int month = Integer.parseInt(request.getParameter("month"));
        int year = Integer.parseInt(request.getParameter("year"));

        Employer employer = employerDAO.findById(employerId);

        statementService.addStatement(employer,month,year,LocalDate.now());

        response.sendRedirect("statements");
    }
}