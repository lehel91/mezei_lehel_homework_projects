
package workdaymanager;

import java.time.LocalDate;


public class WorkDayManager {

    public static void main(String[] args) {
        Ceo karoly = new Ceo("Kovacs Karoly", LocalDate.parse("1991-01-20"));
        Manager peter = new Manager("Horvath Peter", LocalDate.parse("1980-01-20"), karoly);
        Employee lajos = new WhiteCollarEmployee("Fekete Kazmer", LocalDate.parse("1985-10-20"), peter);
        
        lajos.requestVacation(3);
        peter.printRequests();
        System.out.println(lajos);
        
        peter.requestVacation(15);
        peter.requestVacation(3);
        karoly.printRequests();
        System.out.println(peter);

    }
    
}
