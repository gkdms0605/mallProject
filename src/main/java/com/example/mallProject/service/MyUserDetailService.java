//package com.example.mallProject.service;
//
//import com.example.mallProject.domain.MyUserDetails;
//import com.example.mallProject.domain.User;
//import com.example.mallProject.entity.UserEntity;
//import com.example.mallProject.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.NoSuchElementException;
//
//@Service
//@RequiredArgsConstructor
//public class MyUserDetailService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        try {
//            UserEntity entity = userRepository.findByEmail(username).orElseThrow();
//            User user = User.toDomain(entity);
//
//            return new MyUserDetails(user);
//
//        } catch (NoSuchElementException e) {
//            throw new UsernameNotFoundException(username);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
