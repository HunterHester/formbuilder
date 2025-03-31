package com.example.formbuilder.dto;

import com.example.formbuilder.model.FormField;

import java.util.List;

public class FormConfigResponse {
    private String title;
    private List<FormField> fields;

    public FormConfigResponse(String title, List<FormField> fields) {
        this.title = title;
        this.fields = fields;
    }

    public String getTitle() {
        return title;
    }

    public List<FormField> getFields() {
        return fields;
    }
}
