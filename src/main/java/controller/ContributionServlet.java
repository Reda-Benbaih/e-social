package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import dao.EmployeeDAO;
import dao.StatementDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import model.Contribution;
import model.Employee;
import model.Statement;
import services.ContributionService;

@WebServlet("/contributions")
public class ContributionServlet extends HttpServlet {

    private ContributionService contributionService = new ContributionService();
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private StatementDAO statementDAO = new StatementDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Contribution> contributions = contributionService.getAllContribution();

        request.setAttribute("contributions", contributions);

        request.getRequestDispatcher("/WEB-INF/views/contributions.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        int statementId = Integer.parseInt(request.getParameter("statementId"));

        BigDecimal employeeContribution =
                new BigDecimal(request.getParameter("employeeContribution"));

        BigDecimal employerContribution =
                new BigDecimal(request.getParameter("employerContribution"));

        Employee employee = employeeDAO.findById(employeeId);
        Statement statement = statementDAO.findById(statementId);

       
        contributionService.createContribution(employee, statement);

        response.sendRedirect("contributions");
    }
}