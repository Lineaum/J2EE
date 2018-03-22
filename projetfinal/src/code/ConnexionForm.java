package code;

import java.util.*;
import javax.servlet.http.HttpServletRequest;

public class ConnexionForm{
	HashMap<String,String> erreurs;
	
	public ConnexionForm() {
		super();
		erreurs = new HashMap<String, String>();
	}
	
	public String verifierNom(HttpServletRequest request) {
		String login = request.getParameter("login");
		String Mdp = request.getParameter("Mdp");

		if ((login!=null)&&(login.length() >=3)) {
			return login;
		} else{
			erreurs.put("login", new String("Login invalide (longeur < 3)")); 
		}
		
		if ((Mdp!=null)&&(Mdp.length() >=3)) {
			return Mdp;
		} else {
			erreurs.put("Mdp", new String("Mot de passe invalide (longeur < 3)"));
		}
		return null;
	}
	
	public String verifierMessage(HttpServletRequest request) {
		String Message = request.getParameter("Message");
		if ((Message!=null)&&(Message.length() <=150)) {
			return Message;
		} else{
			erreurs.put("Message", new String("Message trop long (longeur > 150)")); 
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
