package pl.edu.agh.server.common;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Component
@Getter
public class RSAKeyProperties {
    private final RSAPublicKey publicKey;
    private final RSAPrivateKey privateKey;

    public RSAKeyProperties() {
        KeyPair keyPair = KeyGenerator.generateRsaKey();
        this.publicKey = (RSAPublicKey) keyPair.getPublic();
        this.privateKey = (RSAPrivateKey) keyPair.getPrivate();
    }
}
