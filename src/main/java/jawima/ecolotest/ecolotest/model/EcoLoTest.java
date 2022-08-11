package jawima.ecolotest.ecolotest.model;

import javax.persistence.*;
import java.util.Date;;

@Entity
@Table(name="Ecolo")
public class EcoLoTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long  id;
    private String url ;
    @Column(columnDefinition = "LONG VARBINARY",length = 40000)
    private String result;
    @Temporal(TemporalType.DATE)
    private Date resultDate;

    public EcoLoTest() {
    }

    public EcoLoTest(String url, String result, Date resultDate) {
        this.url = url;
        this.result = result;
        this.resultDate = resultDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getResultDate() {
        return resultDate;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }
}
