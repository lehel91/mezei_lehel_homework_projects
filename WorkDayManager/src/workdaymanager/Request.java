
package workdaymanager;

public class Request {
    private RequestStatus status;
    private int length;
    private Employee applicant;

    public Request(int length, Employee applicant) {
        this.status = RequestStatus.PENDING;
        this.length = length;
        this.applicant = applicant;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public int getLength() {
        return length;
    }

    public Employee getApplicant() {
        return applicant;
    }
    
    

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Request{" + "status=" + status + ", length=" + length + ", "
                + "applicant=" + applicant + '}';
    }
    
     
}
