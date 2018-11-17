package de.cl.spring.crud.service;

import java.util.List;

public interface ResourceService {

    Resource getResource(final long id);

    List<Resource> getResources();

    Resource storeResource(Resource resource);

    Resource deleteResource(final long id);
}
