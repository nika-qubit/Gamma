package rp.gamma.core.web.resource;

public enum Gw2Api {
  /**
   * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/listings">/v2/commerce/listings</a>
   * Parameters: 
   * ids (optional list of numbers) – A comma-separated list of item ids to query the listings for.
   * If it is accessed without specifying an id, a list of all ids is returned.
   * If id is provided, it will return all the buy/sell lists of the item with that id.
   */
  TP_LIST("/v2/commerce/listings"),
  
  /**
   * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">/v2/commerce/prices</a>
   * Parameters: 
   * ids (optional list of numbers) – A comma-separated list of item ids to query the listings for.
   * If it is accessed without specifying an id, a list of all ids is returned.
   * If id is provided, it will only return the highest buy and lowest sell of the item with that id.
   */
  TP_PRICE("/v2/commerce/prices"),
  
  /**
   * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">/v2/items</a>
   * Parameters:
   * lang – (Optional) Request localized information.
   * ids - (Optional; Comma Delimited List) Request an array of items for the specified ids. Cannot be used when using the id endpoint.
   */
  ITEM_DETAILS("/v2/items")
  ;
  private static final String BASE_URL = "https://api.guildwars2.com";
  
  private final String endPoint;
  
  Gw2Api(final String endPoint){
    this.endPoint = BASE_URL + endPoint;
  }
  
  public final String getEndPoint(){
    return endPoint;
  }
}
