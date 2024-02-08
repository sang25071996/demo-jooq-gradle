package com.demo.service;

import com.demo.dto.RequestChangePassword;
import com.demo.dto.UserRegister;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

import java.security.GeneralSecurityException;

public interface AuthService {
    Boolean register(UserRegister userRegister) throws FirebaseAuthException, GeneralSecurityException;
    FirebaseToken verify(String idToken);
    Boolean changePassword(RequestChangePassword json);
}
