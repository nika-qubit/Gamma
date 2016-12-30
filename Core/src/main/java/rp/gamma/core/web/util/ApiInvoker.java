package rp.gamma.core.web.util;

import rp.gamma.core.web.resource.Gw2Api;

public class ApiInvoker<T, E> {
  private T t;
  private E e;
  private Gw2Api api;
  
  public ApiInvoker(T t, E e, Gw2Api api){
    this.t = t;
    this.e = e;
    this.api = api;
  }
  
  
}
