package com.adobe.aem.guides.wknd.spa.angular.core.services;

import com.adobe.aem.guides.wknd.spa.angular.core.models.University;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.net.URISyntaxException;
@Component(name = "UniversityService", immediate = true)
public class UniversityServiceImpl implements UniversityService {
    public University[] getUniversities(String country) throws URISyntaxException, IOException {
        ObjectMapper objmapper = new ObjectMapper();

        String url = "http://universities.hipolabs.com/search";

        HttpClient client = HttpClients.createDefault();
        URIBuilder builder = new URIBuilder(url);
        builder.addParameter("country", country);
        String urlUri = builder.build().toString();

        HttpGet getResponseMethod = new HttpGet(urlUri);
        HttpResponse ResponseMsg = client.execute(getResponseMethod);
        String responseBody = EntityUtils.toString(ResponseMsg.getEntity());
        University[] universities = objmapper.readValue(responseBody, University[].class);

        return universities;
    }
}
