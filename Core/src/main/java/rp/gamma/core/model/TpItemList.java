package rp.gamma.core.model;

/**
 * Trading Post item listing interface for items listed in trading post.
 * 
 * @author NK044575
 *
 */
public interface TpItemList {
  /**
   * Gets the item_id of current listed item in trading post.
   * @return the item_id of current listed item in trading post.
   */
  public int itemId();
  
  /**
   * Gets the whitelisted flag of current listed item in trading post.
   * @return the whitelisted flag of current listed item in trading post.
   */
  public boolean whiteListed();
  
  /**
   * Gets the list quantity of the highest buy for current listed item in trading post.
   * @return the order quantity of the highest buy for current listed item in trading post.
   */
  public int buyQty();
  
  /**
   * Gets the highest buy value in {@link Coin} for current listed item in trading post.
   * @return the highest buy value in {@link Coin} for current listed item in trading post.
   */
  public Coin buy();
  
  /**
   * Gets the list quantity of the lowest sell for current listed item in trading post.
   * @return the list quantity of the lowest sell for current listed item in trading post.
   */
  public int sellQty();
  
  /**
   * Gets the lowest sell value in {@link Coin} for current listed item in trading post.
   * @return the lowest sell value in {@link Coin} for current listed item in trading post.
   */
  public Coin sell();
}
