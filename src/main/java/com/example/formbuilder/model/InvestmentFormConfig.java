package com.example.formbuilder.model;

import java.util.List;

public class InvestmentFormConfig implements FormConfig {

    @Override
    public String getTitle() {
        return "Investment Onboarding Form";
    }

    @Override
    public List<FormField> getFields() {
        return List.of(
                new FormField("Customer Name", "text"),
                new FormField("Customer ID", "number"),
                new FormField("Initial Investment", "number"),
                new FormField("Date of Investment", "date")
        );
    }
}
