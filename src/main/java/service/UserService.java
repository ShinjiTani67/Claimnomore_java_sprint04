package service;


import entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(UUID uuid) {
        return userRepository.findById(uuid);
    }

    public User saveUser(User user) {
        return (User) userRepository.save(user);
    }

    public void deleteUser(UUID uuid) {
        userRepository.deleteById(uuid);
    }
}