package com.example.formbuilder.model;

import java.util.List;

public interface FormConfig {
    String getTitle();
    List<FormField> getFields();
}