package org.koritsas.vinnslu.security.ws.services;

import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.security.exceptions.EmailExistsException;
import org.koritsas.vinnslu.security.exceptions.UserDoesNotExistException;
import org.koritsas.vinnslu.security.exceptions.UsernameExistsException;
import org.koritsas.vinnslu.security.models.User;
import org.koritsas.vinnslu.security.repos.UserRepository;
import org.koritsas.vinnslu.security.ws.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    GeometryModelMapper mapper;

    @Transactional(rollbackFor = {EmailExistsException.class, UsernameExistsException.class})
    public User registerNewUser(UserDTO userDto){

        if(emailAlreadyExists(userDto.getEmail())){
            throw new EmailExistsException("User email" +userDto.getEmail() + "already exists");
        }

        if (usernameAlreadyExists(userDto.getUsername())){
            throw new UsernameExistsException("Username" + userDto.getUsername() + "already exists");
        }

        return repository.save(mapper.map(userDto,User.class));

    }



    @Transactional(rollbackFor = UserDoesNotExistException.class)
    public User findUser(String email){

        User user = repository.findByEmail(email);
        if(user == null){
            throw new UserDoesNotExistException("User with email" + email + "does not exist");
        }
    }




    private boolean usernameAlreadyExists(String username){

        User user = repository.findByUsername(username);

        return user != null;
    }


    private boolean emailAlreadyExists(String email){
        User user = repository.findByEmail(email);
        return user != null;

    }

}
