//package com.subash.api.serviceimpl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    private final static String fromEmail = "noreply@yourdomain.com";
//
//    public void sendEmail(String to, String subject, String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(fromEmail); 
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        javaMailSender.send(message);
//    }
//}

package com.subash.api.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import javax.activation.DataSource;
//import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;
import jakarta.mail.util.ByteArrayDataSource;
import jakarta.mail.internet.MimeMessage;

@Service
public class SchoolEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private final static String fromEmail = "noreply@yourdomain.com";

    public void sendEmailWithAttachments(String to, String employeeName, 
                                         byte[] educationTenth, byte[] educationTwelth 
                                         ) throws jakarta.mail.MessagingException, IOException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

        messageHelper.setFrom(fromEmail);
        messageHelper.setTo(to);
        messageHelper.setSubject("Employee Records for Verification");
        
        StringBuilder text = new StringBuilder();
        text.append("Dear Verifier,\n\n");
        text.append("Please find the attached records for the employee: ").append(employeeName).append(".\n");
        text.append("The following documents are attached:\n");

        // Append attachments list
        
        if (educationTenth != null) text.append("- Education_Tenth.pdf\n");
        if (educationTwelth != null) text.append("- Education_Twelth.pdf\n");
        
        
        text.append("\nBest regards,\nYour Company");

        messageHelper.setText(text.toString());

        // Attach PDF files
       
        if (educationTenth != null) messageHelper.addAttachment("Education_Tenth.pdf", new ByteArrayDataSource(educationTenth, "application/pdf"));
        if (educationTwelth != null) messageHelper.addAttachment("Education_Twelth.pdf", new ByteArrayDataSource(educationTwelth, "application/pdf"));
        

        javaMailSender.send(mimeMessage);
    }
}

