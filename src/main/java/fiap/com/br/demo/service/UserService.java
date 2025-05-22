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


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    private UserDTO convertToDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setCpf(user.getCpf());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAdmissiondate(user.getAdmissiondate());
        dto.setJob(user.getJob());
        return dto;
    }

    private User convertToEntity(UserDTO dto){
        User user = new User();
        user.setId(dto.getId());
        user.setCpf(dto.getCpf());
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

    public void deleteById(String id){
        repository.deleteById(id);
    }

    public UserDTO findByUuid(String id){
        Optional<User> byId = repository.findById(id);
        if (byId.isPresent())
            return convertToDTO(byId.get());{
        }
        throw new RuntimeException("Usuario com id" + id + "nao encontrado");
    }
}