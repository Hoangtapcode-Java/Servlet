import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountUserListener implements HttpSessionListener {
    ServletContext sc = null;
    static int total = 0, current = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        total++;
        current ++;
        sc = se.getSession().getServletContext();
        sc.setAttribute("totalusers", total);
        sc.setAttribute("currentusers", current);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        current--;
        sc.setAttribute("currentusers", current);
    }
}
