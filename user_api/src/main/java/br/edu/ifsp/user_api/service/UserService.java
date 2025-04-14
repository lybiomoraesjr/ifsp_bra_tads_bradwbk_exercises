package br.edu.ifsp.user_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifsp.user_api.model.User;
import br.edu.ifsp.user_api.repository.UserRepository;

@Service
public class UserService {
    // Casos de uso de usuário
    @Autowired
    UserRepository userRepository;

    public List<User> getUserList(){
        return userRepository.getAllUsers();
    }

    public User getUserById(int id){
        return userRepository.getUserById(id);
    }
}
