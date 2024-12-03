package service;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailService {
    public void enviarNotificacao(String destinatario, String assunto, String mensagem) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.example.com"); // Substitua pelo seu servidor SMTP
        props.put("mail.smtp.port", "587");// eu li tava lendo sobre esse smtp e achei interessante colocar me avisem no whats o que acham :)
//mas da um pouco de trabalho tem que configurar.... vou deixar aqui para ver se o quirino aceita ou se der muito trabalho excluí :/
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("seu-email@example.com", "sua-senha"); // Substitua pelo seu e-mail e senha
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("seu-email@example.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(assunto);
            message.setText(mensagem);

            Transport.send(message);
            System.out.println("E-mail enviado com sucesso!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}