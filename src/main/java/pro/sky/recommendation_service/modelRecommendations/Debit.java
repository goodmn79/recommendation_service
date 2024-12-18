package pro.sky.recommendation_service.modelRecommendations;

import pro.sky.recommendation_service.dto.Transaction;

import java.util.List;


public abstract class Debit {
    public abstract boolean hasProduct(List<Transaction> transactions);

    public abstract int totalDeposit(List<Transaction> transactions);

    public abstract int totalWithdraw(List<Transaction> transactions);
}
