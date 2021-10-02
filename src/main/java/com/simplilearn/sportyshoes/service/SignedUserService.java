package com.simplilearn.sportyshoes.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.sportyshoes.model.SignedUsers;
import com.simplilearn.sportyshoes.repository.SignedUserRepository;
import com.simplilearn.sportyshoes.repository.UserRepository;

@Service
public class SignedUserService {
@Autowired
SignedUserRepository repository;
@Autowired
private UserRepository userRepository;
public List<SignedUsers> getAllSignedUserList(){
	List<SignedUsers> list=(List<SignedUsers>) repository.findAll();
	if(list.size() > 0) {
        return list;
    } else {
        return new ArrayList<SignedUsers>();
    }
}
public List<SignedUsers> getUserByEmail(String email){
	List<SignedUsers> list=(List<SignedUsers>) repository.findByEmail(email);
	if(list.size() > 0) {
        return list;
    } else {
        return new ArrayList<SignedUsers>();
    }
}
}
