package com.adobe.aem.guides.wknd.spa.angular.core.services;

import com.adobe.aem.guides.wknd.spa.angular.core.models.University;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UniversityServiceImplTest {

    @Mock
    private HttpClient httpClient;

    @Mock
    private HttpGet httpGet;

    @Mock
    private HttpResponse httpResponse;

    @Mock
    private HttpEntity httpEntity;

    @InjectMocks
    private UniversityServiceImpl universityService;

    @Before
    public void setup() throws IOException {
        MockitoAnnotations.initMocks(this);

        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);

        when(httpResponse.getEntity()).thenReturn(httpEntity);

        HttpEntity httpEntity = mock(HttpEntity.class);
        String json = "[{\"name\":\"University 1\",\"country\":\"Country 1\",\"web_pages\":[\"http:\\/\\/www.university1.com\"]},{\"name\":\"University 2\",\"country\":\"Country 1\",\"web_pages\":[\"http:\\/\\/www.university2.com\"]}]";
        when(httpEntity.getContent()).thenReturn(new ByteArrayInputStream(json.getBytes()));
    }

    @Test
    public void testGetUniversities() throws IOException, URISyntaxException {
        University[] expectedUniversities = new University[4];
        expectedUniversities[0] = new University(new String[]{"Domain1", "Domain2"}, "State1", "Country1", "alphacode1", new String[]{"webpage1", "webpage2"}, "University of Mauritius");;
        expectedUniversities[1] = new University(new String[]{"Domain3", "Domain4"}, "State2", "Country2", "alphacode2", new String[]{"webpage3", "webpage4"}, "University of Technology");
        expectedUniversities[2] = new University(new String[]{"Domain1", "Domain2"}, "State1", "Country1", "alphacode1", new String[]{"webpage1", "webpage2"}, "University of Mauritius");;
        expectedUniversities[3] = new University(new String[]{"Domain3", "Domain4"}, "State2", "Country2", "alphacode2", new String[]{"webpage3", "webpage4"}, "University of Technology");

        URIBuilder uriBuilder = new URIBuilder("http://universities.hipolabs.com/search");
        uriBuilder.addParameter("country", "mauritius");
        when(httpGet.getURI()).thenReturn(uriBuilder.build());

        University[] actualUniversities = universityService.getUniversities("mauritius");

        assertEquals(expectedUniversities.length, actualUniversities.length);
        assertEquals(expectedUniversities[0].getName(), actualUniversities[0].getName());
        assertEquals(expectedUniversities[1].getName(), actualUniversities[1].getName());
    }
}