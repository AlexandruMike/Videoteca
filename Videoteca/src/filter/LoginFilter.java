package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daofactory.DaoFactory;
import model.Utente;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/loginfilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletResponse res = null;
		HttpServletRequest req = null;
		if(request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
			res = (HttpServletResponse) response;
			req = (HttpServletRequest) request;
			String email = (String) req.getSession().getAttribute("email");
			System.out.println(email);
			if(email!=null) {
				chain.doFilter(request, response);
			}else {
				res.sendRedirect(req.getContextPath());
			}
		}else {
			response.getWriter().append("Non mi hai chiamato tramite http.Non supporto altri protocolli");
		}	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
