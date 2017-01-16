package rp.gamma.core.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;

import rp.gamma.core.model.Coin;
import rp.gamma.core.model.ItemDetails;
import rp.gamma.core.model.TpItemList;
import rp.gamma.core.quant.TpListAnalyst;
import rp.gamma.core.quant.criteria.TpListAnalystCriteria;
import rp.gamma.core.web.resource.GetService;
import rp.gamma.core.web.resource.GetServiceImpl;

public class DemoApplication {
  private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
  //GetService service instance, beanable
  private static final GetService getService = new GetServiceImpl();
  // TpListAnalyst instance, beanable
  private static final TpListAnalyst tpListAnalyst = new TpListAnalyst();
  
  public static List<ItemDetails> demo(){
    // find all tpItemLists with expected profit greater than 25%, sell price greater than 1 gold,
    // buy qty greater than 10 and sell qty less than 10.
    final List<TpItemList> tpItemLists = tpListAnalyst.filterTpItemList(
        tpListAnalyst
            .filterProfitableTpItemList(getService.getTpLists(getService.getAllTpItemIds()), 1.25),
        ImmutableList.of(TpListAnalystCriteria.sellGreaterThan(Coin.of(10000)),
            TpListAnalystCriteria.buyQtyGreaterThan(10),
            TpListAnalystCriteria.sellQtyLessThan(10)));
    final int[] profitableItemIds = tpItemLists.stream().mapToInt(TpItemList::itemId).toArray();
    final List<ItemDetails> profitableItemsDetails = getService.getItemDetails(profitableItemIds);
    return profitableItemsDetails;
  }
  
  public static void main(String args[]) {
    DemoApplication.demo().stream().forEach(itemDetails -> logger.info(itemDetails.toString()));
  }
}
