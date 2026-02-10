package TD3v2.service;

import TD3v2.dao.PromotionDAO;
import TD3v2.modele.Promotion;

public class PromotionService {

    private final PromotionDAO promotionDAO;

    public PromotionService() {
        this(new PromotionDAO());
    }

    PromotionService(final PromotionDAO promotionDAO) {
        this.promotionDAO = promotionDAO;
    }

    public Promotion ajouterPromotion(final Promotion promotion) {
        return promotionDAO.ajouterPromotion(promotion);
    }
}
