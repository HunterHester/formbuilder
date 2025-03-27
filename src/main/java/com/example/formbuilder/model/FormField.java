package com.example.formbuilder.model;

public class FormField {
    private String label;
    private String type;

    public FormField(String label, String type) {
        this.label = label;
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public String getType() {
        return type;
    }
}
