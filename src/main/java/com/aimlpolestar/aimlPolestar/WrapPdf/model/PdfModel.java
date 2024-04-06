package com.aimlpolestar.aimlPolestar.WrapPdf.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PdfModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String id;
    private String input_query;
    private String user_question;
}
