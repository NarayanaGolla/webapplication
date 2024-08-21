package com.training.javamail;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class JavaMailDemo {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.prot", "587");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication("gollanarayana114@gmail.com", "JanInfy@2022");
                    }
                }
        );
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("gollanarayana114@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("gollanarayana114@gmail.com"));
            message.setSubject("MAIL SUBJECT !");
            message.setText("MAIL BODY !");
            Transport.send(message);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    }
