package rp.gamma.core.quant.criteria;

import rp.gamma.core.model.Coin;
import rp.gamma.core.model.TpItemList;
import rp.lambda.functional.Criteria;

/**
 * Criteria template class to generate {@link Criteria} instances to be used for evaluating
 * {@link TpItemList} instances.
 * 
 * @author NK044575
 *
 */
public class TpListAnalystCriteria {
  /**
   * Criteria evaluates {@link TpItemList} as whiteListed.
   */
  private static final Criteria<TpItemList> IS_WHITE_LISTED =
      tpItemList -> tpItemList.whiteListed();
  /**
   * Criteria evaluates {@link TpItemList} as not whiteListed.
   */
  private static final Criteria<TpItemList> IS_NOT_WHITE_LISTED =
      tpItemList -> !tpItemList.whiteListed();

  /**
   * Gets a {@link Criteria} evaluating {@link TpItemList} to have the item_id equal to the given itemId.
   * @param itemId The given itemId the returned criteria evaluating to.
   * @return a {@link Criteria} evaluating {@link TpItemList} to have the item_id equal to the given itemId.
   */
  public static Criteria<TpItemList> itemIdEquals(final int itemId) {
    return tpItemList -> tpItemList.itemId() == itemId;
  }

  /**
   * Gets a {@link Criteria} evaluating {@link TpItemList} as whiteListed.
   * @return a {@link Criteria} evaluating {@link TpItemList} as whiteListed.
   */
  public static Criteria<TpItemList> isWhiteListed() {
    return IS_WHITE_LISTED;
  }

  /**
   * Gets a {@link Criteria} evaluating {@link TpItemList} as not whiteListed.
   * @return a {@link Criteria} evaluating {@link TpItemList} as not whiteListed.
   */
  public static Criteria<TpItemList> isNotWhiteListed() {
    return IS_NOT_WHITE_LISTED;
  }

  /**
   * Gets a {@link Criteria} evaluating {@link TpItemList} to have the buyQty greater than the given buyQty.
   * @param buyQty The given buyQty the returned criteria evaluating to.
   * @return a {@link Criteria} evaluating {@link TpItemList} to have the buyQty greater than the given buyQty.
   */
  public static Criteria<TpItemList> buyQtyGreaterThan(final int buyQty) {
    return tpItemList -> tpItemList.buyQty() > buyQty;
  }

  /**
   * Gets a {@link Criteria} evaluating {@link TpItemList} to have the buyQty less than the given buyQty.
   * @param buyQty The given buyQty the returned criteria evaluating to.
   * @return a {@link Criteria} evaluating {@link TpItemList} to have the buyQty less than the given buyQty.
   */
  public static Criteria<TpItemList> buyQtyLessThan(final int buyQty) {
    return tpItemList -> tpItemList.buyQty() < buyQty;
  }

  /**
   * Gets a {@link Criteria} evaluating {@link TpItemList} to have the buyQty equal to the given buyQty.
   * @param buyQty The given buyQty the returned criteria evaluating to.
   * @return a {@link Criteria} evaluating {@link TpItemList} to have the buyQty equal to the given buyQty.
   */
  public static Criteria<TpItemList> buyQtyEquals(final int buyQty) {
    return tpItemList -> tpItemList.buyQty() == buyQty;
  }

  /**
   * Gets a {@link Criteria} evaluating {@link TpItemList} to have the buy greater than the given buy.
   * @param buy The given buy in {@link Coin} the returned criteria evaluating to.
   * @return a {@link Criteria} evaluating {@link TpItemList} to have the buy greater than the given buy.
   */
  public static Criteria<TpItemList> buyGreaterThan(final Coin buy) {
    return tpItemList -> tpItemList.buy().compareTo(buy) > 0;
  }

  /**
   * Gets a {@link Criteria} evaluating {@link TpItemList} to have the buy less than the given buy.
   * @param buy The given buy in {@link Coin} the returned criteria evaluating to.
   * @return a {@link Criteria} evaluating {@link TpItemList} to have the buy less than the given buy.
   */
  public static Criteria<TpItemList> buyLessThan(final Coin buy) {
    return tpItemList -> tpItemList.buy().compareTo(buy) < 0;
  }

  /**
   * Gets a {@link Criteria} evaluating {@link TpItemList} to have the buy equal to the given buy.
   * @param buy The given buy in {@link Coin} the returned criteria evaluating to.
   * @return a {@link Criteria} evaluating {@link TpItemList} to have the buy equal to the given buy.
   */
  public static Criteria<TpItemList> buyEquals(final Coin buy) {
    return tpItemList -> tpItemList.buy().compareTo(buy) == 0;
  }

  /**
   * Gets a {@link Criteria} evaluating {@link TpItemList} to have the sellQty greater than the given sellQty.
   * @param sellQty The given sellQty the returned criteria evaluating to.
   * @return a {@link Criteria} evaluating {@link TpItemList} to have the sellQty greater than the given sellQty.
   */
  public static Criteria<TpItemList> sellQtyGreaterThan(final int sellQty) {
    return tpItemList -> tpItemList.sellQty() > sellQty;
  }

  /**
   * Gets a {@link Criteria} evaluating {@link TpItemList} to have the sellQty less than the given sellQty.
   * @param sellQty The given sellQty the returned criteria evaluating to.
   * @return a {@link Criteria} evaluating {@link TpItemList} to have the sellQty less than the given sellQty.
   */
  public static Criteria<TpItemList> sellQtyLessThan(final int sellQty) {
    return tpItemList -> tpItemList.sellQty() < sellQty;
  }

  /**
   * Gets a {@link Criteria} evaluating {@link TpItemList} to have the sellQty equal to the given sellQty.
   * @param sellQty The given sellQty the returned criteria evaluating to.
   * @return a {@link Criteria} evaluating {@link TpItemList} to have the sellQty equal to the given sellQty.
   */
  public static Criteria<TpItemList> sellQtyEquals(final int sellQty) {
    return tpItemList -> tpItemList.sellQty() == sellQty;
  }

  /**
   * Gets a {@link Criteria} evaluating {@link TpItemList} to have the sell greater than the given sell.
   * @param sell The given sell in {@link Coin} the returned criteria evaluating to.
   * @return a {@link Criteria} evaluating {@link TpItemList} to have the sell greater than the given sell.
   */
  public static Criteria<TpItemList> sellGreaterThan(final Coin sell) {
    return tpItemList -> tpItemList.sell().compareTo(sell) > 0;
  }

  /**
   * Gets a {@link Criteria} evaluating {@link TpItemList} to have the sell less than the given sell.
   * @param sell The given sell in {@link Coin} the returned criteria evaluating to.
   * @return a {@link Criteria} evaluating {@link TpItemList} to have the sell less than the given sell.
   */
  public static Criteria<TpItemList> sellLessThan(final Coin sell) {
    return tpItemList -> tpItemList.sell().compareTo(sell) < 0;
  }

  /**
   * Gets a {@link Criteria} evaluating {@link TpItemList} to have the sell equal to the given sell.
   * @param sell The given sell in {@link Coin} the returned criteria evaluating to.
   * @return a {@link Criteria} evaluating {@link TpItemList} to have the sell equal to the given sell.
   */
  public static Criteria<TpItemList> sellEquals(final Coin sell) {
    return tpItemList -> tpItemList.sell().compareTo(sell) == 0;
  }

}
