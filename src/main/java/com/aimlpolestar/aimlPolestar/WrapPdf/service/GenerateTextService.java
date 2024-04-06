package com.aimlpolestar.aimlPolestar.WrapPdf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GenerateTextService {
    @Autowired
    private RestTemplate restTemplate;

    // wrapper of http://13.201.134.179:5000/get_answer api
    public String getAnswer(String inputQuery) {
        String getAnswerUrl = "http://13.201.134.179:5000/get_answer";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(inputQuery, headers);
        return restTemplate.postForObject(getAnswerUrl, request, String.class);
    }
}
