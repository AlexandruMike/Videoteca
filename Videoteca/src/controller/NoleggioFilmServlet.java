package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daofactory.DaoFactory;
import model.Carrello;
import model.Film;
import model.Noleggio;
import model.Utente;

/**
 * Servlet implementation class NoleggioFilmServlet
 */
@WebServlet("/NoleggioFilm")
public class NoleggioFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoleggioFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Film> listaFilm=DaoFactory.getDAOFactory().getFilmDaoInterface().readAll();
		request.setAttribute("listaFilm", listaFilm);
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		
		
		
		if(utente.getCarrello()==null) {
		Carrello carrello = new Carrello(utente);
		
		utente.setCarrello(carrello);
		}
		request.getRequestDispatcher("WEB-INF/NoleggioFilm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String val = request.getParameter("val");
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		
		
		if(val.equalsIgnoreCase("add")) {
		int id = Integer.parseInt(request.getParameter("idSet"));
		Film film = DaoFactory.getDAOFactory().getFilmDaoInterface().readFromId(id);
	
		utente.getCarrello().addFilm(film);
		
		response.sendRedirect("NoleggioFilm");
		}
		
		if(val.equalsIgnoreCase("cart")) {
			request.setAttribute("utente", utente);
			request.getRequestDispatcher("WEB-INF/Pagamento.jsp").forward(request, response);
			
		}

		
		
		
		/*if(val.equalsIgnoreCase("add")) {
		int id = Integer.parseInt(request.getParameter("idSet"));
		Film film = DaoFactory.getDAOFactory().getFilmDaoInterface().readFromId(id);
		}
		
		
		Noleggio noleggio = new Noleggio(film, utente);
		request.setAttribute("noleggio", noleggio);
		
		
		System.out.println(val);
		if(val.equalsIgnoreCase("cart")) {
			request.getRequestDispatcher("WEB-INF/Pagamento.jsp").forward(request, response);
		}
		response.sendRedirect("NoleggioFilm");*/
		//DaoFactory.getDAOFactory().getNoleggioDaoInterface().create(noleggio);
	}

}
