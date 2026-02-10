package TD3v2.outils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DatabaseConnection {

    //private static final String URL = "jdbc:mysql://localhost:3306/ma_bdd";
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
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            creerTablePromotion(statement);
            creerTableEtudiant(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Voici la requête utilisée :
     * create table promotion(id int auto_increment primary key, nom varchar(120) not null;
     */
    private static void creerTablePromotion(final Statement statement) throws SQLException {
        final String creationTable = "create table promotion(id int auto_increment primary key, nom varchar(120) not null);";
        statement.execute(creationTable);
    }

    /**
     * Voici la requête utilisée :
     * create table etudiant(id int auto_increment primary key, nom varchar(255), prenom varchar(255), promotion_id int, foreign key (promotion_id) references promotion(id));
     */
    private static void creerTableEtudiant(final Statement statement) throws SQLException {
        final String creationTable = "create table etudiant(id int auto_increment primary key, nom varchar(255), prenom varchar(255), promotion_id int, foreign key (promotion_id) references promotion(id));";
        statement.execute(creationTable);
    }
}
