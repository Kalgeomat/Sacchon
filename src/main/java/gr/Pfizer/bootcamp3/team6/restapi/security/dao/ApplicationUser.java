package gr.Pfizer.bootcamp3.team6.restapi.security.dao;


import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.PrimaryKeyJoinColumn;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUser {


    private String username;
    private String password;
    private CustomRole role;

}