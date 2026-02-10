package TD3v2.dao;

import TD3v2.modele.Etudiant;
import TD3v2.modele.Promotion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static TD3.outils.DatabaseConnection.getConnection;

/**
 * DAO de Etudiant.
 */
public final class EtudiantDAO {

    public List<Etudiant> getAllEtudiants() {
        final List<Etudiant> etudiants = new ArrayList<>();
        final String sql = """
                           select e.id, e.nom, e.prenom, p.id as promo_id, p.nom as promo_nom
                           from etudiant e 
                               join promotion p on e.promotion_id = p.id
                           """;
        try (final Connection connexion = getConnection();
             final PreparedStatement statement = connexion.prepareStatement(sql);
             final ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                final var promotion = new Promotion(rs.getInt("promo_id"), rs.getString("promo_nom"));

                etudiants.add(new Etudiant(rs.getInt("id"),
                                           rs.getString("nom"),
                                           rs.getString("prenom"),
                                           promotion));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiants;
    }

    public Etudiant getEtudiantById(final int id) {
        final String sql = """
                           select *
                           from etudiant e
                               join promotion p on p.id = e.promotion_id
                           where e.id = ?
                           """;

        try (final Connection connexion = getConnection();
             final PreparedStatement statement = connexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                final var promotion = new Promotion(rs.getInt("p.id"), rs.getString("p.nom"));
                return new Etudiant(rs.getInt("e.id"),
                                    rs.getString("e.nom"),
                                    rs.getString("e.prenom"),
                                    promotion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Enregistre un étudiant en BDD.
     *
     * @param etudiant l'étudiant à enregistrer
     * @return l'étudiant enregistré
     * @throws NullPointerException si l'entité passée en paramètre est {@code null}
     */
    public Etudiant ajouterEtudiant(final Etudiant etudiant) {
        Objects.requireNonNull(etudiant);

        final String sql = "insert into etudiant (nom, prenom, promotion_id) values (?, ?, ?)";

        try (final Connection connexion = getConnection();
             final PreparedStatement statement = connexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, etudiant.getNom());
            statement.setString(2, etudiant.getPrenom());
            statement.setInt(3, etudiant.getPromotion().getId());

            // Exécuter la requête
            final int nbResults = statement.executeUpdate();

            if (nbResults == 1) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    etudiant.setId(rs.getInt(1));
                } else {
                    System.out.println("Erreur récupération ID généré");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return etudiant;
    }
}
