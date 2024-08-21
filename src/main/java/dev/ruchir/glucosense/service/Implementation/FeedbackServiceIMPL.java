package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.dto.Core_Dto.FeedbackDTO;
import dev.ruchir.glucosense.dto.Enum_dto.FeedbackTargetEntityTypeDTO;
import dev.ruchir.glucosense.dto.Enum_dto.FeedbackRatingDTO;
import dev.ruchir.glucosense.model.Core.Feedback;
import dev.ruchir.glucosense.repository.FeedbackRepository;
import dev.ruchir.glucosense.repository.PatientRepository;
import dev.ruchir.glucosense.service.Interface.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceIMPL implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final PatientRepository patientRepository; // Add PatientRepository

    // Constructor injection
    public FeedbackServiceIMPL(FeedbackRepository feedbackRepository, PatientRepository patientRepository) {
        this.feedbackRepository = feedbackRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public FeedbackDTO createFeedback(FeedbackDTO feedbackDTO) {
        Feedback feedback = mapToEntity(feedbackDTO);
        Feedback savedFeedback = feedbackRepository.save(feedback);
        return mapToDTO(savedFeedback);
    }

    @Override
    public FeedbackDTO updateFeedback(Long id, FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));
        feedback.setComments(feedbackDTO.getComments());
        feedback.setRating(feedbackDTO.getRating().getRating());
        feedback.setFeedbackDate(feedbackDTO.getFeedbackDate());
        Feedback updatedFeedback = feedbackRepository.save(feedback);
        return mapToDTO(updatedFeedback);
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public FeedbackDTO getFeedbackById(Long id) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));
        return mapToDTO(feedback);
    }

    @Override
    public List<FeedbackDTO> getAllFeedbacks() {
        return feedbackRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FeedbackDTO> getFeedbackByTarget(String targetEntityType, Long targetEntityId) {
        return feedbackRepository.findByTargetEntityTypeAndTargetEntityId(targetEntityType, targetEntityId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private FeedbackDTO mapToDTO(Feedback feedback) {
        return new FeedbackDTO(
                feedback.getId(),
                feedback.getPatient().getId(),
                new FeedbackTargetEntityTypeDTO(feedback.getTargetEntityType()),
                feedback.getTargetEntityId(),
                feedback.getComments(),
                new FeedbackRatingDTO(feedback.getRating()),
                feedback.getFeedbackDate()
        );
    }

    private Feedback mapToEntity(FeedbackDTO feedbackDTO) {
        Feedback feedback = new Feedback();
        feedback.setPatient(patientRepository.findById(feedbackDTO.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"))); // Fetch full patient entity
        feedback.setTargetEntityType(feedbackDTO.getTargetEntityType().getEntityType());
        feedback.setTargetEntityId(feedbackDTO.getTargetEntityId());
        feedback.setComments(feedbackDTO.getComments());
        feedback.setRating(feedbackDTO.getRating().getRating());
        feedback.setFeedbackDate(feedbackDTO.getFeedbackDate());
        return feedback;
    }
}
