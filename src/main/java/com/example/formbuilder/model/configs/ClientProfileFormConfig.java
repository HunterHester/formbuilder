package com.example.formbuilder.model.configs;

import com.example.formbuilder.model.FormConfig;
import com.example.formbuilder.model.FormField;

import java.util.List;

public class ClientProfileFormConfig implements FormConfig {

    @Override
    public String getTitle() {
        return "Client Profile Form";
    }

    @Override
    public List<FormField> getFields() {
        return List.of(
            new FormField("Full Name", "text"),
            new FormField("Email Address", "email"),
            new FormField("Phone Number", "tel"),
            new FormField("Preferred Contact Method", "text")
        );
    }
}
