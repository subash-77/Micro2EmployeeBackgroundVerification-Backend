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
public class CollegeEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private final static String fromEmail = "noreply@yourdomain.com";

    public void sendEmailWithAttachments(String to, String employeeName, 
                                        
                                         byte[] sem1, byte[] sem2, byte[] sem3, byte[] sem4,
                                         byte[] sem5, byte[] sem6, byte[] sem7, byte[] sem8) throws jakarta.mail.MessagingException, IOException {

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
       
        if (sem1 != null) text.append("- Sem1.pdf\n");
        if (sem2 != null) text.append("- Sem2.pdf\n");
        if (sem3 != null) text.append("- Sem3.pdf\n");
        if (sem4 != null) text.append("- Sem4.pdf\n");
        if (sem5 != null) text.append("- Sem5.pdf\n");
        if (sem6 != null) text.append("- Sem6.pdf\n");
        if (sem7 != null) text.append("- Sem7.pdf\n");
        if (sem8 != null) text.append("- Sem8.pdf\n");
        
        
        text.append("\nBest regards,\nYour Company");

        messageHelper.setText(text.toString());

        // Attach PDF files
       
        if (sem1 != null) messageHelper.addAttachment("Sem1.pdf", new ByteArrayDataSource(sem1, "application/pdf"));
        if (sem2 != null) messageHelper.addAttachment("Sem2.pdf", new ByteArrayDataSource(sem2, "application/pdf"));
        if (sem3 != null) messageHelper.addAttachment("Sem3.pdf", new ByteArrayDataSource(sem3, "application/pdf"));
        if (sem4 != null) messageHelper.addAttachment("Sem4.pdf", new ByteArrayDataSource(sem4, "application/pdf"));
        if (sem5 != null) messageHelper.addAttachment("Sem5.pdf", new ByteArrayDataSource(sem5, "application/pdf"));
        if (sem6 != null) messageHelper.addAttachment("Sem6.pdf", new ByteArrayDataSource(sem6, "application/pdf"));
        if (sem7 != null) messageHelper.addAttachment("Sem7.pdf", new ByteArrayDataSource(sem7, "application/pdf"));
        if (sem8 != null) messageHelper.addAttachment("Sem8.pdf", new ByteArrayDataSource(sem8, "application/pdf"));
        

        javaMailSender.send(mimeMessage);
    }
}

