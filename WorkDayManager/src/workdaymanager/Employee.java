package workdaymanager;

import java.time.LocalDate;

public abstract class Employee {

    protected String name;
    protected int years;
    protected LocalDate birthDate;
    protected int freeDaysLeft = 20;

    

    public Employee(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.years = LocalDate.now().getYear() - (this.birthDate.getYear());
        addAdditionalFreeDays();
    }

    public int getFreeDaysLeft() {
        return freeDaysLeft;
    }

    public void setFreeDaysLeft(int freeDaysRequested) {
        this.freeDaysLeft -= freeDaysRequested;
    }
    
    

    public void addAdditionalFreeDays() {
        if (this.years < 28 && this.years >= 25) {
            this.freeDaysLeft += 1;
        } else if (this.years < 31) {
            this.freeDaysLeft += 2;
        } else if (this.years < 33) {
            this.freeDaysLeft += 3;
        } else if (this.years < 35) {
            this.freeDaysLeft += 4;
        } else if (this.years < 37) {
            this.freeDaysLeft += 5;
        } else if (this.years < 39) {
            this.freeDaysLeft += 6;
        } else if (this.years < 41) {
            this.freeDaysLeft += 7;
        } else if (this.years < 43) {
            this.freeDaysLeft += 8;
        } else if (this.years < 45) {
            this.freeDaysLeft += 9; 
        } else {
            this.freeDaysLeft += 10;
        }
    }
    
    public abstract void requestVacation(int daysRequested);

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", years=" + years + ", birthDate=" + birthDate + ", freeDaysLeft=" + freeDaysLeft + '}';
    }
    
    

}
