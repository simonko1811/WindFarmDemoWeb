package sk.fri.uniza.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

@JsonPropertyOrder({
    "id",
    "co",
    "kto",
    "kedy"
})
public class Data {
    @NotEmpty
    @JsonProperty("id")
    private Long id;
    @Length(max=45)
    @JsonProperty("kto")
    private String kto;
    @JsonProperty("co")
    private int co;
    @JsonProperty("kedy")
    private DateTime kedy;

    public Data () {}

    public Data(Long id, String kto, int co, DateTime kedy) {
        this.id = id;
        this.kto = kto;
        this.co = co;
        this.kedy = kedy;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("kto")
    public String getKto() {
        return kto;
    }

    @JsonProperty("kto")
    public void setKto(String kto) {
        this.kto = kto;
    }

    @JsonProperty("co")
    public int getCo() {
        return co;
    }

    @JsonProperty("co")
    public void setCo(int co) {
        this.co = co;
    }

    @JsonProperty("kedy")
    public DateTime getKedy() {
        return kedy;
    }

    @JsonProperty("kedy")
    public void setKedy(DateTime kedy) {
        this.kedy = kedy;
    }
}
