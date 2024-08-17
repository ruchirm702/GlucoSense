package dev.ruchir.glucosense.service.Interface;


import dev.ruchir.glucosense.dto.Support_dto.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
}
