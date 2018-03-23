package code;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMessage
 */
@WebServlet("/SendMessage")
public class SendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestJDBC TestJDBC = new TestJDBC();
		 List<String> messages = TestJDBC.MessageSent( request );
        request.setAttribute( "messages", messages );
		request.getRequestDispatcher("/WEB-INF/Chat.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Message = request.getParameter("Message");
		String auteur = (String) request.getSession().getAttribute("login_session");
		if ((Message!=null)&&(Message.length() <=150)) {
			TestJDBC TestJDBC = new TestJDBC();
			TestJDBC.SendMessage(Message, auteur);
			this.doGet(request, response);
			request.setAttribute("Message",Message);
		} else{
			request.setAttribute("erreurs", new String("Message trop long (longeur > 150)")); 
			this.doGet(request, response);
		}
	}
}
