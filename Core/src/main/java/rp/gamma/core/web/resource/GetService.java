package rp.gamma.core.web.resource;

import java.util.List;

import rp.gamma.core.model.ItemDetails;
import rp.gamma.core.model.TpItemList;

public interface GetService {
  /**
   * Gets all item ids of the items listed in trading post.
   * @return int[] of item ids.
   */
  public int[] getAllTpItemIds();
  
  /**
   * Gets a {@link List} of {@link TpItemList} for the given item ids.
   * @param itemIds The item ids to be queried for their trading post item list.
   * @return a {@link List} of {@link TpItemList}(including itemId, whitelisted flag, aggregated buy/sell price/quantity) for the given item ids.
   */
  public List<TpItemList> getTpLists(int[] itemIds);
  
  /**
   * Gets a {@link List} of {@link ItemDetails} for the given item ids.
   * @param itemIds The item ids to be queried for their item details.
   * @return a {@link List} of {@link ItemDetails}(including itemId, chatLink, itemName and vendor value) for the given item ids.
   */
  public List<ItemDetails> getItemDetails(int[] itemIds);
}
