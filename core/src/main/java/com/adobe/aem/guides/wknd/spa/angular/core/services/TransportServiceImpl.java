package com.adobe.aem.guides.wknd.spa.angular.core.services;

import com.adobe.aem.guides.wknd.spa.angular.core.models.Transport;
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


@Component(name = "TransportService", immediate = true)
public class TransportServiceImpl implements TransportService {
    public Transport[] getTransportList(String transport) throws IOException, URISyntaxException {
        ObjectMapper objmapper = new ObjectMapper();

        String url = "http://localhost:8080/my-resources/get-list";

        HttpClient client = HttpClients.createDefault();
        URIBuilder builder = new URIBuilder(url);
        builder.addParameter("transport", transport);
        String urlUri = builder.build().toString();

        HttpGet getResponseMethod = new HttpGet(urlUri);
        HttpResponse ResponseMsg = client.execute(getResponseMethod);
        String responseBody = EntityUtils.toString(ResponseMsg.getEntity());
        Transport[] transports = objmapper.readValue(responseBody, Transport[].class);

        return transports;
    }
}
