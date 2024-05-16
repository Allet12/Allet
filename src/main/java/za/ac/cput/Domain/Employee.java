package za.ac.cput.Domain;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Locale;
@Entity

public class Employee {
    @Id
    private long employeeNumber;
    private String firstName;
    private String lastName;
    @OneToOne
    //@Cascade(CascadeType.ALL)
    //@JoinColumn()
    private Contact contact;

    protected Employee() {
    }


    public Employee(Builder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contact = builder.contact;
    }

    public Employee(long employeeNumber, String firstName, String lastName, Contact contact) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public Contact getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;

        if (getEmployeeNumber() != employee.getEmployeeNumber()) return false;
        if (getFirstName() != null ? !getFirstName().equals(employee.getFirstName()) : employee.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(employee.getLastName()) : employee.getLastName() != null)
            return false;
        return getContact() != null ? getContact().equals(employee.getContact()) : employee.getContact() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getEmployeeNumber() ^ (getEmployeeNumber() >>> 32));
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getContact() != null ? getContact().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class Builder{
        private long employeeNumber;
        private String firstName;
        private String lastName;
        private Contact contact;

        public Builder setEmployeeNumber(long employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder copy(Employee employee){
            this.employeeNumber = employee.employeeNumber;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.contact = employee.contact;
            return this;
        }
        public Employee Build(){
            return new Employee(this);
        }
    }

}
