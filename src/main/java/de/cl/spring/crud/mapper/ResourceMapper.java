package de.cl.spring.crud.mapper;

import de.cl.spring.crud.presentation.ResourceDto;
import de.cl.spring.crud.persistence.ResourceEntity;
import de.cl.spring.crud.service.Resource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResourceMapper {

    Resource resourceEntityToResource(ResourceEntity resourceEntity);

    ResourceEntity resourceToResourceEntity(Resource resource);

    ResourceDto resourceToResourceDto(Resource resource);

    Resource resourceDtoToResource(ResourceDto resourceDto);

    List<Resource> resourceEntityListToResource(List<ResourceEntity> resourceEntities);

    List<ResourceDto> resourceListToResourceDtoList(List<Resource> resources);

}
