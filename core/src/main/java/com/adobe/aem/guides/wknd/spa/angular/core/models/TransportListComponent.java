package com.adobe.aem.guides.wknd.spa.angular.core.models;

import com.adobe.cq.export.json.ComponentExporter;

import java.io.IOException;
import java.net.URISyntaxException;

public interface TransportListComponent extends ComponentExporter {
    public Transport[] getTransportList() throws IOException, URISyntaxException;
}
