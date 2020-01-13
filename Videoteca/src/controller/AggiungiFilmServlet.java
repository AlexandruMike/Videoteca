package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daofactory.DaoFactory;
import model.Film;

/**
 * Servlet implementation class AggiungiFilmServlet
 */
@WebServlet("/AggiungiFilm")
public class AggiungiFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AggiungiFilmServlet() {
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
		request.getRequestDispatcher("WEB-INF/AggiungiFilm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String titolo = request.getParameter("titolo");
		String value = request.getParameter("val");
		int durata = 0;
		int nCopie = 0;

		// ------blocco aggiunta film
		if (value.equalsIgnoreCase("add")) {
			try {
				durata = Integer.parseInt(request.getParameter("durata"));
				nCopie = Integer.parseInt(request.getParameter("copie"));
			} catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (titolo != null && durata > 0 && nCopie > 0) {
				Film nuovoFilm = new Film(titolo, durata, nCopie);
				DaoFactory.getDAOFactory().getFilmDaoInterface().create(nuovoFilm);
				response.sendRedirect("AggiungiFilm");

			} else {
				request.setAttribute("messaggio", "inserire i campi in modo corretto");
				request.getRequestDispatcher("WEB-INF/AggiungiFilm.jsp").forward(request, response);
			}

			// ----blocco rimuovi film
		} else if (value.equalsIgnoreCase("remove")) {
			int id = Integer.parseInt(request.getParameter("idSet"));
			Film remove = DaoFactory.getDAOFactory().getFilmDaoInterface().readFromId(id);
			System.out.println(remove);
			DaoFactory.getDAOFactory().getFilmDaoInterface().delete(remove);
			response.sendRedirect("ListaFilmAdmin");

			// ---blocco modifica film
		} else if (value.equalsIgnoreCase("modify") || value.equalsIgnoreCase("modifyAdd")) {
			int id = Integer.parseInt(request.getParameter("idSet"));
			if (value.equalsIgnoreCase("modify")) {
				System.out.println("id " + id);
				Film filmOld = DaoFactory.getDAOFactory().getFilmDaoInterface().readFromId(id);
				System.out.println("FILM VECCHIO " + filmOld);
				request.setAttribute("filmOld", filmOld);
				request.getRequestDispatcher("WEB-INF/ModificaFilm.jsp").forward(request, response);
			}

			if (value.equalsIgnoreCase("modifyAdd")) {
				try {
					durata = Integer.parseInt(request.getParameter("durata"));
					nCopie = Integer.parseInt(request.getParameter("copie"));
				} catch (NumberFormatException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				Film nuovo = new Film(id, titolo, durata, nCopie);
				System.out.println("FILM NUOVO " + nuovo);

				DaoFactory.getDAOFactory().getFilmDaoInterface().update(nuovo);
				response.sendRedirect("ListaFilmAdmin");

			}
		}
	}
}
