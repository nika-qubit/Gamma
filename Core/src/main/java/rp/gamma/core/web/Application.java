package rp.gamma.core.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rp.gamma.core.model.ItemDetails;
import rp.gamma.core.model.TpItemList;
import rp.gamma.core.quant.TpListAnalyst;
import rp.gamma.core.web.resource.GetService;
import rp.gamma.core.web.resource.GetServiceImpl;

public class Application {
  private static final Logger logger = LoggerFactory.getLogger(Application.class);

  public static void main(String args[]) {
    final GetService getService = new GetServiceImpl();
    final List<TpItemList> tpItemLists = new TpListAnalyst().filterProfitableTpItemList(getService.getTpLists(getService.getAllTpItemIds()), 1.2);
    final int[] profitableItemIds = tpItemLists.stream().mapToInt(TpItemList::itemId).toArray();
    final List<ItemDetails> profitableItemsDetails = getService.getItemDetails(profitableItemIds);
    profitableItemsDetails.stream().forEach(itemDetails-> logger.info(itemDetails.toString()));
  }
}
