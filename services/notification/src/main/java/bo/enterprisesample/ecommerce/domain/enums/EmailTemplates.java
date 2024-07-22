package bo.enterprisesample.ecommerce.domain.enums;

import lombok.Getter;

public enum EmailTemplates {

    PAYMENT_CONFIRMATION("payment-confirmation.html", "Payment successfully processed"),
    ORDER_CONFIRMATION("payment-confirmation.html", "Payment successfully processed");

    @Getter
    private String template;

    @Getter
    private String subject;

    EmailTemplates(String template, String subject) {
        this.template = template;
        this.subject = subject;
    }
}
