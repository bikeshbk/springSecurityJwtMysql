package com.springSecutiry.jwtWithMysql.security;

import com.springSecutiry.jwtWithMysql.model.UserModel;
import com.springSecutiry.jwtWithMysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException{
        UserModel userModel = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(()-> new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail));
        return UserPrincipal.create(userModel);
    }

    @Transactional
    public UserDetails loadUserById(Long id){
        UserModel userModel = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id :" + id)
        );
        return UserPrincipal.create(userModel);
    }
}
