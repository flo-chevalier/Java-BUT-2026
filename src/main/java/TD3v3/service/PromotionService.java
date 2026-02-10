package TD3v3.service;

import TD3v3.dao.PromotionDAO;
import TD3v3.modele.Promotion;

public class PromotionService {

    private final PromotionDAO promotionDAO;

    public PromotionService() {
        this(new PromotionDAO());
    }

    PromotionService(final PromotionDAO promotionDAO) {
        this.promotionDAO = promotionDAO;
    }

    public Promotion ajouterPromotion(final Promotion promotion) {
        return promotionDAO.create(promotion);
    }
}
