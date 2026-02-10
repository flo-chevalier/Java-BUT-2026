package TD3v3.outils;

import TD3v3.modele.Etudiant;
import TD3v3.modele.Promotion;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public final class HibernateOutil {

    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            // récupère par défaut le fichier hibernate.properties
            SESSION_FACTORY = new Configuration()
                    .addAnnotatedClass(Etudiant.class)
                    .addAnnotatedClass(Promotion.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
