
package workdaymanager;

import java.time.LocalDate;


public class BlueCollarEmployee extends Employee {

    private Manager manager;
    
    public BlueCollarEmployee(String name, LocalDate birthDate, Manager manager) {
        super(name, birthDate);
        this.manager = manager; 
        this.freeDaysLeft += 2;
    }

    @Override
    public void requestVacation(int daysRequested) {
        Request request = new Request(daysRequested, this);
        this.manager.addRequest(request);
    }
    
    
}
