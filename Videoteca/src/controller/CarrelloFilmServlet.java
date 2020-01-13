package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daofactory.DaoFactory;
import model.Carrello;
import model.Film;
import model.Noleggio;
import model.Ordini;
import model.Utente;

/**
 * Servlet implementation class CarrelloFilmServlet
 */
@WebServlet("/CarrelloFilm")
public class CarrelloFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarrelloFilmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String value = request.getParameter("val");
		Utente utente = (Utente) request.getSession().getAttribute("utente");

		if (value.equalsIgnoreCase("rimuovi")) {
			int id = Integer.parseInt(request.getParameter("filmId"));
			Film film = DaoFactory.getDAOFactory().getFilmDaoInterface().readFromId(id);
			utente.getCarrello().removeFilm(film, utente);
			request.setAttribute("utente", utente);
			request.getRequestDispatcher("WEB-INF/Pagamento.jsp").forward(request, response);
		}

		if (value.equalsIgnoreCase("pagamento")) {
			System.out.println("FILM CARRELLO FINALE = " + utente.getCarrello());
			if (utente.getCarrello() != null) {
				for (int i = 0; i < utente.getCarrello().getFilmCarrello().size(); i++) {
					Noleggio noleggio = new Noleggio(utente.getCarrello().getFilmCarrello().get(i),utente);
					//Ordini.addNoleggio(noleggio);
					DaoFactory.getDAOFactory().getNoleggioDaoInterface().create(noleggio);
					
				}		
			}
			utente.svuotaCarrello();
			response.sendRedirect("homeLog");
		}
		

	}

}
