package com.adobe.aem.guides.wknd.spa.angular.core.services;

import com.adobe.aem.guides.wknd.spa.angular.core.models.Transport;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TransportServiceImplTest {

    @InjectMocks
    private TransportServiceImpl transportService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTransportList() throws IOException, URISyntaxException {
        String transport = "Taxi";
        String url = "http://localhost:8080/my-resources/get-list?transport=" + transport;

        Transport[] expectedList = new Transport[2];
        expectedList[0] = new Transport("Tonton", "Curepipe", "Digital", "Taxi");
        expectedList[1] = new Transport("Nikhil", "Dagotiere", "Digital", "Taxi");

        Transport[] actualList = transportService.getTransportList(transport);

        assertEquals(expectedList.length, actualList.length);
        assertEquals(expectedList[0].getName(), actualList[0].getName());
        assertEquals(expectedList[1].getName(), actualList[1].getName());
    }
}