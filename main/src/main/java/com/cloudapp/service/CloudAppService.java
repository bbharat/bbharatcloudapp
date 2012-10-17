package com.cloudapp.service;

import java.util.List;

import com.cloudapp.data.UserDetails;

public interface CloudAppService {

    List<UserDetails> getUserDetails();

    UserDetails getUserDetails(String userKey);

    void addUserDetails(UserDetails userDetails);
}
