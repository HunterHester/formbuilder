package com.example.formbuilder.model;

public class FormConfigFactory {
    public static FormConfig getForm(String type) {
        return switch (type.toLowerCase()) {
            case "investment" -> new InvestmentFormConfig();
            //more forms
            default -> throw new IllegalArgumentException("Unknown form type: " + type);
        };
    }
}
