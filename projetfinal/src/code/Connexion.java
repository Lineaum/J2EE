package code;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_MESSAGES = "messages";
    public static final String VUE          = "/WEB-INF/Chat.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher( "/WEB-INF/Connexion.jsp" ).forward( request, response );
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnexionForm bf = new ConnexionForm();
		String login = bf.verifierNom(request);
		if (bf.getErreurs().isEmpty()) {
			request.getSession().setAttribute("LoginSession", login);
	        TestJDBC test = new TestJDBC();
	        List<String> messages = test.MessageSent( request );
	        request.setAttribute( ATT_MESSAGES, messages );
	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		} else {
			request.setAttribute("erreurs", bf.getErreurs());
			this.doGet(request, response);
		}

	}
}