package com.projectpandas.ridemory.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectpandas.ridemory.util.dto.EmailDto;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public User createUser(EmailDto email) {
        User user = userRepository.getUserByEmail(email.getEmail());
        if (user != null) {
            logger.warn("Tried creating {}, but {} already exists.", user, user);
            return null;
        }

        try {
            user = User.createNew(email.getEmail());
            userRepository.save(user);
            return user;
        } catch (Exception e) {
            return null;
        }
    }
}
