package rp.gamma.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import rp.gamma.core.model.ItemDetails;
import rp.gamma.core.web.DemoApplication;


@Controller
public class IndexController {
  private static List<ItemDetails> demoFilteredItemDetails = DemoApplication.demo();
  
  @GetMapping("/demo")
  public String index(Model model) {
    model.addAttribute("items", demoFilteredItemDetails);
    return "demo";
  }
}
