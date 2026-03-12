package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import dao.StatementDAO;
import model.Contribution;
import model.Employee;
import model.Statement;
import services.ContributionService;

@WebServlet("/contributions")
public class ContributionServlet extends HttpServlet {
    private ContributionService contributionService;
    private EmployeeDAO employeeDAO;
    private StatementDAO statementDAO;

    public void init() {
        contributionService = new ContributionService();
        employeeDAO = new EmployeeDAO();
        statementDAO = new StatementDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertContribution(request, response);
                    break;
                case "delete":
                    deleteContribution(request, response);
                    break;
                default:
                    listContribution(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void listContribution(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Contribution> listContribution = contributionService.getAllContribution();
        request.setAttribute("listContribution", listContribution);
        request.getRequestDispatcher("/WEB-INF/views/contribution-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employee> listEmployee = employeeDAO.findAll();
        List<Statement> listStatement = statementDAO.findAll();
        request.setAttribute("listEmployee", listEmployee);
        request.setAttribute("listStatement", listStatement);
        request.getRequestDispatcher("/WEB-INF/views/contribution-form.jsp").forward(request, response);
    }

    private void insertContribution(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        int statementId = Integer.parseInt(request.getParameter("statementId"));
        
        Employee employee = employeeDAO.findById(employeeId);
        Statement statement = statementDAO.findById(statementId);
        
        // Service handles the BigDecimal math automatically
        contributionService.createContribution(employee, statement);
        response.sendRedirect("contributions");
    }

    private void deleteContribution(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        contributionService.removeContribution(id);
        response.sendRedirect("contributions");
    }
}