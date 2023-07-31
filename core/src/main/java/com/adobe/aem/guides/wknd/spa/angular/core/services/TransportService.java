package com.adobe.aem.guides.wknd.spa.angular.core.services;

import com.adobe.aem.guides.wknd.spa.angular.core.models.Transport;
import org.osgi.annotation.versioning.ProviderType;

import java.io.IOException;
import java.net.URISyntaxException;

@ProviderType
public interface TransportService {
    public Transport[] getTransportList(String transport) throws IOException, URISyntaxException;
}
