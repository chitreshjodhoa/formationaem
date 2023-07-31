package com.adobe.aem.guides.wknd.spa.angular.core.models;

import com.adobe.aem.guides.wknd.spa.angular.core.models.impl.TransportListComponentImpl;
import com.adobe.aem.guides.wknd.spa.angular.core.services.TransportService;
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
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TransportListComponentImplTest {

    @Mock
    private TransportService transportService;

    @InjectMocks
    private TransportListComponentImpl transportListComponent;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTransportList() throws IOException, URISyntaxException {
        Transport[] expectedList = new Transport[2];
        expectedList[0] = new Transport("Name1", "Address1", "Dept1", "Type1");
        expectedList[1] = new Transport("Name2", "Address2", "Dept2", "Type2");

        when(transportService.getTransportList(anyString())).thenReturn(expectedList);

        Whitebox.setInternalState(transportListComponent, "transport", "Type1");
        Transport[] actualList = transportListComponent.getTransportList();

        assertEquals(expectedList.length, actualList.length);
        assertEquals(expectedList[0].getName(), actualList[0].getName());
        assertEquals(expectedList[1].getName(), actualList[1].getName());
    }
}