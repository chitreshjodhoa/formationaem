package com.adobe.aem.guides.wknd.spa.angular.core.models.impl;

import com.adobe.aem.guides.wknd.spa.angular.core.models.University;
import com.adobe.aem.guides.wknd.spa.angular.core.services.UniversityService;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.aem.guides.wknd.spa.angular.core.models.UniversityListComponent;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

import java.io.IOException;
import java.net.URISyntaxException;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { UniversityListComponent.class, ComponentExporter.class}, resourceType = UniversityListComponentImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class UniversityListComponentImpl implements UniversityListComponent {

    @OSGiService
    UniversityService universityService;

    static final String RESOURCE_TYPE = "wknd-spa-angular/components/university-list";

    @ValueMapValue
    private String country;

    @Override
    public String getExportedType() {
        return UniversityListComponentImpl.RESOURCE_TYPE;
    }

    @Override
    public University[] getCountry() throws URISyntaxException, IOException {
        return StringUtils.isNotBlank(country) ? universityService.getUniversities(country) : null;
    }
    
}