package code;

import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;



public class TestJDBC {
	HashMap<String,String> erreurs;

	
public TestJDBC() {
	super();
	erreurs = new HashMap<String, String>();
}
	

	private List<String> messages = new ArrayList<String>();
	private List<String> messagesSent = new ArrayList<String>();


	   public List<String> MessageSent( HttpServletRequest request ) {
	        /* Chargement du driver JDBC pour MySQL */
	        try {
	            Class.forName( "com.mysql.jdbc.Driver" );
	        } catch ( ClassNotFoundException e ) {
	        }

	        /* Connexion à la base de données */
	        String url = "jdbc:mysql://localhost:3306/bdd_sdzee";
	        String utilisateur = "root";
	        String motDePasse = "Motdepasse21";
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try {
	            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
	        
	            statement = connexion.createStatement();
	            
	            resultat = statement.executeQuery( "SELECT contenu,auteur FROM Messages;" );
	            
	            while ( resultat.next() ) {
	                String contenuMess = resultat.getString( "contenu" );
	                String auteurMess = resultat.getString( "auteur" );
	                messages.add(contenuMess + " 		| écrit par : " + auteurMess);
	            }
	        } catch ( SQLException e ) {
	          //  messages.add( "Erreur lors de la connexion : <br/>"
	          //          + e.getMessage() );
	        } finally {
	            if ( resultat != null ) {
	                try {
	                    resultat.close();
	                } catch ( SQLException ignore ) {
	                }
	            }
	            if ( statement != null ) {
	                try {
	                    statement.close();
	                } catch ( SQLException ignore ) {
	                }
	            }
	            if ( connexion != null ) {
	                try {
	                    connexion.close();
	                } catch ( SQLException ignore ) {
	                }
	            }
	        }

	        return messages;
	    }
	   
	    public List<String> SendMessage(String Message, String auteur) {
	    	 /* Chargement du driver JDBC pour MySQL */
	        try {
	            Class.forName( "com.mysql.jdbc.Driver" );
	        } catch ( ClassNotFoundException e ) {
	        }

	        /* Connexion à la base de données */
	        String url = "jdbc:mysql://localhost:3306/bdd_sdzee";
	        String utilisateur = "root";
	        String motDePasse = "Motdepasse21";
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try {
	            connexion = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );
	        
	            statement = (Statement) connexion.createStatement();
	            
	            statement.executeUpdate("INSERT INTO Messages (id,contenu, auteur) VALUES (NULL,'"+Message+"',Coyote);");
            
        } catch ( SQLException e ) {
          //  messages.add( "Erreur lors de la connexion : <br/>"
          //          + e.getMessage() );
        } finally {
            if ( resultat != null ) {
                try {
                    resultat.close();
                } catch ( SQLException ignore ) {
                }
            }
            if ( statement != null ) {
                try {
                    statement.close();
                } catch ( SQLException ignore ) {
                }
            }
            if ( connexion != null ) {
                try {
                    connexion.close();
                } catch ( SQLException ignore ) {
                }
            }
        }

        return messagesSent;
    }
   
		
		public String Inscription(String loginInsc,String AdrMail, String Mdp) {

			if ((loginInsc!=null)&&(loginInsc.length() >=3)) {
				return loginInsc;
			} else{
				erreurs.put("loginInsc", new String("Login invalide (longeur < 3)")); 
			}
			
			if ((Mdp!=null)&&(Mdp.length() >=3)) {
				return Mdp;
			} else {
				erreurs.put("Mdp", new String("Mot de passe invalide (longeur < 3)"));
			}
			
			if ((AdrMail!=null)&&(AdrMail.length()>=6)&&(AdrMail.contains("@"))) {
				return AdrMail;
			} else {
				erreurs.put("AdrMail", new String("Adresse Mail invalide"));
			}

			 /* Chargement du driver JDBC pour MySQL */
	        try {
	            Class.forName( "com.mysql.jdbc.Driver" );
	        } catch ( ClassNotFoundException e ) {
	        }

	        /* Connexion à la base de données */
	        String url = "jdbc:mysql://localhost:3306/bdd_sdzee";
	        String utilisateur = "root";
	        String motDePasse = "Motdepasse21";
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try {
	            connexion = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );
	        
	            statement = (Statement) connexion.createStatement();
	            
		            statement.executeUpdate("INSERT INTO `Utilisateur` (email, `mot_de_passe`, `nom`, `date_inscription) VALUES ('"+AdrMail+"','"+Mdp+"','"+loginInsc+"',2018-03-22 16:45:00");
		        } catch ( SQLException e ) {
		          //  messages.add( "Erreur lors de la connexion : <br/>"
		          //          + e.getMessage() );
		        } finally {
		            if ( resultat != null ) {
		                try {
		                    resultat.close();
		                } catch ( SQLException ignore ) {
		                }
		            }
		            if ( statement != null ) {
		                try {
		                    statement.close();
		                } catch ( SQLException ignore ) {
		                }
		            }
		            if ( connexion != null ) {
		                try {
		                    connexion.close();
		                } catch ( SQLException ignore ) {
		                }
		            }
		        }
			
			return null;
		}

}		