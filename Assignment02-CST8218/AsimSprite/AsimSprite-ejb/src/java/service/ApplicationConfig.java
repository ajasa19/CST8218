/*
 *Class:    ApplicationConfig
 *Author    Asim Jasarevic & Nathan Denyer
 *project:  Assignment 02
 */
package service;

import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.ws.rs.core.Application;

/**
 *
 * @author ajasa
 */
/*added for security*/
@DatabaseIdentityStoreDefinition(
   dataSourceLookup = "${'java:comp/DefaultDataSource'}",
   callerQuery = "#{'select password from app.appuser where firstname = ?'}",
   groupsQuery = "select groupname from app.appuser where firstname = ?",
   hashAlgorithm = PasswordHash.class,
   priority = 10
)
/*@FormAuthenticationMechanismDefinition(
    loginToContinue = @LoginToContinue(
    loginPage = "/index.xhtml",
    errorPage = "/index.xhtml")) */

@BasicAuthenticationMechanismDefinition
@Named
@ApplicationScoped

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.SpriteFacadeREST.class);
    }
    
}
