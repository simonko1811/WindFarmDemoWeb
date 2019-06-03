package sk.fri.uniza.views;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import sk.fri.uniza.api.Data;
import sk.fri.uniza.core.User;

import javax.ws.rs.core.UriInfo;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataView extends MaterializePage<MaterializeHeader, MaterializeFooter> {
    private final User loginUser;
    private String values;
    private String labels;

    private static final int LABELS_LENGTH = 6;

    public DataView(UriInfo uriInfo, List<Data> data, User loginUser) {
        super("data.ftl", uriInfo, new MaterializeHeader(loginUser, "DashBoard", true), new MaterializeFooter());
        this.loginUser = loginUser;

        values = "[";
        for (int j = 0; j < data.size(); j++) {
            values += data.get(j).getCo();
            if (j != data.size()- 1) {
                values += ", ";
            }
        }
        values += "]";

        labels = "[";
        for (int j = 0; j < data.size(); j++) {
            labels += j;
            if (j != data.size()- 1) {
                labels += ", ";
            }
        }
        labels += "]";

    }

    public User getLoginUser() {
        return loginUser;
    }

    public String getValues() {
        return values;
    }

    public String getLabels() {
        return labels;
    }
}
