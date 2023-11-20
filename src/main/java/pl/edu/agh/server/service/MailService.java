package pl.edu.agh.server.service;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class MailService {
    private static final String VERIFICATION_SUBJECT_PL = "Aktywuj swoje konto";
    private static final String VERIFICATION_SUBJECT_EN = "Activate your account";
    private static final String VERIFICATION_TEMPLATE_PL = "Link do aktywacji konta: %s";
    private static final String VERIFICATION_TEMPLATE_EN = "Link for account activation: %s";

    private final JavaMailSender mailSender;

    public void sendVerificationEmail(@Nullable String lang, String to, String url) {
        if (lang == null) {
            lang = "PL";
        }

        if (lang.equals("EN")) {
            sendMessage(VERIFICATION_SUBJECT_EN, VERIFICATION_TEMPLATE_EN, to, url);
        } else {
            sendMessage(VERIFICATION_SUBJECT_PL, VERIFICATION_TEMPLATE_PL, to, url);
        }
    }

    private void sendMessage(String subject, String template, String to, String url) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(format(template, url));
        mailSender.send(message);
    }
}
