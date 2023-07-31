package com.adobe.aem.guides.wknd.spa.angular.core.models;

import com.adobe.aem.guides.wknd.spa.angular.core.models.impl.UniversityListComponentImpl;
import com.adobe.aem.guides.wknd.spa.angular.core.services.UniversityService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.reflect.Whitebox;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UniversityListComponentImplTest {

    @Mock
    private UniversityService universityService;

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    @InjectMocks
    private UniversityListComponentImpl universityListComponent;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCountry() throws IOException, URISyntaxException {
        University[] expectedList = new University[2];
        expectedList[0] = new University(new String[]{"Domain1", "Domain2"}, "State1", "Country1", "alphacode1", new String[]{"webpage1", "webpage2"}, "name1");
        expectedList[1] = new University(new String[]{"Domain3", "Domain4"}, "State2", "Country2", "alphacode2", new String[]{"webpage3", "webpage4"}, "name2");

        when(universityService.getUniversities(anyString())).thenReturn(expectedList);
        Whitebox.setInternalState(universityListComponent, "country", "Country1");

        University[] actualList = universityListComponent.getCountry();

        assertEquals(expectedList.length, actualList.length);
        assertEquals(expectedList[0].getName(), actualList[0].getName());
        assertEquals(expectedList[1].getName(), actualList[1].getName());
    }
}