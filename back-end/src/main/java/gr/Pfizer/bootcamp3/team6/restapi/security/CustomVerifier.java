package gr.Pfizer.bootcamp3.team6.restapi.security;

import gr.Pfizer.bootcamp3.team6.restapi.model.ApplicationUser;
import gr.Pfizer.bootcamp3.team6.restapi.resource.impl.LoginResourceImpl;
import org.restlet.Request;
import org.restlet.security.Role;
import org.restlet.security.SecretVerifier;
import javax.persistence.NoResultException;

public class CustomVerifier extends SecretVerifier {

    public int verify(String identifier, char[] secret) throws IllegalArgumentException {
        ApplicationUserPersistence userPersistance = ApplicationUserPersistence.getApplicationUserPersistence();
        ApplicationUser user = null;
        try {
            user = userPersistance.findById(identifier);
        }
        catch (NoResultException exception)
        {
            return SecretVerifier.RESULT_INVALID;
        }

        //user contains both user hints and roles
        if (user!=null && compare(user.getPassword().toCharArray(), secret)) {
            Request request = Request.getCurrent();
            request.getClientInfo().getRoles().add(new Role(user.getRole().getRoleName()));
            LoginResourceImpl.setUser(user);
            return SecretVerifier.RESULT_VALID;
        } else {
            return SecretVerifier.RESULT_INVALID;
        }
    }
}