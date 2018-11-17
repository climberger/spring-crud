package de.cl.spring.crud.presentation;

import de.cl.spring.crud.mapper.ResourceMapper;
import de.cl.spring.crud.service.Resource;
import de.cl.spring.crud.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ResourceMapper resourceMapper;

    @GetMapping(path = "/resources/{id}")
    public ResponseEntity<ResourceDto> getResource(@PathVariable long id) {
        final ResourceDto resource = resourceMapper.resourceToResourceDto(resourceService.getResource(id));

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @GetMapping(path = "/resources")
    public ResponseEntity<List<ResourceDto>> getResources() {
        final List<ResourceDto> resource = resourceMapper.resourceListToResourceDtoList(resourceService.getResources());

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @PostMapping(path = "/resources")
    public ResponseEntity<ResourceDto> addResource(@RequestBody ResourceDto resourceDto) {
        Resource resource = resourceMapper.resourceDtoToResource(resourceDto);
        Resource resultResource = resourceService.storeResource(resource);
        ResourceDto resultResourceDto = resourceMapper.resourceToResourceDto(resultResource);
        return new ResponseEntity<>(resultResourceDto, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/resources/{id}")
    public ResponseEntity<ResourceDto> deleteResource(@PathVariable long id) {
        Resource resultResource = resourceService.deleteResource(id);
        ResourceDto resultResourceDto = resourceMapper.resourceToResourceDto(resultResource);
        return new ResponseEntity<>(resultResourceDto, HttpStatus.CREATED);
    }
}
