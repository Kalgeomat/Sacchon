package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.model.ApplicationUser;
import gr.Pfizer.bootcamp3.team6.restapi.representation.ApplicationUserRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.LoginResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ServerResource;
import java.util.ArrayList;
import java.util.List;

public class LoginResourceImpl extends ServerResource implements LoginResource {
    private static ApplicationUser staticUser;

    @Override
    public ApplicationUserRepresentation login() throws NotFoundException {
        List<String> roles = new ArrayList<>();
        roles.add(CustomRole.ROLE_PATIENT.getRoleName());
        roles.add(CustomRole.ROLE_DOCTOR.getRoleName());
        roles.add(CustomRole.ROLE_CHIEF_DOCTOR.getRoleName());
        ResourceUtils.checkRoles(this, roles);

        return ApplicationUserRepresentation.getUserApplicationRepresentation(staticUser);
    }

    public static void setUser(ApplicationUser user)
    {
        staticUser = user;
    }
}