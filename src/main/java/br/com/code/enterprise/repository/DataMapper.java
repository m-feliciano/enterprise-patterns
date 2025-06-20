package br.com.code.enterprise.repository;

import java.util.List;

public interface DataMapper<T, DTO> {

    DTO toDto(T entity);

    T toEntity(DTO dto);

    List<DTO> toDtoList(List<T> entities);

    List<T> toEntityList(List<DTO> dtos);
}
