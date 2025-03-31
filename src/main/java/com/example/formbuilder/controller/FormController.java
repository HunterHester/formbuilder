package com.example.formbuilder.controller;

import com.example.formbuilder.model.FormField;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.context.Context;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.formbuilder.model.FormConfig;
import com.example.formbuilder.model.FormConfigFactory;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Controller
public class FormController {

    @Autowired
    private SpringTemplateEngine templateEngine;

    @GetMapping("/form")
    public String showForm(@RequestParam String type, Model model) {
        FormConfig config = FormConfigFactory.getForm(type);
        model.addAttribute("title", config.getTitle());
        model.addAttribute("fields", config.getFields());

        return "form";
    }

    @PostMapping("/submit")
    public String handleSubmit(@RequestParam("field") List<String> values, Model model) {
        model.addAttribute("submittedValues", values);
        return "result";
    }

    @PostMapping("/download-pdf")
    public ResponseEntity<byte[]> generatePdf(@RequestParam("field") List<String> values) {
        Context context = new Context();
        context.setVariable("submittedValues", values);
        String html = templateEngine.process("pdf-template", context);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.withHtmlContent(html, null);
        builder.toStream(outputStream);
        try {
            builder.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] pdfBytes = outputStream.toByteArray();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=form-data.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}
