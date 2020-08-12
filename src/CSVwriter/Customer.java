package CSVwriter;

import java.time.LocalDate;
import java.util.Date;

public class Customer implements Status {
    private String CustomerId;
    private String FullName;
    private LocalDate BirthDate;
    private Status.stat status;

    public Customer(String customerId, String fullName, Status.stat status) {
        CustomerId = customerId;
        FullName = fullName;
        this.status = status;
    }

    public Status.stat getStatus() {
        return status;
    }

    public void setStatus(Status.stat status) {
        this.status = status;
    }

    public Customer(String customerId, String fullName, LocalDate birthDate, Status.stat status) {
        CustomerId = customerId;
        FullName = fullName;
        BirthDate = birthDate;
        this.status = status;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }
}
