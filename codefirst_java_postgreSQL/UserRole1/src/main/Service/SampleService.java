import org.springframework.stereotype.Service;

@Service
public class SampleService {
    public String getWelcomeMessage() {
        return "Merhaba! Bu, örnek bir Spring servisidir.";
    }
}
