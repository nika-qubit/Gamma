package rp.gamma.core.quant;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Preconditions;

import rp.gamma.core.model.TpItemList;
/**
 * Quantitative analysis functionalities for TP listings.
 * 
 * @author NK044575
 *
 */
public class TpListAnalyst {
  /**
   * Filters the profitable TP item lists for the given TP item lists and profit fraction expectation.
   * e.g., for a 15% profit, give profitExpectation 0.15.
   * @param tpItemLists A {@link List} of {@link TpItemList}s. cannot be null nor empty.
   * @param profitExpectation A double value as fraction of profit based on highest buy value of an item list. cannot be <= 0.0.
   * @return the profitable TP item lists for the given TP item lists and profit fraction expectation.
   */
  public List<TpItemList> filterProfitableTpItemList(List<TpItemList> tpItemLists, double profitExpectation) {
    Preconditions.checkNotNull(tpItemLists, "tpItemLists cannot be null");
    Preconditions.checkArgument(tpItemLists.size() > 0, "tpItemLists cannot be empty");
    Preconditions.checkArgument(profitExpectation > 0.0, "profitExpectation should be a double value > 0.0");
    
    return tpItemLists.stream()
        .filter(tpItemList -> tpItemList.buy().getVal() != 0
            && tpItemList.sell().getVal() > (1.0 + profitExpectation) * tpItemList.buy().getVal())
        .collect(Collectors.toList());
  }
}
