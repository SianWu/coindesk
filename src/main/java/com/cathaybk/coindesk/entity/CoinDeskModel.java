package com.cathaybk.coindesk.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CoinDeskModel {
  @Id private String currency;
  private String currencyName;
  private String disclaimer;
  private String chartName;
  private LocalDateTime updatedISO;
  private LocalDateTime updated;
  private LocalDateTime updateduk;
  private String code;
  private String symbol;
  private String rate;
  private String description;
  private double rate_float;

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getCurrencyName() {
    return currencyName;
  }

  public void setCurrencyName(String currencyName) {
    this.currencyName = currencyName;
  }

  public String getDisclaimer() {
    return disclaimer;
  }

  public void setDisclaimer(String disclaimer) {
    this.disclaimer = disclaimer;
  }

  public String getChartName() {
    return chartName;
  }

  public void setChartName(String chartName) {
    this.chartName = chartName;
  }

  public LocalDateTime getUpdatedISO() {
    return updatedISO;
  }

  public void setUpdatedISO(LocalDateTime updatedISO) {
    this.updatedISO = updatedISO;
  }

  public LocalDateTime getUpdated() {
    return updated;
  }

  public void setUpdated(LocalDateTime updated) {
    this.updated = updated;
  }

  public LocalDateTime getUpdateduk() {
    return updateduk;
  }

  public void setUpdateduk(LocalDateTime updateduk) {
    this.updateduk = updateduk;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getRate_float() {
    return rate_float;
  }

  public void setRate_float(double rate_float) {
    this.rate_float = rate_float;
  }
}
