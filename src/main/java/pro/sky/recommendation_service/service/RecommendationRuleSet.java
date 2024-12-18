package pro.sky.recommendation_service.service;

import pro.sky.recommendation_service.dto.Recommendation;
import pro.sky.recommendation_service.dto.Transaction;

import java.util.List;
import java.util.Optional;

public interface RecommendationRuleSet {
    Optional<Recommendation> validateRecommendationRule(List<Transaction> transactions);
}
