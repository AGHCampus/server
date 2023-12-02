package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.edu.agh.server.common.TranslatedEmailMessages;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;

    public void sendVerificationEmail(String lang, String to, String url) {
       sendMessage(TranslatedEmailMessages.verificationSubject(lang), format(TranslatedEmailMessages.verificationTemplate(lang), url), to);
    }

    public void sendResetPasswordEmail(String lang, String to, String url) {
        sendMessage(TranslatedEmailMessages.resetSubject(lang), format(TranslatedEmailMessages.resetTemplate(lang), url), to);
    }

    private void sendMessage(String subject, String text, String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}
