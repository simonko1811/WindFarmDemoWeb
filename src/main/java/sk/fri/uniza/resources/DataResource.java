package sk.fri.uniza.resources;

import io.dropwizard.auth.Auth;
import io.dropwizard.views.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;
import sk.fri.uniza.WindFarmDemoApplication;
import sk.fri.uniza.api.Data;
import sk.fri.uniza.api.Paged;
import sk.fri.uniza.api.Person;
import sk.fri.uniza.auth.Role;
import sk.fri.uniza.auth.Session;
import sk.fri.uniza.auth.Sessions;
import sk.fri.uniza.core.User;
import sk.fri.uniza.views.DataView;
import sk.fri.uniza.views.PersonView;
import sk.fri.uniza.views.PersonsView;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Path("/data")
public class DataResource {

    final Logger myLogger = LoggerFactory.getLogger(this.getClass());
    private Sessions sessionDao;

    public DataResource(Sessions sessionDao) {
        this.sessionDao = sessionDao;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @RolesAllowed({Role.ADMIN})
    public View getPersonsTable(@Auth User user, @Context UriInfo uriInfo, @Context HttpHeaders headers, @QueryParam("page") Integer page) {
        String sessionStr = headers.getCookies().get(Sessions.COOKIE_SESSION).getValue();
        Optional<Session> sessionOptional = sessionDao.get(sessionStr);
        sessionOptional.orElseThrow(() -> new WebApplicationException());
        Session session = sessionOptional.get();

        try {
//                // Get user info
            Person personLogin = null;
            Response<Person> personResponse = WindFarmDemoApplication.getWindFarmServis().getPerson(session.getBearerToken(), user.getId()).execute();
            if (personResponse.isSuccessful()) {
                personLogin = personResponse.body();
            }
//
            Response<List<Data>> execute = WindFarmDemoApplication.getWindFarmServis().getAllData("Bearer " + session.getToken()).execute();
            if (execute.isSuccessful()) {
                return new DataView(uriInfo, execute.body(), personLogin);
            }
            return null;
//
        } catch (IOException e) {
            e.printStackTrace();
            throw new WebApplicationException(e);
        }

    }

}
