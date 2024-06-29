package com.example.mallProject.service;

import com.example.mallProject.domain.User;
import com.example.mallProject.dto.UserAddDto;
import com.example.mallProject.dto.UserUpdateDto;
import com.example.mallProject.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    private final PasswordEncoder passwordEncoder;

//    public UserService(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }


    //사용자 조회
    public User getUser(String userId){
        User user = userRepository.findById(userId).orElse(null);
        if(user == null){
            throw new IllegalArgumentException("해당 아이디가 존재하지 않습니다.");
        }
        return user;
    }

    //사용자 정보 업데이트
    @Transactional
    public String updateUser(String userId, UserUpdateDto dto){
        User user = userRepository.findById(userId).orElse(null);

        if(user == null){
            throw new IllegalArgumentException("해당 아이디가 존재하지 않습니다.");
        }

        user.setUserNm(dto.getUserNm());
        user.setPassword(dto.getPassword());

        userRepository.save(user);
        return "회원 정보 수정이 완료되었습니다.";
    }

    //사용자 추가
    public String addUser(UserAddDto dto){
        User findId = userRepository.findById(dto.getUserId()).orElse(null);

        if(findId != null){
            throw new IllegalArgumentException("중복되는 아이디입니다. 아이디를 다시 입력해 주세요.");
        }

//        String encodedPassword = passwordEncoder.encode(findId.getpassword());

        User newUser = new User(
                dto.getUserId(),
                dto.getPassword(),
                dto.getName(),
                dto.getUserNm()
        );

        userRepository.save(newUser);

        return "회원가입이 완료되었습니다.";
    }

    public String deleteUser(String userId){
        User user = userRepository.findById(userId).orElse(null);
        if(user == null){
            throw new IllegalArgumentException("존재하는 아이디가 없습니다.");
        }

        userRepository.deleteById(userId);
        return "회원 삭제가 완료되었습니다.";
    }
}
