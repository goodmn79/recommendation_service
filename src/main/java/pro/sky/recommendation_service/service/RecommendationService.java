package pro.sky.recommendation_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.sky.recommendation_service.dto.UserRecommendationSet;
import pro.sky.recommendation_service.exception.UserNotFoundException;
import pro.sky.recommendation_service.model.Recommendation;
import pro.sky.recommendation_service.repository.RecommendationRepository;
import pro.sky.recommendation_service.repository.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepository;

    public UserRecommendationSet getUserRecommendationSet(UUID userId) {
        userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        UserRecommendationSet userRecommendationSet = new UserRecommendationSet(userId);
        userRecommendationSet.addRecommendation(new Recommendation());
        return userRecommendationSet;
    }
}
