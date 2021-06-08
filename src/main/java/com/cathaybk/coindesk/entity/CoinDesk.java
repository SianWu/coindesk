package com.cathaybk.coindesk.entity;

import com.fasterxml.jackson.databind.JsonNode;

public class CoinDesk {
  private Time time;
  private String disclaimer;
  private String chartName;
  private JsonNode bpi;

  public Time getTime() {
    return time;
  }

  public void setTime(Time time) {
    this.time = time;
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

  public JsonNode getBpi() {
    return bpi;
  }

  public void setBpi(JsonNode bpi) {
    this.bpi = bpi;
  }
}
