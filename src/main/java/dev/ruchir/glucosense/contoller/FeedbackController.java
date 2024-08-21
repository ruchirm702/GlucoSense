package dev.ruchir.glucosense.contoller;

import dev.ruchir.glucosense.dto.Core_Dto.FeedbackDTO;
import dev.ruchir.glucosense.service.Interface.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    // Constructor injection
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    // Create new feedback
    @PostMapping
    public ResponseEntity<FeedbackDTO> createFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        FeedbackDTO createdFeedback = feedbackService.createFeedback(feedbackDTO);
        return new ResponseEntity<>(createdFeedback, HttpStatus.CREATED);
    }

    // Update existing feedback
    @PutMapping("/{id}")
    public ResponseEntity<FeedbackDTO> updateFeedback(@PathVariable Long id, @RequestBody FeedbackDTO feedbackDTO) {
        FeedbackDTO updatedFeedback = feedbackService.updateFeedback(id, feedbackDTO);
        return new ResponseEntity<>(updatedFeedback, HttpStatus.OK);
    }

    // Delete feedback by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get feedback by ID
    @GetMapping("/{id}")
    public ResponseEntity<FeedbackDTO> getFeedbackById(@PathVariable Long id) {
        FeedbackDTO feedbackDTO = feedbackService.getFeedbackById(id);
        return new ResponseEntity<>(feedbackDTO, HttpStatus.OK);
    }

    // Get all feedback
    @GetMapping
    public ResponseEntity<List<FeedbackDTO>> getAllFeedbacks() {
        List<FeedbackDTO> feedbackDTOs = feedbackService.getAllFeedbacks();
        return new ResponseEntity<>(feedbackDTOs, HttpStatus.OK);
    }

    // Get feedback by target entity
    @GetMapping("/target/{targetEntityType}/{targetEntityId}")
    public ResponseEntity<List<FeedbackDTO>> getFeedbackByTarget(
            @PathVariable String targetEntityType,
            @PathVariable Long targetEntityId) {
        List<FeedbackDTO> feedbackDTOs = feedbackService.getFeedbackByTarget(targetEntityType, targetEntityId);
        return new ResponseEntity<>(feedbackDTOs, HttpStatus.OK);
    }
}
