package gr.Pfizer.bootcamp3.team6.restapi.representation;

import gr.Pfizer.bootcamp3.team6.restapi.model.ApplicationUser;
import gr.Pfizer.bootcamp3.team6.restapi.model.Gender;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import lombok.Data;
import java.util.Date;

@Data
public class ApplicationUserRepresentation {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private long telephoneNumber;
    private String address;
    private Date dob;
    private Gender gender;
    private CustomRole role;

    static public ApplicationUserRepresentation  getUserApplicationRepresentation(ApplicationUser user){
        ApplicationUserRepresentation  userRepresentation  = new ApplicationUserRepresentation();

        userRepresentation.setId(user.getId());
        userRepresentation.setUsername(user.getUsername());
        userRepresentation.setFirstName(user.getFirstName());
        userRepresentation.setLastName(user.getLastName());
        userRepresentation.setEmail(user.getEmail());
        userRepresentation.setTelephoneNumber(user.getTelephoneNumber());
        userRepresentation.setAddress(user.getAddress());
        userRepresentation.setDob(user.getDob());
        userRepresentation.setGender(user.getGender());
        userRepresentation.setRole(CustomRole.getRoleValue(user.getRole().getRoleName()));

        return userRepresentation;
    }
}