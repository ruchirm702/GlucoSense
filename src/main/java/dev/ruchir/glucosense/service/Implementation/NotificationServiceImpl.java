package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.NotificationAlreadyExistsException;
import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.NotificationNotFoundException;
import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.InvalidNotificationDataException;
import dev.ruchir.glucosense.dto.Core_Dto.NotificationDTO;
import dev.ruchir.glucosense.model.Core.Notification;
import dev.ruchir.glucosense.repository.NotificationRepository;
import dev.ruchir.glucosense.repository.PatientRepository;
import dev.ruchir.glucosense.service.Interface.NotificationService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository, PatientRepository patientRepository) {
        this.notificationRepository = notificationRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public NotificationDTO createNotification(NotificationDTO notificationDTO) {
        validateUser(notificationDTO.getUserId());

        Optional<Notification> existingNotification = notificationRepository.findByMessageAndUserId(
                notificationDTO.getMessage(), notificationDTO.getUserId()
        );
        if (existingNotification.isPresent()) {
            throw new NotificationAlreadyExistsException("Notification with the same message already exists for this user");
        }

        Notification notification = new Notification();
        notification.setMessage(notificationDTO.getMessage());
        notification.setType(notificationDTO.getType());
        notification.setUserId(notificationDTO.getUserId());
        notification.setStatus(notificationDTO.getStatus());

        Notification savedNotification = notificationRepository.save(notification);
        return convertToDTO(savedNotification);
    }

    @Override
    public NotificationDTO updateNotification(Long id, NotificationDTO notificationDTO) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException("Notification not found"));

        validateUser(notificationDTO.getUserId());

        Optional<Notification> duplicateNotification = notificationRepository.findByMessageAndUserId(
                notificationDTO.getMessage(), notificationDTO.getUserId()
        );
        if (duplicateNotification.isPresent() && !duplicateNotification.get().getId().equals(id)) {
            throw new NotificationAlreadyExistsException("Notification with the same message already exists for this user");
        }

        notification.setMessage(notificationDTO.getMessage());
        notification.setType(notificationDTO.getType());
        notification.setUserId(notificationDTO.getUserId());
        notification.setStatus(notificationDTO.getStatus());

        Notification updatedNotification = notificationRepository.save(notification);
        return convertToDTO(updatedNotification);
    }

    @Override
    public void deleteNotification(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException("Notification not found"));

        notificationRepository.delete(notification);
    }

    @Override
    public NotificationDTO getNotificationById(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException("Notification not found"));

        return convertToDTO(notification);
    }

    @Override
    public List<NotificationDTO> getNotificationsByUserId(Long userId) {
        List<Notification> notifications = notificationRepository.findByUserId(userId);

        return notifications.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<NotificationDTO> getNotificationsByPatientId(Long patientId) {
        List<Notification> notifications = notificationRepository.findByUserId(patientId);

        return notifications.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private NotificationDTO convertToDTO(Notification notification) {
        return new NotificationDTO(
                notification.getId(),
                notification.getMessage(),
                notification.getType(),
                notification.getUserId(),
                notification.getStatus()
        );
    }

    private void validateUser(Long userId) {
        boolean userExists = patientRepository.existsById(userId);
        if (!userExists) {
            throw new InvalidNotificationDataException("Invalid user ID");
        }
    }
}
