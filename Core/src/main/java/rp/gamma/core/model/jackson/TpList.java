package rp.gamma.core.model.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A deserialization helper model representing a list for any TP item list, such as {@link AggregatedTpItemList}.
 * 
 * @author NK044575
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TpList {
  private int quantity;
  private int unit_price;
  
  /**
   * Gets quantity of current list.
   * @return quantity of current list.
   */
  public int getQuantity(){
    return quantity;
  }
  
  public void setQuantity(int quantity){
    this.quantity = quantity;
  }
  
  /**
   * Gets unit price of current list.
   * @return unit price of current list.
   */
  public int getUnit_price(){
    return unit_price;
  }
  
  public void setUnit_price(int unit_price){
    this.unit_price = unit_price;
  }
  
  public TpList(){}
}
