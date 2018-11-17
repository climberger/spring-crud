package de.cl.spring.crud.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends CrudRepository<ResourceEntity, Long> {
    List<ResourceEntity> findAll();
}
