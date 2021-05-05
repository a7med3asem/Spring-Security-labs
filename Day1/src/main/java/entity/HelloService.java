package entity;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

public interface HelloService {

//    @RolesAllowed({"ROLE_USER"})
    @Secured(value = {"ROLE_USER,ROLE_ADMIN"})
    public String onlyUserCanAccess(String message);

    @Secured(value = {"ROLE_MANAGER"})
    public String onlyManagerCanAccess(String message);

    @Secured(value = {"ROLE_ADMIN"})
    public String onlyAdminCanAccess(String message);

    //    @RolesAllowed({"ROLE_USER"})
    @PermitAll
    public String testPermitAll(String message);

//    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
//    @PreAuthorize("hasRole('ROLE_USER') and #user.name.length() <=6")
//    @PreAuthorize("hasRole('ROLE_USER')")
    @PreAuthorize("permitAll()")
    public String testPreAuthorize(String message);

    @PostAuthorize("permitAll()")
    public String testPostAuthorize(String message);

}
