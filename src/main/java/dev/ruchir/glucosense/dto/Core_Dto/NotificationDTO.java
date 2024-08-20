package dev.ruchir.glucosense.dto.Core_Dto;

import dev.ruchir.glucosense.model.Enum.NotificationStatus;
import dev.ruchir.glucosense.model.Enum.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    private Long id;
    private String message;
    private NotificationType type; // Changed to enum
    private Long userId;
    private NotificationStatus status; // Changed to enum
}