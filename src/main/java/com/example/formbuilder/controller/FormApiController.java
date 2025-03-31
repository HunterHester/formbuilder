package com.example.formbuilder.controller;

import com.example.formbuilder.model.FormConfig;
import com.example.formbuilder.model.FormConfigFactory;
import com.example.formbuilder.dto.FormConfigResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/forms")
public class FormApiController {

    @GetMapping("/{type}")
    public ResponseEntity<FormConfigResponse> getForm(@PathVariable String type) {
        FormConfig config = FormConfigFactory.getForm(type);
        return ResponseEntity.ok(new FormConfigResponse(config.getTitle(), config.getFields()));
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitForm(@RequestBody Map<String, String> fieldValues) {
        //generate PDF
        return ResponseEntity.ok("Form received: " + fieldValues);
    }
}
