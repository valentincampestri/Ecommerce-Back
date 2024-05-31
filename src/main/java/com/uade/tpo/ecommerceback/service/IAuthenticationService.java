package com.uade.tpo.ecommerceback.service;

import com.uade.tpo.ecommerceback.controllers.auth.AuthenticationRequestDto;
import com.uade.tpo.ecommerceback.controllers.auth.AuthenticationResponse;
import com.uade.tpo.ecommerceback.controllers.auth.MessageDto;
import com.uade.tpo.ecommerceback.controllers.auth.UserAttributesRequestDto;

public interface IAuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequestDto request);

    AuthenticationResponse register(UserAttributesRequestDto request);

    AuthenticationResponse login(AuthenticationRequestDto request);

    MessageDto changeAccountData(UserAttributesRequestDto request);
}
