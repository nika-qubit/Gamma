package rp.gamma.core.quant;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.base.Preconditions;

import rp.gamma.core.model.TpItemList;
import rp.lambda.functional.Criteria;
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
  public final List<TpItemList> filterProfitableTpItemList(final List<TpItemList> tpItemLists, final double profitExpectation) {
    Preconditions.checkNotNull(tpItemLists, "tpItemLists cannot be null");
    Preconditions.checkArgument(tpItemLists.size() > 0, "tpItemLists cannot be empty");
    Preconditions.checkArgument(profitExpectation > 0.0, "profitExpectation should be a double value > 0.0");
    
    return tpItemLists.stream()
        .filter(tpItemList -> tpItemList.buy().getVal() != 0
            && tpItemList.sell().getVal() > (1.0 + profitExpectation) * tpItemList.buy().getVal())
        .collect(Collectors.toList());
  }
  
  /**
   * Filters TP item lists based on the given {@link Criteria}.
   * @param tpItemLists A {@link List} of {@link TpItemList}s. cannot be null nor empty.
   * @param tpItemListFilterCriteria A {@link Criteria} evaluating the TP item lists. cannot be null.
   * @return the filtered TP item lists matching the evaluation of the given {@link Criteria}.
   */
  public final List<TpItemList> filterTpItemList(final List<TpItemList> tpItemLists, final Criteria<TpItemList> tpItemListFilterCriteria){
    Preconditions.checkNotNull(tpItemLists, "tpItemLists cannot be null");
    Preconditions.checkArgument(tpItemLists.size() > 0, "tpItemLists cannot be empty");
    Preconditions.checkNotNull(tpItemListFilterCriteria, "tpItemListFilterCriteria cannot be null");
    
    return tpItemLists.stream().filter(tpItemList -> tpItemListFilterCriteria.evaluate(tpItemList)).collect(Collectors.toList());
  }
  
  /**
   * Filters TP item lists based on the given {@link Criteria}s.
   * @param tpItemLists A {@link List} of {@link TpItemList}s. cannot be null nor empty.
   * @param tpItemListFilterCriterias A {@link Collection} of {@link Criteria} evaluating the TP item lists. The order of criteria or entries is not guaranteed. cannot be null or empty.
   * @return the filtered TP item lists matching all the evaluations of the given {@link Criteria}s.
   */
  public final List<TpItemList> filterTpItemList(final List<TpItemList> tpItemLists, final Collection<Criteria<TpItemList>> tpItemListFilterCriterias){
    Preconditions.checkNotNull(tpItemLists, "tpItemLists cannot be null");
    Preconditions.checkArgument(tpItemLists.size() > 0, "tpItemLists cannot be empty");
    Preconditions.checkNotNull(tpItemListFilterCriterias, "tpItemListFilterCriterias cannot be null");
    Preconditions.checkArgument(tpItemListFilterCriterias.size() > 0, "tpItemListFilterCriterias cannot be empty");
    
    Stream<TpItemList> stream = tpItemLists.stream();
    for(Criteria<TpItemList> tpItemListFilterCriteria : tpItemListFilterCriterias){
      stream = stream.filter(tpItemList -> tpItemListFilterCriteria.evaluate(tpItemList));
    }
    return stream.collect(Collectors.toList());
  }
}
