package com.aimlpolestar.aimlPolestar.chat.controller;

import com.aimlpolestar.aimlPolestar.WrapPdf.model.PdfModel;
import com.aimlpolestar.aimlPolestar.chat.model.SessionDetails;
import com.aimlpolestar.aimlPolestar.chat.service.ChatHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class ChatHistoryController {

    @Autowired
    private final ChatHistoryService chatHistoryService;



    @PostMapping("/chathistory")
    public ResponseEntity<String> saveChatHistory(@RequestBody SessionDetails sessionDetails) {
        try {
            chatHistoryService.saveChatHistory(sessionDetails);
            return ResponseEntity.status(HttpStatus.CREATED).body("Chat history saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save the chat history");
        }
    }




//    @PostMapping("/process_pdf")
//    public ResponseEntity<String> wrapProcessPdf(@RequestBody PdfModel pdfModel) {
//        // Create HTTP headers
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "application/json");
//
//        // Create HTTP entity with the request body and headers
//        HttpEntity<PdfModel> requestEntity = new HttpEntity<>(pdfModel, headers);
//
//        // Make a request to the external API
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> responseEntity = restTemplate.exchange(
//                "http://13.201.134.179:5000/process_pdf",
//                HttpMethod.POST,
//                requestEntity,
//                String.class);
//
//        return responseEntity;
//    }

}