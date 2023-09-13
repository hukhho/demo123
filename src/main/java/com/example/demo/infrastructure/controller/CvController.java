package com.example.demo.infrastructure.controller;

import com.example.demo.application.dto.CvGenerationRequest;
import com.example.demo.application.service.EducationService;
import com.example.demo.application.service.UserService;
import com.example.demo.domain.model.Education;
import com.example.demo.domain.model.User;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLConverter;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLOptions;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.io.XDocArchive;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import fr.opensagres.xdocreport.template.velocity.internal.VelocityTemplateEngine;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cv")
@CrossOrigin(origins = "*")
public class CvController {
    @Autowired
    private UserService userService;
    @Autowired
    private EducationService educationService;
    @PostMapping("/generate-cv")
    public ResponseEntity<byte[]> test(@RequestBody CvGenerationRequest request) throws Exception {
        Long templateId = request.getTemplateId();
        List<Long> educationIds = request.getEducationIds();

        // Load the DOCX template with XDocReport
        InputStream in = new ClassPathResource("static/template8.docx").getInputStream();
        IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
        FieldsMetadata metadata = report.getFieldsMetadata();
        System.out.println("metadata: " + metadata);
        // Create data for the template
        IContext context = report.createContext();
        context.put("name", "Hung");

        List<Education> allEducations = educationService.getEducationsByUserId(request.getUserId());
        System.out.println("allEducations: " + allEducations.size());

        // Filter educations based on the educationIds
        List<Education> selectedEducations = allEducations.stream()
                .filter(education -> educationIds.contains(education.getId()))
                .collect(Collectors.toList());

        if (selectedEducations.isEmpty()) {
            System.out.println("No educations were selected.");
        } else {
            System.out.println("Selected educations: " + selectedEducations.size());
        }


        context.put("educations", selectedEducations);
        System.out.println("education: " + selectedEducations.get(0).getCollege());
        // Iterate through educations and dynamically create/populate TemplateProperties entities

        // Convert the WordprocessingMLPackage to byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.XWPF); // Use XWPF converter
        report.convert(context, options, baos);

        byte[] bytes = baos.toByteArray();

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=output.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(bytes);
    }

    public static InputStream getDocument( IXDocReport report )
            throws IOException
    {
        InputStream in = XDocArchive.getInputStream( report.getOriginalDocumentArchive() );
        return in;
    }





}