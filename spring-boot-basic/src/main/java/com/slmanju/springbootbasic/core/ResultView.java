package com.slmanju.springbootbasic.core;

import lombok.Data;

@Data
public class ResultView<T>
{
  private T data;
}
