package gr.Pfizer.bootcamp3.team6.restapi.model;

import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Setter
@Getter
@Entity
@DiscriminatorValue("chiefDoctor")
public class ChiefDoctor extends ApplicationUser{
    public ChiefDoctor()
    {
        setRole(CustomRole.ROLE_CHIEF_DOCTOR);
    }
}
