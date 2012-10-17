package com.cloudapp.rest;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.cloudapp.data.UserDetails;
import com.cloudapp.service.CloudAppService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CloudAppController {

    private CloudAppService cloudAppService;

    @Autowired
    public void setCloudAppService(CloudAppService cloudAppService) {
        this.cloudAppService = cloudAppService;
    }

    /**
     * get a user by key
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage() {
        return "home";
    }

    /**
     * get a user by key
     */
    @RequestMapping(value = "/users/{userKey}", method = RequestMethod.GET)
    @ResponseBody
    public UserDetails getConferenceDetails(HttpServletResponse response,
            @PathVariable("userKey") String userKey) {

        UserDetails userDetails = cloudAppService.getUserDetails(userKey);
        response.setStatus(HttpServletResponse.SC_OK);

        return userDetails;
    }

    /**
     * Get all users
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDetails> getAllUsers() {
        return cloudAppService.getUserDetails();
    }

    /**
     * Add a user
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public
    @ResponseBody
    String addUser(@RequestBody Map<String, String> attributesMap) {
        UserDetails userDetails = new UserDetails();
        userDetails.setEmail(attributesMap.get("email"));
        userDetails.setFirstName(attributesMap.get("firstname"));
        userDetails.setLastName(attributesMap.get("lastname"));
        userDetails.setUserKey(attributesMap.get("userkey"));

        cloudAppService.addUserDetails(userDetails);
        return userDetails.getUserKey();
    }
}
