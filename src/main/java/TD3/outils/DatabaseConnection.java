package TD3.outils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DatabaseConnection {

    //private static final String URL = "jdbc:mysql://localhost:3306/bdd_livres";
    private static final String URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private DatabaseConnection() {
        // privé
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initialiser() {
        creerTableEtudiant();
    }

    /**
     * Voici la requête utilisée :
     * create table etudiant(id int auto_increment primary key, nom varchar(255), prenom varchar(255), promotion varchar(255));
     */
    private static void creerTableEtudiant() {
        final String creationTable = "create table etudiant(id int auto_increment primary key, nom varchar(255), prenom varchar(255), promotion varchar(255));";

        try (Connection connexion = getConnection();
             Statement stmt = connexion.createStatement()) {
            stmt.execute(creationTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
