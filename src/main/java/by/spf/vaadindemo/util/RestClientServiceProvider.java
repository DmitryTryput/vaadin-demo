package by.spf.vaadindemo.util;

import by.spf.vaadindemo.domain.DomainCategory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import java.util.List;


@Component
public class RestClientServiceProvider {

//    private String url = "http://178.124.206.49:8080/SFP/domainCategories";
    private String url = "http://localhost:8080/domainCategories";

    private Client client;
    private WebTarget webTarget;

    public RestClientServiceProvider() {
        client = ClientBuilder.newClient();
        webTarget = client.target(url)
                .property(HttpHeaders.ACCEPT, "application/json;charset=utf8")
                .property(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf8")
                .register(JacksonFeature.class);
    }

    public List<DomainCategory> getDomainCategories(){
        return webTarget
                .queryParam("action", "creation")
                .request()
                .get()
                .readEntity(new GenericType<List<DomainCategory>>() {});
    }
}
