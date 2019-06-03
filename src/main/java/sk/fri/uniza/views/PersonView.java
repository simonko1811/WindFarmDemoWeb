package sk.fri.uniza.views;

import sk.fri.uniza.api.Person;
import sk.fri.uniza.core.User;

import javax.ws.rs.core.UriInfo;

public class PersonView extends MaterializePage<MaterializeHeader, MaterializeFooter> {
    private final User loginUser;
    private final Person person;
    private final String toastMsg;

    public PersonView(UriInfo uriInfo, User loginUser, Person person, String toastMsg) {
        super("person.ftl", uriInfo, new MaterializeHeader(loginUser, "User Info", true), new MaterializeFooter());
        this.loginUser = loginUser;
        this.person = person;
        this.toastMsg = toastMsg;
    }

    public String getToastMsg() {
        return toastMsg;
    }

    public User getLoginUser() {
        return loginUser;
    }

    public Person getPerson() {
        return person;
    }
}
