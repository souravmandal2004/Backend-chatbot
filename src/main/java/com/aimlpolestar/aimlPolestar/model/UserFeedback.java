// UserFeedback.java
package com.aimlpolestar.aimlPolestar.model;

import lombok.Data;



@Data
public class UserFeedback {
    // Fields
    private String question;
    private String answer;
    private boolean userRating;

//    // Getters and setters
//    public String getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(String question) {
//        this.question = question;
//    }
//
//    public String getAnswer() {
//        return answer;
//    }
//
//    public void setAnswer(String answer) {
//        this.answer = answer;
//    }
//
    public boolean getUserRating() {
        return userRating;
    }
//
//    public void setUserRating(boolean userRating) {
//        this.userRating = userRating;
//    }
}
