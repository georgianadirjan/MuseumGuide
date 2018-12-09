package com.example.geo.museumguide.connection.user;

import com.example.geo.museumguide.model.User;

/**
 * Created by Geo on 1/7/2017.
 */

public class LogInService {

    private static User loggedUser;

    public static void logIn(User user){
        loggedUser = user;
    }

    public static void logOut(){
        loggedUser = null;
    }

    public static User getLoggedUser(){
        return loggedUser;
    }

    public static boolean isLoggedIn(){
        return loggedUser!=null;
    }

}
