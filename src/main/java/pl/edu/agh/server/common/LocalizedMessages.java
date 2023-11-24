package pl.edu.agh.server.common;

import jakarta.annotation.Nullable;

import java.util.Map;

public class LocalizedMessages {
    private static final Map<String, String> VERIFICATION_SUBJECT = Map.of("PL", "Aktywuj swoje konto", "EN", "Activate your account");
    private static final Map<String, String> VERIFICATION_TEMPLATE = Map.of("PL", "Link do aktywacji konta: %s", "EN", "Link for account activation: %s");
    private static final Map<String, String> VERIFIED = Map.of("PL", "Konto pomyślnie zweryfikowane", "EN", "Account successfully verified");
    private static final Map<String, String> RESET_SUBJECT = Map.of("PL", "Resetowanie hasła", "EN", "Reset password");
    private static final Map<String, String> RESET_TEMPLATE = Map.of("PL", "Link do resetowania hasła: %s", "EN", "Link for password reset: %s");
    private static final Map<String, String> RESET = Map.of("PL", "Hasło pomyślnie zresetowane. Tymczasowe hasło: %s", "EN", "Password successfully reset. Temporary password: %s");
    private LocalizedMessages() {}

    public static String verificationSubject(@Nullable String lang) {
        return getMessage(lang, VERIFICATION_SUBJECT);
    }

    public static String verificationTemplate(@Nullable String lang) {
        return getMessage(lang, VERIFICATION_TEMPLATE);
    }

    public static String verified(@Nullable String lang) {
        return getMessage(lang, VERIFIED);
    }

    public static String resetSubject(@Nullable String lang) {
        return getMessage(lang, RESET_SUBJECT);
    }

    public static String resetTemplate(@Nullable String lang) {
        return getMessage(lang, RESET_TEMPLATE);
    }

    public static String reset(@Nullable String lang) {
        return getMessage(lang, RESET);
    }

    private static String getMessage(@Nullable String lang, Map<String, String> messageMap) {
        lang = lang == null ? "PL" : lang.toUpperCase();
        return messageMap.getOrDefault(lang, messageMap.get("PL"));
    }
}
