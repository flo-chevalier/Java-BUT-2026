package TD3v2.dao;

import TD3v2.modele.Promotion;

import java.sql.*;
import java.util.Objects;

import static TD3.outils.DatabaseConnection.getConnection;

public final class PromotionDAO {

    /**
     * Enregistre une promotion en BDD.
     *
     * @param promotion la promotion à enregistrer
     * @return la promotion enregistrée
     * @throws NullPointerException si l'entité passée en paramètre est {@code null}
     */
    public Promotion ajouterPromotion(final Promotion promotion) {
        Objects.requireNonNull(promotion);

        final String sql = "insert into promotion (nom) values (?)";

        try (final Connection connexion = getConnection();
             final PreparedStatement statement = connexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, promotion.getNom());

            // Exécuter la requête
            final int nbResults = statement.executeUpdate();

            if (nbResults == 1) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    promotion.setId(rs.getInt(1));
                } else {
                    System.out.println("Erreur récupération ID généré");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return promotion;
    }
}
