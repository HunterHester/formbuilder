package com.example.formbuilder.model;

import com.example.formbuilder.model.configs.ClientProfileFormConfig;
import com.example.formbuilder.model.configs.InvestmentFormConfig;

public class FormConfigFactory {
    public static FormConfig getForm(String type) {
        return switch (type.toLowerCase()) {
            case "investment" -> new InvestmentFormConfig();
            case "client-profile" -> new ClientProfileFormConfig();
            default -> throw new IllegalArgumentException("Unknown form type: " + type);
        };
    }
}
