package za.ac.cput.factory;

import za.ac.cput.Domain.Contact;
import za.ac.cput.util.Helper;

public class ContactFactory {

    public static Contact buildContact(String email, String mobile, String workTelephone){
        if(Helper.isNullorEmpty(email) || !Helper.isValidEmail(email) || !Helper.isValidPhoneNumber(mobile) || !Helper.isValidPhoneNumber(workTelephone)){
            return null;
        }
        return new Contact.Builder().setEmail(email).setMobile(mobile).setWorkTelephone(workTelephone).Build();
    }
}
