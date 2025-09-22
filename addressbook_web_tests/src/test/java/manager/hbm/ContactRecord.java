package manager.hbm;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "addressbook")
public class ContactRecord {

    @Id
    public int id;
    public String firstname;
    public String middlename;
    public String lastname;
    public String company;
    public String address;
    public String mobile;
    public String email;
    public String photo;

//    public Date deprecated = new Date();

    public ContactRecord() {}

    public ContactRecord(int id,
                         String firstname,
                         String middlename,
                         String lastname,
                         String company,
                         String address,
                         String mobile,
                         String email,
                         String photo
    ) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.company = company;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.photo = photo;
    }
}
