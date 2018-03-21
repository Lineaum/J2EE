package code;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnexionForm{
	HashMap<String,String> erreurs;
	
	public ConnexionForm() {
		super();
		erreurs = new HashMap<String, String>();
	}
	
	public String verifierNom(HttpServletRequest request) {
		String login = request.getParameter("login");
		String Mdp = request.getParameter("Mdp");
		
		if ((login != null)&&(login.length() >=3)&&(Mdp != null) && (Mdp.length() >=3)) {
			request.getSession().setAttribute("login_session", login);
			request.getRequestDispatcher("/WEB-INF/ReponseFormulaire.jsp").forward( request, response );
		} else{
			request.setAttribute("erreur",new String("Nom invalide (longueur <3)"));
			this.doGet(request, response);
		}
		return null;
	}
	
	public HashMap<String,String> getErreurs(){
		return erreurs;
	}
	
	public void setErreurs(HashMap<String,String> erreurs) {
		this.erreurs = erreurs;
	}
	
}
