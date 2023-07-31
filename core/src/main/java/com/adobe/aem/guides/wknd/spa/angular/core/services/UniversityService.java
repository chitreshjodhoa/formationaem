package com.adobe.aem.guides.wknd.spa.angular.core.services;

import com.adobe.aem.guides.wknd.spa.angular.core.models.University;
import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@ProviderType
public interface UniversityService {
    public University[] getUniversities(String country) throws URISyntaxException, IOException;

}
