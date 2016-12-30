package rp.gamma.core.model.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import rp.gamma.core.model.Coin;
import rp.gamma.core.model.TpItemList;

/**
 * Aggregated (only concerning lowest sell and highest buy lists) TP item list jackson model class.
 * 
 * Note: never instantiate a jackson model directly. It's used only for the sake of deserialization of json response.
 * @author NK044575
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AggregatedTpItemList implements TpItemList {
  // ------ Internal Jackson ------//
  private int id;
  private boolean whitelisted;
  private TpList buys;
  private TpList sells;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean getWhitelisted() {
    return whitelisted;
  }

  public void setWhitelisted(boolean whitelisted) {
    this.whitelisted = whitelisted;
  }

  public TpList getBuys() {
    return buys;
  }

  public void setBuys(TpList buys) {
    this.buys = buys;
    buy = Coin.of(buys.getUnit_price());
  }

  public TpList getSells() {
    return sells;
  }

  public void setSells(TpList sells) {
    this.sells = sells;
    sell = Coin.of(sells.getUnit_price());
  }

  public AggregatedTpItemList() {}

  // ------ External Interfaces ------//
  private Coin buy;
  private Coin sell;

  @Override
  public int itemId() {
    return id;
  }

  @Override
  public boolean whiteListed() {
    return whitelisted;
  }

  @Override
  public int buyQty() {
    return buys.getQuantity();
  }

  @Override
  public Coin buy() {
    return buy;
  }

  @Override
  public int sellQty() {
    return sells.getQuantity();
  }

  @Override
  public Coin sell() {
    return sell;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Item id: ").append(itemId()).append(System.lineSeparator()).append("buy: ")
        .append(buy()).append(", buy qty: ").append(buyQty()).append(System.lineSeparator())
        .append("sell: ").append(sell()).append(",sell qty: ").append(sellQty());
    return sb.toString();
  }
}
