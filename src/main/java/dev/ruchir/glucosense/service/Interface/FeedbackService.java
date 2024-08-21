package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.dto.Core_Dto.FeedbackDTO;

import java.util.List;

public interface FeedbackService {

    FeedbackDTO createFeedback(FeedbackDTO feedbackDTO);

    FeedbackDTO updateFeedback(Long id, FeedbackDTO feedbackDTO);

    void deleteFeedback(Long id);

    FeedbackDTO getFeedbackById(Long id);

    List<FeedbackDTO> getAllFeedbacks();

    List<FeedbackDTO> getFeedbackByTarget(String targetEntityType, Long targetEntityId);
}
