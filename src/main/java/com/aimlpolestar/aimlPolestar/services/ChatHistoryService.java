package com.aimlpolestar.aimlPolestar.services;

import com.aimlpolestar.aimlPolestar.model.SessionDetails;
import com.aimlpolestar.aimlPolestar.model.UserFeedback;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

@Service
public class ChatHistoryService {

    private static final String CSV_FILE_PATH = "./chatHistory.csv";

    //function to save chat history
    public void saveChatHistory(SessionDetails sessionDetails) throws IOException {
        File file = new File(CSV_FILE_PATH);
        boolean isNewFileCreated = file.createNewFile(); // Create the file if it doesn't exist

        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            if (isNewFileCreated) {
                // Write CSV header if the file is newly created
                writer.println("SessionId,Question,Answer,UserFeedback");
            }
            for (UserFeedback feedback : sessionDetails.getUserFeedbacks()) {
                writer.println(String.format("%s,%s,%s,%s,%s", sessionDetails.getSessionId(),sessionDetails.getCrtUser(), feedback.getQuestion(), feedback.getAnswer(), feedback.getUserRating()));
            }
        }
    }
}