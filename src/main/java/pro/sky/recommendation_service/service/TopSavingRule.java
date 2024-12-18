package pro.sky.recommendation_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pro.sky.recommendation_service.dto.Recommendation;
import pro.sky.recommendation_service.dto.Transaction;
import pro.sky.recommendation_service.modelRecommendations.TopSaving;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TopSavingRule implements RecommendationRuleSet {
    private final TopSaving saving;

    @Override
    public Optional<Recommendation> validateRecommendationRule(List<Transaction> transactions) {
        // Проверка 1: Пользователь использует как минимум один продукт с типом DEBIT
        boolean checkRule1 = saving.hasProduct(transactions);

        // Проверка 2: Сумма пополнений по всем продуктам типа DEBIT больше или равна 50 000 ₽ ИЛИ Сумма пополнений по всем продуктам типа SAVING больше или равна 50 000 ₽.
        boolean checkRule2 = saving.totalDeposit(transactions) >= 50_000 || saving.totalDepositForSaving(transactions) >= 50_000;

        // Проверка 3. Сумма пополнений по всем продуктам типа DEBIT больше, чем сумма трат по всем продуктам типа DEBIT.
        boolean checkRule3 = saving.totalWithdraw(transactions) > saving.totalWithdraw(transactions);

        if (checkRule1 && checkRule2 && checkRule3) {
            return Optional.of(recommendationRepository.findByName("Top Saving"));
        }
        return Optional.empty();
    }
}
