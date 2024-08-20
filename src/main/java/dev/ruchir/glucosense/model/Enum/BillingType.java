package dev.ruchir.glucosense.model.Enum;

import lombok.Getter;

@Getter
public enum BillingType {

    CONSULTATION("CONS", "Medical", 100.00, "Billing for consultation services"),
    LAB_TEST("LAB", "Diagnostic", 50.00, "Billing for laboratory tests"),
    TREATMENT("TRT", "Medical", 200.00, "Billing for medical treatments"),
    MEDICATION("MED", "Pharmacy", 75.00, "Billing for prescribed medication"),
    DIABETES_MONITORING("DMT", "Diagnostic", 30.00, "Billing for diabetes monitoring services"),
    INSULIN("INS", "Pharmacy", 120.00, "Billing for insulin supplies"),
    NUTRITION_COUNSELING("NUT", "Consultation", 90.00, "Billing for nutrition counseling related to diabetes management"),
    EDUCATION("EDU", "Educational", 60.00, "Billing for diabetes management education sessions"),
    OTHER("OTH", "Miscellaneous", 0.00, "Other types of billing");

    private final String code;
    private final String category;
    private final double defaultCost;
    private final String description;

    BillingType(String code, String category, double defaultCost, String description) {
        this.code = code;
        this.category = category;
        this.defaultCost = defaultCost;
        this.description = description;
    }
}
