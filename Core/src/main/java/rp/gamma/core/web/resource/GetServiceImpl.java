package rp.gamma.core.web.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import rp.gamma.core.model.ItemDetails;
import rp.gamma.core.model.TpItemList;
import rp.gamma.core.model.jackson.AggregatedTpItemList;
import rp.gamma.core.model.jackson.GeneralItemDetails;

public class GetServiceImpl implements GetService{
  private static final RestTemplate restTemplate = new RestTemplate();
  
  @Override
  public int[] getAllTpItemIds() {
    Integer[] ids = restTemplate.getForObject(Gw2Api.TP_LIST.getEndPoint(), Integer[].class);
    int[] itemIds = Arrays.stream(ids).mapToInt(Integer::intValue).toArray();
    return itemIds;
  }

  @Override
  public List<TpItemList> getTpLists(int[] itemIds) {
    final List<TpItemList> tpItemLists = new ArrayList<>();
    final String appendix = "?ids=";
    int i = 0;
    while(i < itemIds.length){
      StringBuilder idsBuilder = new StringBuilder();
      idsBuilder.append(appendix);
      for(int ii = 0; i+ii < itemIds.length && ii < 20; ++ii){
        idsBuilder.append(itemIds[i+ii]).append(",");
      }
      tpItemLists.addAll(Arrays.asList(restTemplate.getForObject(Gw2Api.TP_PRICE.getEndPoint()+idsBuilder.toString(), AggregatedTpItemList[].class)));
      i += 20;
    }
    return tpItemLists;
  }

  @Override
  public List<ItemDetails> getItemDetails(int[] itemIds) {
    final List<ItemDetails> itemsDetails = new ArrayList<>();
    final String appendix = "?ids=";
    int i = 0;
    while(i < itemIds.length){
      StringBuilder idsBuilder = new StringBuilder();
      idsBuilder.append(appendix);
      for(int ii = 0; i+ii < itemIds.length && ii < 20; ++ii){
        idsBuilder.append(itemIds[i+ii]).append(",");
      }
      itemsDetails.addAll(Arrays.asList(restTemplate.getForObject(Gw2Api.ITEM_DETAILS.getEndPoint()+idsBuilder.toString(), GeneralItemDetails[].class)));
      i += 20;
    }
    return itemsDetails;
  }
}
