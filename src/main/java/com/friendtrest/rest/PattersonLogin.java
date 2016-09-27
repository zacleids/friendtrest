package com.friendtrest.rest;

import com.friendtrest.PattersonUser;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;

/**
 * REST service that handles login/creatAccount requests
 *
 * This is a "root resource class" as explained in
 * https://jersey.java.net/documentation/latest/jaxrs-resources.html
 */
@Path("/")
public class PattersonLogin {
    ArrayList<PattersonUser> users = new ArrayList<PattersonUser>();

    // add the array list with fake users (temp dummy database)
    public PattersonLogin() {
        users.add(new PattersonUser("CodyP42", "hello123"));
        users.add(new PattersonUser("ZacL42", "goodbye123"));
        users.add(new PattersonUser("AustinZ42", "farewell123"));
        users.add(new PattersonUser("SeanT42", "greetings123"));
    }

    @GET
    @Path("/login")
    public String attempLogin(@QueryParam("username") String username, @QueryParam("password") String password) {
        if (checkCredentials(username, password))
    	   return "Hello, " + username + "\n";
        
        return "Bad username/password.\n";
    }

    @GET
    @Path("/createAccount")
    public String attemptCreateAccount(@QueryParam("username") String username, @QueryParam("password") String password) {
        if (!userExists(username)) {
            users.add(new PattersonUser(username, password));
            return "Welcome " + username + ". Account created successfuly!\n";
        }

        return "Account already exists.\n";
    }

    public boolean checkCredentials(String username, String password) {
        for (PattersonUser tempUser : users) {
            if (tempUser.getUsername().equals(username))
                if (tempUser.getPassword().equals(password))
                    return true;
        }
        return false;
    }

    public boolean userExists(String username) {
        for (PattersonUser tempUser : users) {
            if (tempUser.getUsername().equals(username))
                return true;
        }
        return false;
    }
}
