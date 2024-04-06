package com.aimlpolestar.aimlPolestar.WrapPdf.controller;

import com.aimlpolestar.aimlPolestar.WrapPdf.model.PdfModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProcessPdfController {

    @PostMapping("/process_pdf")
    public ResponseEntity<String> wrapProcessPdf(@RequestBody PdfModel pdfModel) {
        // Create HTTP headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        // Create HTTP entity with the request body and headers
        HttpEntity<PdfModel> requestEntity = new HttpEntity<>(pdfModel, headers);

        // Make a request to the external API
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://13.201.134.179:5000/process_pdf",
                HttpMethod.POST,
                requestEntity,
                String.class);

        return responseEntity;
    }
}
