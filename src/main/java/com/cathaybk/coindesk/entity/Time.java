package com.cathaybk.coindesk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.time.LocalDateTime;

public class Time {
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "yyyy-MM-dd'T'HH:mm:sszzz",
      timezone = "UTC")
  private LocalDateTime updatedISO;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM d, yyyy HH:mm:ss z", timezone = "UTC")
  private LocalDateTime updated;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "MMM d, yyyy 'at' HH:mm z",
      timezone = "UTC")
  private LocalDateTime updateduk;

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
}
