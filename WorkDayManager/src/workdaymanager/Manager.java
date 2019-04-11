package workdaymanager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

    protected List<Request> requests;
    private Ceo manager;

    public Manager(String name, LocalDate birthDate, Ceo ceo) {
        super(name, birthDate);
        this.requests = new ArrayList<Request>();
        this.manager = ceo;
    }

    @Override
    public void requestVacation(int daysRequested) {
        Request request = new Request(daysRequested, this);
        this.manager.addRequest(request);
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public void addRequest(Request request) {
        this.requests.add(request);
    }

    public void evaluateRequest(Request request) {
        if (request.getLength() > request.getApplicant().getFreeDaysLeft()) {
            request.setStatus(RequestStatus.REJECTED);
        } else {
            int decision;
            do {
                decision = extra.Console.readInt("1. Approve\n2. Pending\n3. Reject\nDecision:");
            } while (decision != 1 && decision != 2 && decision != 3);

            if (decision == 1) {
                request.setStatus(RequestStatus.APPROVED);
                request.getApplicant().setFreeDaysLeft(request.getLength());
            } else if (decision == 2) {
                request.setStatus(RequestStatus.PENDING);
            } else {
                request.setStatus(RequestStatus.REJECTED);
            }
        }
    }
    
    public void printRequests() {
        for (Request request : this.requests) {
            if (request.getStatus().equals(RequestStatus.PENDING)) {
                System.out.println(request);
                evaluateRequest(request);
            }
        }
    }
}
