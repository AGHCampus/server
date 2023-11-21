package pl.edu.agh.server.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.server.model.Token;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findTokenByValueAndTypeAndUsedFalse(String value, String type);
}
