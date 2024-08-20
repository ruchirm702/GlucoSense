package dev.ruchir.glucosense.model.Core;


import dev.ruchir.glucosense.model.Enum.NotificationStatus;
import dev.ruchir.glucosense.model.Enum.NotificationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Enumerated(EnumType.STRING)
    private NotificationType type; // Changed to enum

    private Long userId; // User ID (can be either Doctor or Patient)

    @Enumerated(EnumType.STRING)
    private NotificationStatus status; // Changed to enum
}
