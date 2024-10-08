package com.example.jwtback.auth.oauth2;

import com.example.jwtback.auth.oauth2.dto.CustomOAuth2User;
import com.example.jwtback.auth.oauth2.dto.GoogleResponse;
import com.example.jwtback.auth.oauth2.dto.NaverResponse;
import com.example.jwtback.auth.oauth2.dto.OAuth2Response;
import com.example.jwtback.controller.dto.UserDTO;
import com.example.jwtback.entity.UserEntity;
import com.example.jwtback.enums.MediaType;
import com.example.jwtback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response;
        if (registrationId.equals("naver")) {
            oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
        }
        else if (registrationId.equals("google")) {
            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        }
        else {
            return null;
        }

        String username = oAuth2Response.getProvider() + " " + oAuth2Response.getProvider();

        UserEntity existData = userRepository.findByUsername(username);

        if (existData == null) {
            UserEntity userEntity = new UserEntity(username,"password", oAuth2Response.getName(), "ROLE_USER", MediaType.NAVER.name());

            userRepository.save(userEntity);

            UserDTO.JoinRes userDTO = new UserDTO.JoinRes(username, oAuth2User.getName(), "ROLE_USER");

            return new CustomOAuth2User(userDTO);
        }
        else {
            existData.updateName(oAuth2Response.getName());

            userRepository.save(existData);

            UserDTO.JoinRes userDTO = new UserDTO.JoinRes(username, oAuth2User.getName(), "ROLE_USER");

            return new CustomOAuth2User(userDTO);
        }
    }
}
