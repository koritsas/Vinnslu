package org.koritsas.vinnslu.security.ws.services;

import org.koritsas.vinnslu.security.models.VinnsluUser;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.security.exceptions.EmailExistsException;
import org.koritsas.vinnslu.security.exceptions.UsernameExistsException;
import org.koritsas.vinnslu.security.repos.UserRepository;
import org.koritsas.vinnslu.security.ws.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    GeometryModelMapper mapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = {EmailExistsException.class, UsernameExistsException.class})
    public VinnsluUser registerNewUser(UserDTO userDto){

        if(emailAlreadyExists(userDto.getEmail())){
            throw new EmailExistsException("VinnsluUser email" +userDto.getEmail() + "already exists");
        }

        if (usernameAlreadyExists(userDto.getUsername())){
            throw new UsernameExistsException("Username" + userDto.getUsername() + "already exists");
        }

        VinnsluUser newUser = new VinnsluUser();

        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        newUser.setEmail(userDto.getEmail());
        newUser.setName(userDto.getName());
        newUser.setSurname(userDto.getSurname());
        newUser.setUsername(userDto.getUsername());
        newUser.setUserRole(userDto.getUserRole());

        return repository.save(newUser);

    }


    private boolean usernameAlreadyExists(String username){

        VinnsluUser user = repository.findByUsername(username);

        return user != null;
    }


    private boolean emailAlreadyExists(String email){
        VinnsluUser user = repository.findByEmail(email);
        return user != null;

    }

}
