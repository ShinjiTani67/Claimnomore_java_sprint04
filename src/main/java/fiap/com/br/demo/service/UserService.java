package fiap.com.br.demo.service;


import fiap.com.br.demo.dto.UserDTO;
import fiap.com.br.demo.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import fiap.com.br.demo.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    private UserDTO convertToDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setUuid(user.getUuid());
        dto.setCPF(user.getCPF());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAdmissiondate(user.getAdmissiondate());
        dto.setJob(user.getJob());
        return dto;
    }
    private User convertToEntity(UserDTO dto){
        User user = new User();
        user.setUuid(dto.getUuid());
        user.setCPF(dto.getCPF());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAdmissiondate(dto.getAdmissiondate());
        user.setJob(dto.getJob());
        return user;
    }
    public UserDTO save(UserDTO userDTO){
        User user = convertToEntity(userDTO);
        user = (User) repository.save(user);
        return convertToDTO(user);
    }
    public List<UserDTO> getUser(){
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public void deletarPorId(UUID uuid){
        repository.deleteById(uuid);
    }
    public UserDTO findById(UUID uuid){
        Optional<User> byId = repository.findById(uuid);
        if (byId.isPresent())
            return convertToDTO(byId.get());{
        }
        throw new RuntimeException("Usuario com id" + uuid + "nao encontrado");
    }
}