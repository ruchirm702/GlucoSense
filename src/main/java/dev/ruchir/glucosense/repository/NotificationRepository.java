package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.Core.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Find all notifications for a specific user (patient or doctor)
    List<Notification> findByUserId(Long userId);

    // Find notification by its message for uniqueness validation
    Optional<Notification> findByMessageAndUserId(String message, Long userId);
}
