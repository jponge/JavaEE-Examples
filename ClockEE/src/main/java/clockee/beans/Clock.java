package clockee.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Date;

@Named
@ApplicationScoped
public class Clock {

    public String getNow() {
        return new Date().toString();
    }
}
