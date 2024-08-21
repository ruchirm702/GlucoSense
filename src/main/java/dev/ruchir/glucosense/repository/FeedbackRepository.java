package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.Core.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByTargetEntityTypeAndTargetEntityId(String targetEntityType, Long targetEntityId);
}
