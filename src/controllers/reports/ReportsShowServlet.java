package controllers.reports;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.Favorite;
import models.Report;
import utils.DBUtil;

/**
 * Servlet implementation class ReportsShowServlet
 */
@WebServlet("/reports/show")
public class ReportsShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Report r = em.find(Report.class, Integer.parseInt(request.getParameter("id")));

        // いいね数カウントのクエリを実行
        long favorites_count = (long) em.createNamedQuery("getFavoritesCount", Long.class).setParameter("report", r)
                .getSingleResult();
       // List<Favorite> favorite_names = em.createNamedQuery("getFavoritesNames", Favorite.class)
                //.setParameter("report", r).getResultList();
        //この日報をいいねした人たちを取得
        List<Employee> favorited_employee_list = r.getFavorited_employee_list();
        Employee e = (Employee) request.getSession().getAttribute("login_employee");
        List<Favorite> favoritesOfAttension = em.createNamedQuery("getFavoritesOfAttension", Favorite.class)
                .setParameter("employee", e).setParameter("report", r).getResultList();
        int count = favoritesOfAttension.size();

        em.close();
        request.getSession().setAttribute("report_id", r.getId());
        request.setAttribute("report", r);
        request.setAttribute("_token", request.getSession().getId());
        // 「favorites_count」としてビューに渡す
        request.setAttribute("favorites_count", favorites_count);
        // 「favorite_names」としてビューに渡す
        request.setAttribute("favorited_employee_list",favorited_employee_list );
        request.setAttribute("count", count);


        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/show.jsp");
        rd.forward(request, response);
    }

}