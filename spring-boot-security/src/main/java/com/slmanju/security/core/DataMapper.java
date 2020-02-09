package com.slmanju.security.core;

import org.springframework.beans.BeanUtils;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 */
public interface DataMapper<E, V, D> {

  E entity();

  V view();

  default V toView(E entity) {
    V view = view();

    BeanUtils.copyProperties(entity, view);

    return view;
  }

  default E toEntity(D dto) {
    E entity = entity();

    BeanUtils.copyProperties(dto, entity);

    return entity;
  }

  default List<V> toViews(List<E> entities) {
    return entities.stream().map(this::toView).collect(toList());
  }

  default E toUpdateEntity(D dto, E entity) {
    BeanUtils.copyProperties(dto, entity);
    return entity;
  }

}
