package pro.sky.recommendation_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pro.sky.recommendation_service.dto.Recommendation;
import pro.sky.recommendation_service.dto.Transaction;
import pro.sky.recommendation_service.modelRecommendations.SimpleCredit;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SimpleCreditRule implements RecommendationRuleSet {
    private final SimpleCredit credit;

    @Override
    public Optional<Recommendation> validateRecommendationRule(List<Transaction> transactions) {
        // Проверка 1. Пользователь не использует продукты с типом CREDIT.
        boolean checkRule1 = !credit.hasProduct(transactions);

        // Проверка 2. Сумма пополнений по всем продуктам типа DEBIT больше, чем сумма трат по всем продуктам типа DEBIT.
        boolean checkRule2 = credit.totalDeposit(transactions) > credit.totalWithdraw(transactions);

        // Проверка 3. Сумма трат по всем продуктам типа DEBIT больше, чем 100 000 ₽.
        boolean checkRule3 = credit.totalWithdraw(transactions) > 100_000;

        if (checkRule1 && checkRule2 && checkRule3) {
            return Optional.of(recommendationRepository.findByName("Простой кредит"));
        }
        return Optional.empty();
    }
}
