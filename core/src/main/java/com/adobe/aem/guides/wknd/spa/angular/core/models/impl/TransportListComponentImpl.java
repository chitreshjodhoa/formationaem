package com.adobe.aem.guides.wknd.spa.angular.core.models.impl;

import com.adobe.aem.guides.wknd.spa.angular.core.models.Transport;
import com.adobe.aem.guides.wknd.spa.angular.core.models.TransportListComponent;
import com.adobe.aem.guides.wknd.spa.angular.core.services.TransportService;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.io.IOException;
import java.net.URISyntaxException;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { TransportListComponent.class, ComponentExporter.class }, resourceType = TransportListComponentImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class TransportListComponentImpl implements TransportListComponent {

    @OSGiService
    TransportService transportService;
    static final String RESOURCE_TYPE = "wknd-spa-angular/components/transport-list";

    @ValueMapValue
    private String transport;

    @Override
    public Transport[] getTransportList() throws IOException, URISyntaxException {
        return transportService.getTransportList(transport);
    }

    @Override
    public String getExportedType() {
        return TransportListComponentImpl.RESOURCE_TYPE;
    }
}
