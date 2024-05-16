package za.ac.cput.factory;

import za.ac.cput.Domain.Contact;
import za.ac.cput.Domain.Employee;
import za.ac.cput.util.Helper;

public class EmployeeFactory {
    public static Employee createEmployee(long employeeNumber, String firstName, String lastName, String email, String mobile, String workTelephone) {
        if (Helper.isNullorEmpty(String.valueOf(employeeNumber)) || Helper.isNullorEmpty(firstName) || Helper.isNullorEmpty(lastName))
            return null;

        if (Helper.isNullorEmpty(email) || !Helper.isValidEmail(email) || !Helper.isValidPhoneNumber(mobile) || !Helper.isValidPhoneNumber(workTelephone))
            return null;

            Contact newContact = ContactFactory.buildContact(email, mobile, workTelephone);

            return new Employee.Builder()
                    .setEmployeeNumber(employeeNumber)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setContact(newContact)
                    .Build();


    }
}
