package rp.gamma.core.model.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import rp.gamma.core.model.Coin;
import rp.gamma.core.model.ItemDetails;

/**
 * General Item Details jackson model class.
 * 
 * Note: never instantiate a jackson model directly. It's used only for the sake of deserialization of json response.
 * @author NK044575
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneralItemDetails implements ItemDetails {
  // ------ Internal Jackson ------//
  private int id;
  private String chat_link;
  private String name;
  private int vendorValue;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getChat_link() {
    return chat_link;
  }

  public void setChat_link(String chat_link) {
    this.chat_link = chat_link;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getVendorValue() {
    return vendorValue;
  }

  public void setVendorValue(int vendorValue) {
    this.vendorValue = vendorValue;
    vendorValueInCoin = Coin.of(vendorValue);
  }

  public GeneralItemDetails() {}

  // ------ External Interfaces ------//
  private Coin vendorValueInCoin;

  @Override
  public int itemId() {
    return id;
  }

  @Override
  public String chatLink() {
    return chat_link;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public Coin vendorValue() {
    return vendorValueInCoin;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Item id: ").append(itemId()).append(System.lineSeparator()).append("name: ")
        .append(name).append(", chat link: ").append(chatLink()).append(", vendor value: ").append(vendorValue());
    return sb.toString();
  }
}
