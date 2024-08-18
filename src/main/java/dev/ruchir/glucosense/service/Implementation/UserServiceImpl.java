package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.dto.Support_dto.UserDTO;
import dev.ruchir.glucosense.dto.Enum_dto.UserStatusDTO;
import dev.ruchir.glucosense.model.Enum.UserStatus;
import dev.ruchir.glucosense.model.support.ConcreteUser;
import dev.ruchir.glucosense.repository.ConcreteUserRepository;
import dev.ruchir.glucosense.service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ConcreteUserRepository concreteUserRepository;

    @Autowired
    public UserServiceImpl(ConcreteUserRepository concreteUserRepository) {
        this.concreteUserRepository = concreteUserRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        ConcreteUser user = new ConcreteUser();
        // Map UserDTO to ConcreteUser
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setStatus(mapUserStatusDTOToUserStatus(userDTO.getStatus()));
        concreteUserRepository.save(user);
        return userDTO;
    }

    @Override
    public UserDTO getUserById(Long id) {
        ConcreteUser user = concreteUserRepository.findById(id)
                .orElseThrow(() -> new dev.ruchir.glucosense.exception.UserNotFoundException("User not found with id " + id));

        // Convert UserStatus to UserStatusDTO
        UserStatusDTO statusDTO = UserStatusDTO.valueOf(user.getStatus().toString());

        return new UserDTO(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail(), statusDTO, null);
    }


    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        ConcreteUser user = concreteUserRepository.findById(id)
                .orElseThrow(() -> new dev.ruchir.glucosense.exception.UserNotFoundException("User not found with id " + id));
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setStatus(mapUserStatusDTOToUserStatus(userDTO.getStatus()));
        concreteUserRepository.save(user);
        return userDTO;
    }

    @Override
    public void deleteUser(Long id) {
        ConcreteUser user = concreteUserRepository.findById(id)
                .orElseThrow(() -> new dev.ruchir.glucosense.exception.UserNotFoundException("User not found with id " + id));
        concreteUserRepository.delete(user);
    }

    private UserStatus mapUserStatusDTOToUserStatus(UserStatusDTO userStatusDTO) {
        // Assuming UserStatusDTO is an enum, you can convert it to UserStatus enum
        return UserStatus.valueOf(userStatusDTO.name());
    }
}
