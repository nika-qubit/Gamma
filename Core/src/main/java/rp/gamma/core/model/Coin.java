package rp.gamma.core.model;

import java.util.Objects;

/**
 * Coin class.
 * Coin has 3 kinds of units: gold, silver and copper.
 * 1 gold = 100 silver;
 * 1 silver = 100 copper.
 * The real value in copper for an {@link Coin} instance = 10000*gold+100*silver+copper.
 * @author NK044575
 */
public class Coin {
  private final int value;
  private final int gold;
  private final int silver;
  private final int copper;
  
  public static Coin of(final int value){
    return new Coin(value);
  }
  
  /**
   * Gets the value of the {@link Coin} instance fully converted to copper.
   * @return the value of the {@link Coin} instance fully converted to copper.
   */
  public int getVal(){
    return value;
  }
  
  /**
   * Gets the gold part of the {@link Coin} instance.
   * @return the gold part of the {@link Coin} instance.
   */
  public int getGold(){
    return gold;
  }
  
  /**
   * Gets the silver part of the {@link Coin} instance.
   * @return the silver part of the {@link Coin} instance.
   */
  public int getSilver(){
    return silver;
  }
  
  /**
   * Gets the copper part of the {@link Coin} instance.
   * @return the copper part of the {@link Coin} instance.
   */
  public int getCopper(){
    return copper;
  }
  
  @Override
  public int hashCode(){
    return Objects.hash(value);
  }
  
  @Override
  public boolean equals(Object o){
    if(this == o) return true;
    if(!(o instanceof Coin)) return false;
    Coin c = (Coin) o;
    return value == c.value;
  }
  
  @Override
  public String toString(){
    final StringBuilder sb = new StringBuilder();
    if(gold > 0) sb.append("Gold: ").append(gold).append(";");
    if(silver > 0) sb.append("Silver: ").append(silver).append(";");
    sb.append("Copper: ").append(copper).append(" ");
    return sb.toString();
  }
  
  private Coin(int value){
    this.value = value;
    this.copper = value%100;
    value /= 100;
    this.silver = value%100;
    value /=100;
    this.gold = value;
  }
}
