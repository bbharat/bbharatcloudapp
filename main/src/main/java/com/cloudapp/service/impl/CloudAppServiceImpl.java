package com.cloudapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cloudapp.data.UserDetails;
import com.cloudapp.service.CloudAppService;

public class CloudAppServiceImpl implements CloudAppService {

    //Local memory map
    private HashMap<String, UserDetails> userDetailsHashMap = new HashMap<String, UserDetails>();

    @Override
    public List<UserDetails> getUserDetails() {
        if (userDetailsHashMap.isEmpty()) {
            return null;
        } else {
            return new ArrayList<UserDetails>(userDetailsHashMap.values());
        }
    }

    @Override
    public UserDetails getUserDetails(String userKey) {
        if (userDetailsHashMap.containsKey(userKey)) {
            return userDetailsHashMap.get(userKey);
        } else {
            return null;
        }
    }

    @Override
    public void addUserDetails(UserDetails userDetails) {
        if (!userDetailsHashMap.containsKey(userDetails.getUserKey())) {
            userDetailsHashMap.put(userDetails.getUserKey(), userDetails);
        }
    }
}
