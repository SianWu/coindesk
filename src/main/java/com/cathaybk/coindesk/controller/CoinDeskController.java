package com.cathaybk.coindesk.controller;

import com.cathaybk.coindesk.entity.CoinDesk;
import com.cathaybk.coindesk.entity.CoinDeskModel;
import com.cathaybk.coindesk.service.CoinDeskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/coindesk")
@RestController
public class CoinDeskController {

  @Autowired CoinDeskService coinDeskService;

  @GetMapping
  public CoinDesk getOriginData() {
    return coinDeskService.getData();
  }

  @GetMapping("find/{currency}")
  public CoinDeskModel find(@PathVariable("currency") String currency) {
    return coinDeskService.find(currency);
  }

  @GetMapping("findall")
  public List<CoinDeskModel> findAll() {
    return coinDeskService.findAll();
  }

  @PostMapping("add")
  public CoinDeskModel save(@RequestBody CoinDeskModel coinDeskModel) {
    return coinDeskService.save(coinDeskModel);
  }

  @PutMapping("update/{currency}")
  public CoinDeskModel update(
      @PathVariable("currency") String currency, @RequestBody CoinDeskModel coinDeskModel) {
    return coinDeskService.update(currency, coinDeskModel);
  }

  @DeleteMapping("remove/{currency}")
  public Boolean remove(@PathVariable("currency") String currency) {
    return coinDeskService.remove(currency);
  }
}
