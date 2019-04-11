package workdaymanager;

import java.time.LocalDate;

public class WhiteCollarEmployee extends Employee {

    private Manager manager;

    public WhiteCollarEmployee(String name, LocalDate birthDate, Manager manager) {
        super(name, birthDate);
        this.manager = manager;
    }

    @Override
    public void requestVacation(int daysRequested) {
        Request request = new Request(daysRequested, this);
        this.manager.addRequest(request);
    }

}
