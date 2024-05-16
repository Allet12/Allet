package za.ac.cput.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Contact {
    @Id
    private String email;
    private String mobile;
    private String workTelephone;

    protected Contact(){

    }
    public Contact(Builder builder){
        this.email = builder.email;
        this.mobile = builder.mobile;
        this.workTelephone = builder.workTelephone;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWorkTelephone() {
        return workTelephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;

        if (getEmail() != null ? !getEmail().equals(contact.getEmail()) : contact.getEmail() != null) return false;
        if (getMobile() != null ? !getMobile().equals(contact.getMobile()) : contact.getMobile() != null) return false;
        return getWorkTelephone() != null ? getWorkTelephone().equals(contact.getWorkTelephone()) : contact.getWorkTelephone() == null;
    }

    @Override
    public int hashCode() {
        int result = getEmail() != null ? getEmail().hashCode() : 0;
        result = 31 * result + (getMobile() != null ? getMobile().hashCode() : 0);
        result = 31 * result + (getWorkTelephone() != null ? getWorkTelephone().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", workTelephone='" + workTelephone + '\'' +
                '}';
    }
    public static class Builder{
        private String email;
        private String mobile;
        private String workTelephone;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder setWorkTelephone(String workTelephone) {
            this.workTelephone = workTelephone;
            return this;
        }
        public Builder copy(Contact contact){
            this.email = contact.email;
            this.mobile = contact.mobile;
            this.workTelephone = contact.workTelephone;
            return this;
        }
        public Contact Build(){
            return new Contact(this);
        }
    }
}
