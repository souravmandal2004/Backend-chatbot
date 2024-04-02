package com.aimlpolestar.aimlPolestar.model;

import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;


@Data
public class SessionDetails {

    // Field
    private String sessionId;
    private String crtUser;
    private ArrayList<UserFeedback> userFeedbacks = new ArrayList<>();


    // Method to add user feedback
    public void addUserFeedback(UserFeedback feedback) {

        userFeedbacks.add(feedback);
    }

    // Method to remove user feedback
    public void removeUserFeedback(UserFeedback feedback) {

        userFeedbacks.remove(feedback);
    }



}
