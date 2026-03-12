package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.EmployerDAO;
import dao.StatementDAO;
import model.Employer;
import model.Statement;

@WebServlet("/statements")
public class StatementServlet extends HttpServlet {
    private StatementDAO statementDAO;
    private EmployerDAO employerDAO;

    public void init() {
        statementDAO = new StatementDAO();
        employerDAO = new EmployerDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertStatement(request, response);
                    break;
                case "delete":
                    deleteStatement(request, response);
                    break;
                default:
                    listStatements(request, response);
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

    private void listStatements(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Statement> listStatement = statementDAO.findAll();
        request.setAttribute("listStatement", listStatement);
        request.getRequestDispatcher("/WEB-INF/views/statement-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employer> listEmployer = employerDAO.findAll();
        request.setAttribute("listEmployer", listEmployer);
        request.getRequestDispatcher("/WEB-INF/views/statement-form.jsp").forward(request, response);
    }

    private void insertStatement(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int employerId = Integer.parseInt(request.getParameter("employerId"));
        int month = Integer.parseInt(request.getParameter("month"));
        int year = Integer.parseInt(request.getParameter("year"));
        
        Employer employer = employerDAO.findById(employerId);
        // StatementDate is set to the current date of creation
        Statement newStatement = new Statement(employer, month, year, LocalDate.now());
        
        statementDAO.save(newStatement);
        response.sendRedirect("statements");
    }

    private void deleteStatement(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        statementDAO.remove(id);
        response.sendRedirect("statements");
    }
}