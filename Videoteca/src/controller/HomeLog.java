package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daofactory.DaoFactory;
import model.Film;
import model.Utente;

/**
 * Servlet implementation class HomeLog
 */
@WebServlet("/homeLog")
public class HomeLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeLog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		request.getSession().setAttribute("email", utente.getEmail());
	
		if(utente !=null && utente.getRuolo()==1) {
		request.getRequestDispatcher("/WEB-INF/homeAdmin.jsp").forward(request, response);
		}
		if (utente !=null && utente.getRuolo()==0) { 
			List<Film> listaFilm=DaoFactory.getDAOFactory().getFilmDaoInterface().readAll();
			System.out.println("SONO ENTRATO IN LISTA FILM "+listaFilm);
			request.setAttribute("listaFilm", listaFilm);
			request.getRequestDispatcher("/WEB-INF/homeUtente.jsp").forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
