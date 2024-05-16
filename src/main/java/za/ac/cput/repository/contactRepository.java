package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Contact;
import za.ac.cput.Domain.Employee;

import java.util.List;
@Repository
public interface contactRepository extends JpaRepository<Contact, String > {

}
