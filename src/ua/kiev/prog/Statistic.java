package ua.kiev.prog;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import javax.servlet.http.*;

public class Statistic extends javax.servlet.http.HttpServlet {

    private UserStatistic userStatistic = new UserStatistic();

    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        String[] sports = request.getParameterValues("sport");
        boolean sport = (sports!=null && sports.length > 0) ? true : false;
        int books = Integer.parseInt(request.getParameter("books"));
        count++;
        HttpSession session = request.getSession(true);
        File file = null;
        try {
            file = new File(getServletContext().getResource("/stat.xml").toURI());
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
            count--;
            return;
        }
        if (count == 1) {
            synchronized (userStatistic) {
                XMLWorker.loadStatisticFromXMLFile(file, userStatistic);
            }
        }
        userStatistic.updateStatistic(firstName, lastName, age, sport, books);
        XMLWorker.saveStatisticToXMLFile(file,userStatistic);

        session.setAttribute("xml_statistic", userStatistic.toString());
        session.setAttribute("user_count", getCount());
        session.setAttribute("user_firstName", firstName);
        session.setAttribute("user_lastName", lastName);
        session.setAttribute("stat_age", Integer.toString(age));
        session.setAttribute("stat_sport", Boolean.toString(sport));
        session.setAttribute("stat_books", Integer.toString(books));

        response.sendRedirect("stat.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
