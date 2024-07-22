package bo.enterprisesample.ecommerce.service.email;

import bo.enterprisesample.ecommerce.domain.enums.EmailTemplates;
import bo.enterprisesample.ecommerce.domain.record.Product;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements IEmailService {
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    // Require: @EnableAsync annotation in main class
    @Async
    @Override
    public void sendPaymentSuccessEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            String orderReference
    ) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper messageHelper =
                new MimeMessageHelper(
                        mimeMessage,
                        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                        StandardCharsets.UTF_8.name());

        messageHelper.setFrom("mircoestefanopilcoperalta@gmail.com");



        final String htmlTemplateName = EmailTemplates.PAYMENT_CONFIRMATION.getTemplate();

        Map<String, Object> htmlTemplateVariables = new HashMap<>();
        htmlTemplateVariables.put("customerName", customerName);
        htmlTemplateVariables.put("amount", amount);
        htmlTemplateVariables.put("orderReference", orderReference);

        // Context from thymeleaf
        Context context = new Context();
        context.setVariables(htmlTemplateVariables);

        messageHelper.setSubject(EmailTemplates.PAYMENT_CONFIRMATION.getSubject());

        try{
            String processedHtml = templateEngine.process(htmlTemplateName, context);
            // we are sending a text as html via email
            // Note: the second paramenter declares that the content sent is html
            messageHelper.setText(processedHtml, true);
            messageHelper.setTo(destinationEmail);
            log.info(String.format("INFO - Email successfully sent to %s with template: %s", destinationEmail, htmlTemplateName));
        }
        catch (MessagingException e ) {
            log.warn("WARNING - Email could not be sent to " + destinationEmail);
        }
    }


    @Async
    @Override
    public void sendOrderConfirmationEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            String orderReference,
            List<Product> products
    ) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper messageHelper =
                new MimeMessageHelper(
                        mimeMessage,
                        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                        StandardCharsets.UTF_8.name());

        messageHelper.setFrom("mircoestefanopilcoperalta@gmail.com");



        final String htmlTemplateName = EmailTemplates.ORDER_CONFIRMATION.getTemplate();

        Map<String, Object> htmlTemplateVariables = new HashMap<>();
        htmlTemplateVariables.put("customerName", customerName);
        htmlTemplateVariables.put("orderReference", orderReference);
        htmlTemplateVariables.put("totalAmount", amount);
        htmlTemplateVariables.put("products", products);

        // Context from thymeleaf
        Context context = new Context();
        context.setVariables(htmlTemplateVariables);

        messageHelper.setSubject(EmailTemplates.ORDER_CONFIRMATION.getSubject());

        try{
            String processedHtml = templateEngine.process(htmlTemplateName, context);
            // we are sending a text as html via email
            // Note: the second paramenter declares that the content sent is html
            messageHelper.setText(processedHtml, true);
            messageHelper.setTo(destinationEmail);
            log.info(String.format("INFO - Email successfully sent to %s with template: %s", destinationEmail, htmlTemplateName));
        }
        catch (MessagingException e ) {
            log.warn("WARNING - Email could not be sent to " + destinationEmail);
        }
    }



}
