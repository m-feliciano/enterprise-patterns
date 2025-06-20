package br.com.code.enterprise.repository.mapper;

import br.com.code.enterprise.repository.DataMapper;
import br.com.code.enterprise.repository.Entity;

import java.util.List;

@SuppressWarnings("all")
public class EntityMapper implements DataMapper<Entity, Object> { // This class implements DataMapper for Entity and Object types

    @Override
    public Object toDto(Entity entity) {
        return (Object) entity;
    }

    @Override
    public Entity toEntity(Object o) {
        return new Entity() {
            @Override
            public Object getId() {
                return null;
            }

            @Override
            public void setId(Object o) {
                // No implementation needed for this stub
            }
        };
    }

    @Override
    public List<Object> toDtoList(List<Entity> entities) {
        return entities.stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public List<Entity> toEntityList(List<Object> objects) {
        return objects.stream()
                .map(this::toEntity)
                .toList();
    }
}
