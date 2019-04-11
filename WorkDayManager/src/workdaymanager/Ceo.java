
package workdaymanager;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ceo extends Manager{

    
    public Ceo(String name, LocalDate birthDate) {
        super(name, birthDate, null);
        this.requests = new ArrayList<Request>();
    }

    @Override
    public void addRequest(Request request) {
        this.requests.add(request);
    }
    
    
}
