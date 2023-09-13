package com.example.demo.infrastructure.controller;

import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;



import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;



@RestController
@RequestMapping("/api/cv")

public class TestController {
//    @GetMapping("/toHtml")
//    @CrossOrigin
//    public ResponseEntity<String> docxToHtml() {
//        try {
//            // Load the DOCX file into Aspose Document
//            InputStream in = new ClassPathResource("static/template8.docx").getInputStream();
//            Document doc = new Document(in);
//
//            // Convert the Document to HTML
//            ByteArrayOutputStream htmlOut = new ByteArrayOutputStream();
//
//            HtmlSaveOptions saveOptions = new HtmlSaveOptions();
//            saveOptions.setImagesFolder("static"); // Set this path
//
//            doc.save(htmlOut, saveOptions);
//
//            // Return the HTML
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.TEXT_HTML);
//            return new ResponseEntity<>(htmlOut.toString("UTF-8"), headers, HttpStatus.OK);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("Error converting DOCX to HTML", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }




}
