package com.cathaybk.coindesk.service;

import com.cathaybk.coindesk.entity.CoinDesk;
import com.cathaybk.coindesk.entity.CoinDeskModel;
import com.cathaybk.coindesk.repositary.CoinDeskRepository;
import com.cathaybk.coindesk.retrofit.CoinDeskApi;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Service
public class CoinDeskService {

  final CoinDeskRepository coinDeskRepository;

  public CoinDeskService(CoinDeskRepository coinDeskRepository) {
    this.coinDeskRepository = coinDeskRepository;
  }

  public CoinDesk getData() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper
        .registerModule(new ParameterNamesModule())
        .registerModule(new Jdk8Module())
        .registerModule(new JavaTimeModule())
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    Retrofit.Builder builder =
        new Retrofit.Builder().addConverterFactory(JacksonConverterFactory.create(objectMapper));
    builder.baseUrl("http://localhost");
    Retrofit retrofit = builder.build();
    Call<CoinDesk> getData =
        retrofit
            .create(CoinDeskApi.class)
            .getdata("https://api.coindesk.com/v1/bpi/currentprice.json");
    try {
      Response<CoinDesk> execute = getData.execute();
      if (execute.isSuccessful()) {
        if (execute.body() != null) {
          CoinDesk coinDesk = execute.body();
          Iterator<JsonNode> iterator = coinDesk.getBpi().iterator();
          List<CoinDeskModel> coinDeskModelList = new ArrayList<>();
          while (iterator.hasNext()) {
            JsonNode element = iterator.next();
            CoinDeskModel coinDeskModel = setSwitch(coinDesk, element);
            coinDeskModelList.add(coinDeskModel);
          }
          coinDeskRepository.saveAll(coinDeskModelList);
          return coinDesk;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new CoinDesk();
  }

  private CoinDeskModel setSwitch(CoinDesk coinDesk, JsonNode element) {
    CoinDeskModel coinDeskModel = new CoinDeskModel();
    coinDeskModel.setChartName(coinDesk.getChartName());
    coinDeskModel.setDisclaimer(coinDesk.getDisclaimer());
    coinDeskModel.setUpdated(coinDesk.getTime().getUpdated());
    coinDeskModel.setUpdatedISO(coinDesk.getTime().getUpdatedISO());
    coinDeskModel.setUpdateduk(coinDesk.getTime().getUpdateduk());
    coinDeskModel.setRemove(false);
    switch (element.get("code").asText()) {
      case "USD":
        {
          setCurrency(coinDeskModel, element);
          coinDeskModel.setCurrencyName("美元");
          break;
        }
      case "GBP":
        {
          setCurrency(coinDeskModel, element);
          coinDeskModel.setCurrencyName("英鎊");
          break;
        }
      case "EUR":
        {
          setCurrency(coinDeskModel, element);
          coinDeskModel.setCurrencyName("歐元");
          break;
        }
      default:
        {
          break;
        }
    }
    return coinDeskModel;
  }

  private void setCurrency(CoinDeskModel coinDeskModel, JsonNode element) {
    coinDeskModel.setCode(element.get("code").asText());
    coinDeskModel.setSymbol(element.get("symbol").asText());
    coinDeskModel.setDescription(element.get("description").asText());
    coinDeskModel.setRate(element.get("rate").asText());
    coinDeskModel.setRate_float(element.get("rate_float").asDouble());
  }

  public CoinDeskModel find(String currency) {
    return coinDeskRepository.findByCode(currency).orElse(new CoinDeskModel());
  }

  public List<CoinDeskModel> findAll() {
    List<CoinDeskModel> result = new ArrayList<>();
    coinDeskRepository.findAll().forEach(result::add);
    return result;
  }

  public CoinDeskModel save(CoinDeskModel coinDeskModel) {
    coinDeskModel.setRemove(false);
    return coinDeskRepository.save(coinDeskModel);
  }

  public CoinDeskModel update(String currency, CoinDeskModel coinDeskModel) {
    Optional<CoinDeskModel> result = coinDeskRepository.findByCode(currency);
    if (result.isPresent()) {
      result.get().setUpdated(coinDeskModel.getUpdated());
      result.get().setCurrencyName(coinDeskModel.getCurrencyName());
      result.get().setRate_float(coinDeskModel.getRate_float());
      result.get().setRate(coinDeskModel.getRate());
      return coinDeskRepository.save(result.get());
    }
    return new CoinDeskModel();
  }

  public Boolean remove(String currency) {
    Optional<CoinDeskModel> result = coinDeskRepository.findByCode(currency);
    if (result.isPresent()) {
      result.get().setRemove(true);
      coinDeskRepository.save(result.get());
      return true;
    }
    return false;
  }

  public Boolean delete(String currency) {
    Optional<CoinDeskModel> result = coinDeskRepository.findByCode(currency);
    result.ifPresent(coinDeskRepository::delete);
    return true;
  }
}
