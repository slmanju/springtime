package com.slmanju.security.core;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * This class holds search results.
 *
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
public class SearchResult<V> {

  public static final int DEFAULT_SIZE = 20;

  private List<V> data;

  private long total;

  private long totalPages;

  private int start;

  private int size;

  private boolean hasNext;

  private boolean hasPrevious;

  public static <E, V, D> SearchResult<V> of(Page<E> page, DataMapper<E, V, D> dataMapper) {
    SearchResult<V> searchResult = new SearchResult<>();
    searchResult.setData(dataMapper.toViews(page.getContent()));
    searchResult.setTotal(page.getTotalElements());
    searchResult.setTotalPages(page.getTotalPages());
    searchResult.setSize(page.getSize());
    searchResult.setHasNext(page.hasNext());
    searchResult.setHasPrevious(page.hasPrevious());

    return searchResult;
  }

}
