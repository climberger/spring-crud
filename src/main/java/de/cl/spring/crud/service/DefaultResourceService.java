package de.cl.spring.crud.service;

import de.cl.spring.crud.mapper.ResourceMapper;
import de.cl.spring.crud.persistence.ResourceEntity;
import de.cl.spring.crud.persistence.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultResourceService implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Resource getResource(long id) {

        final Optional<ResourceEntity> resourceEntity = resourceRepository.findById(id);

        return resourceEntity
            .map(resourceMapper::resourceEntityToResource)
            .orElseThrow(
                () -> new EntityNotFoundException("Resource cannot be found."));
    }

    @Override
    public List<Resource> getResources() {
        List<ResourceEntity> resourceEntities = resourceRepository.findAll();

        return resourceMapper.resourceEntityListToResource(resourceEntities);
    }

    @Override
    public Resource storeResource(Resource resource) {
        final ResourceEntity resourceEntity = resourceMapper.resourceToResourceEntity(resource);
        final Resource savedResource = resourceMapper.resourceEntityToResource(resourceRepository.save(resourceEntity));
        return savedResource;
    }

    @Override
    public Resource deleteResource(long id) {

        final Optional<ResourceEntity> optionalResourceEntity = resourceRepository.findById(id);
        final ResourceEntity resourceEntity = optionalResourceEntity
            .orElseThrow(
                () -> new EntityNotFoundException("Resource cannot be found."));
        resourceRepository.delete(resourceEntity);
        return resourceMapper.resourceEntityToResource(resourceEntity);
    }
}
