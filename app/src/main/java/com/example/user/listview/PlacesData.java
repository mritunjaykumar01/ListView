package com.example.user.listview;

import java.util.ArrayList;
import java.util.List;

public class PlacesData {

    private List<Places> usersList = new ArrayList<Places>() {
        {
            add(new Places(0,111, "", "United States"));
            add(new Places(1, 100,"New York City", "United States"));
            add(new Places(2,100, "Las Vegas",  "United States"));
            add(new Places(3,100, "Los Angeles",  "United States"));
            add(new Places(4,100, "San Francisco",  "United States"));
            add(new Places(5, 100,"Washingation",  "United States"));
            add(new Places(6,222, "", "India"));
            add(new Places(7,101, "Delhi", "India"));
            add(new Places(8,101, "Mumbai", "India"));
            add(new Places(9,101, "Kolkata", "India"));
            add(new Places(10, 101,"Chennai",  "India"));
            add(new Places(11, 101,"Bengaluru", "India"));
            add(new Places(12, 333,"",  "France"));
            add(new Places(13, 103,"Paris", "France"));

        }
    };

    public List<Places> getUsersList() {
        return usersList;
    }

    public List<Places> deleteUsers(Places id){
        usersList.remove(id);
        return getUsersList();
    }

}
