package com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.service;


import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    public void enviarEmailRedefinicaoSenha(String emailDestinatario, String resetLink) throws MessagingException {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.servidordeemail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("email", "senha");
            }
        };

        Session session = Session.getInstance(props, authenticator);

        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress("email"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestinatario));
        message.setSubject("Redefinição de Senha");
        message.setText("Olá, você solicitou a redefinição de senha. " +
                "Clique no link a seguir para redefinir sua senha: " + resetLink);

        Transport.send(message);

        System.out.println("E-mail de redefinição de senha enviado com sucesso!");
    }
}
