package com.example.demo;

import com.example.demo.domain.model.Education;
import com.example.demo.domain.model.Experience;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import org.apache.poi.util.XMLHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws IOException, XDocReportException {
        SpringApplication.run(DemoApplication.class, args);

        GenerateXMLFields.hello(args);

    }

//    @Bean
//    public XMLHelper xmlHelper() {
//        // Suppress the SAX warning
//        System.setProperty("javax.xml.XMLConstants/property/accessExternalSchema", "all");
//        return new XMLHelper();
//    }
    public class GenerateXMLFields {

        public static void hello(String[] args) throws XDocReportException, IOException {

            // 1) Create FieldsMetadata by setting Velocity as template engine
            FieldsMetadata fieldsMetadata = new FieldsMetadata(TemplateEngineKind.Velocity.name());

            // 2) Load fields metadata from Java Class
            fieldsMetadata.load("educations", Education.class, true);
            // Here load is called with true because model is a list of Developer.
            fieldsMetadata.load("experiences", Experience.class, true);

            // 3) Generate XML fields in the file "project.fields.xml".
            // Extension *.fields.xml is very important to use it with MS Macro XDocReport.dotm
            // FieldsMetadata#saveXML is called with true to indent the XML.
            File xmlFieldsFile = new File("project.fields.xml");
            fieldsMetadata.saveXML(new FileOutputStream(xmlFieldsFile), true);
        }
    }

}
