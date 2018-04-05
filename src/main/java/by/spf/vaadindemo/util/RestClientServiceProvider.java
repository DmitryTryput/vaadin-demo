package by.spf.vaadindemo.util;

import by.spf.vaadindemo.domain.DomainCategory;
import by.spf.vaadindemo.mapping.ClassCategoryMapper;
import by.spf.vaadindemo.mapping.DomainCategoryMapper;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

import static javax.ws.rs.client.Entity.json;


@Component
public class RestClientServiceProvider {

    //    private String url = "http://178.124.206.49:8080/SFP/domainCategories";
    private String url = "http://localhost:8080/domainCategories";


    private final RestTemplate restTemplate;

    @Autowired
    public RestClientServiceProvider(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<DomainCategory> getDomainCategories() {
        DomainCategory[] domainCategories = restTemplate.getForObject(url, DomainCategory[].class);
        return Arrays.asList(domainCategories);
    }

    public ResponseEntity saveClassCategory(Long domainCategoryId, ClassCategoryMapper classCategory) {
        try {
            return restTemplate.postForEntity(url + "/" + domainCategoryId + "/classCategories", classCategory, ClassCategoryMapper.class);
        } catch (final HttpClientErrorException httpClientErrorException) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity saveDomainCategoryWithClassCategory(DomainCategoryMapper domainCategory) {
        try {
            return restTemplate.postForEntity(url, domainCategory, DomainCategoryMapper.class);
        } catch (final HttpClientErrorException httpClientErrorException) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
