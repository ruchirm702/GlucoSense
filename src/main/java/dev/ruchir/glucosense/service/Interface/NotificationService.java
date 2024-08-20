package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.dto.Core_Dto.NotificationDTO;

import java.util.List;

public interface NotificationService {
    NotificationDTO createNotification(NotificationDTO notificationDTO);

    NotificationDTO updateNotification(Long id, NotificationDTO notificationDTO);

    void deleteNotification(Long id);

    NotificationDTO getNotificationById(Long id);

    List<NotificationDTO> getNotificationsByUserId(Long userId);

    List<NotificationDTO> getNotificationsByPatientId(Long patientId);
}
