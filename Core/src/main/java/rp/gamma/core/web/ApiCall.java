package rp.gamma.core.web;

public interface ApiCall<T, E> {
  public T invoke(E e);
}
