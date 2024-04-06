package com.aimlpolestar.aimlPolestar.chat.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aimlpolestar.aimlPolestar.chat.model.SessionDetails;
import com.aimlpolestar.aimlPolestar.chat.model.UserFeedback;
import com.aimlpolestar.aimlPolestar.chat.repository.ChatHistoryRepo;
import org.springframework.web.client.RestTemplate;


@Service
public class ChatHistoryService {

    @Autowired
    private final ChatHistoryRepo chatHistoryRepo;

    public ChatHistoryService(ChatHistoryRepo chatHistoryRepo) {
        this.chatHistoryRepo = chatHistoryRepo;
    }

    //function to save chat history
    public void saveChatHistory(SessionDetails sessionDetails) throws IOException {
        for (UserFeedback feedback : sessionDetails.getUserFeedbacks()) {
            feedback.setSessionDetails(sessionDetails);
        }
        chatHistoryRepo.save(sessionDetails);
    }


}