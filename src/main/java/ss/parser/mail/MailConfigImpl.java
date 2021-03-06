package ss.parser.mail;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.internet.InternetAddress;
import java.time.Duration;

@Getter
@Setter
@Component
@ConfigurationProperties("ss-parser.mail")
class MailConfigImpl implements MailConfig {
    private boolean enabled;
    private Duration rate;
    private InternetAddress from;
    private InternetAddress[] to;
    private InternetAddress[] admin;
    private String subject;

    @PostConstruct
    private void init() {
        if (admin == null) {
            admin = new InternetAddress[]{to[0]};
        }
    }
}
