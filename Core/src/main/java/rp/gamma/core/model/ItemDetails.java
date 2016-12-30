package rp.gamma.core.model;

/**
 * Item details interface for general items.
 * 
 * @author NK044575
 *
 */
public interface ItemDetails {
  /**
   * Gets the item_id of current item.
   * @return the item_id of current item.
   */
  public int itemId();
  
  /**
   * Gets the chat_link of current item.
   * @return the chat_link of current item.
   */
  public String chatLink();
  
  /**
   * Gets the name of current item.
   * @return the name of current item.
   */
  public String name();
  
  /**
   * Gets the vendor sell value in {@link Coin} of current item.
   * @return the vendor sell value in {@link Coin} of current item.
   */
  public Coin vendorValue();
}
