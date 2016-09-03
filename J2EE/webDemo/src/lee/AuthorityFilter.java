package lee;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * User: jennie
 * Date: 2016/9/3
 * Time: 21:14
 */
@WebFilter(filterName = "authority"
        , urlPatterns = "/*"
        , initParams = {
        @WebInitParam(name = "encoding", value = "utf-8"),
        @WebInitParam(name = "loginPage", value = "/filter_login.jsp"),
        @WebInitParam(name = "proLogin", value = "/proLogin.jsp")})
public class AuthorityFilter implements Filter {

    private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void destroy() {
        this.config = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String encoding = config.getInitParameter("encoding");
        String loginPage = config.getInitParameter("loginPage");
        String proLogin = config.getInitParameter("proLogin");
        request.setCharacterEncoding(encoding);
        HttpServletRequest requ = (HttpServletRequest) request;
        HttpSession session = requ.getSession();
        String requestPath = ((HttpServletRequest) request).getServletPath();
        if (session.getAttribute("user") == null && !requestPath.endsWith(loginPage) && !requestPath.endsWith(proLogin)) {
            request.setAttribute("tip", "你还没有登录");
            request.getRequestDispatcher(loginPage).forward(request, response);
        } else {
            chain.doFilter(request, response);
        }

    }
}
