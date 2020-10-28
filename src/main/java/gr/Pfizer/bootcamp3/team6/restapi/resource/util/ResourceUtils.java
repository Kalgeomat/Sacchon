package gr.Pfizer.bootcamp3.team6.restapi.resource.util;

import org.restlet.data.Status;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ResourceUtils {

    /**
     * Indicates if the authenticated client user associated to the current
     * request is in the given role name.
     *
     * @param serverResource    *   The current server resource.
     * @param role     *            The role to check.
     * @throws ResourceException
     *             In case the current authenticated user has not sufficient
     *             permission.
     */
    public static void checkRole(ServerResource serverResource, String role) throws ResourceException {
        if (!serverResource.isInRole(role)) {
            throw new ResourceException(
                    Status.CLIENT_ERROR_FORBIDDEN.getCode(),
                    "You're not authorized to send this call.");
        }
    }

    // this method is similar to the above one, with only difference that it checks multiple roles.
    public static void checkRoles(ServerResource serverResource, List<String> roles) throws ResourceException {
        if (roles.stream().noneMatch(role -> serverResource.isInRole(role))) {
            throw new ResourceException(
                    Status.CLIENT_ERROR_FORBIDDEN.getCode(),
                    "You're not authorized to send this call.");
        }
    }
}