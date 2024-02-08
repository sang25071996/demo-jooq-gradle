package com.demo.service;

import com.demo.dto.CreateUser;
import com.demo.entity.User;
import com.demo.repository.UserRepository;
import com.demo.utils.DateTimeUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void saveUserLogin(CreateUser createUser) {
        User user = userRepository.findByEmail(createUser.getEmail());
        if (ObjectUtils.isEmpty(user)) {
            user = new User();
            user.setIsActive(true);
            user.setCreatedDate(DateTimeUtils.getDateTimeNow());
            user.setEmail(createUser.getEmail());
            user.setPicture(createUser.getPicture());
            user.setExpiredDate(DateTimeUtils.convertStringToLocalDateTime(createUser.getExp()));
            user.setFirstName(createUser.getFirstName());
            user.setLastName(createUser.getLastName());
            userRepository.save(user);
        }
    }
}
