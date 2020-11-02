package gr.Pfizer.bootcamp3.team6.restapi.model;

import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_role")
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected long telephoneNumber;
    protected String address;
    protected Date dob;
    protected Gender gender;
    protected boolean isActive;
    protected CustomRole role;

    public boolean checkIfActive()
    {
        return isActive;
    }

    protected void setRole(CustomRole role)
    {
        this.role = role;
    }
}