package com.demo.service;

import com.demo.dto.CreateUser;
import com.demo.dto.RequestChangePassword;
import com.demo.dto.UserRegister;
import com.demo.exception.BadRequestException;
import com.demo.exception.SysError;
import com.demo.utils.WebUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord.UpdateRequest;
import com.google.firebase.auth.UserRecord.CreateRequest;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService{
    private final FirebaseAuth firebaseAuth;
    private final UserService userService;
    public AuthServiceImpl(UserService userService, FirebaseAuth firebaseAuth) {
        this.userService = userService;
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    public Boolean register(UserRegister userRegister) {
        CreateRequest request = new CreateRequest();
        request.setEmail(userRegister.getEmail());
        request.setPassword(userRegister.getPassword());
        try {
            firebaseAuth.createUser(request);
        } catch (FirebaseAuthException ex) {
            throw new BadRequestException(new SysError(ex.getMessage()));
        }
        CreateUser user = CreateUser.builder()
                .email(userRegister.getEmail())
                .firstName(userRegister.getFirstName())
                .lastName(userRegister.getLastName())
                .picture(userRegister.getPicture())
                .build();
        userService.saveUserLogin(user);
        return true;
    }

    @Override
    public FirebaseToken verify(String idToken) {
        try {
            return firebaseAuth.verifyIdToken(idToken);
        } catch (FirebaseAuthException ignored) {
            throw new BadRequestException(new SysError(ignored.getMessage()));
        }
    }

    @Override
    public Boolean changePassword(RequestChangePassword json)  {
        String username = WebUtils.getUsername();
        UpdateRequest request = new UpdateRequest(username)
                .setPassword(json.getNewPassword());
        try {
            firebaseAuth.updateUser(request);
        } catch (FirebaseAuthException ignored) {
            throw new BadRequestException(new SysError(ignored.getMessage()));
        }
        return true;
    }

}
