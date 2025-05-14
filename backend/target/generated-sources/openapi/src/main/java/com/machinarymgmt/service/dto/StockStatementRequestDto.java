package com.machinarymgmt.service.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * StockStatementRequestDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-13T15:41:51.742519800+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class StockStatementRequestDto {

  private @Nullable Long itemId;

  private @Nullable Long projectId;

  private @Nullable Long equipmentId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate lastIssueOn;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate lastReceiptOn;

  private @Nullable Integer month;

  private @Nullable Integer year;

  private @Nullable Double balance;

  private @Nullable Double landedValue;

  private @Nullable Double landedRate;

  public StockStatementRequestDto itemId(Long itemId) {
    this.itemId = itemId;
    return this;
  }

  /**
   * Get itemId
   * @return itemId
   */
  
  @Schema(name = "itemId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("itemId")
  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public StockStatementRequestDto projectId(Long projectId) {
    this.projectId = projectId;
    return this;
  }

  /**
   * Get projectId
   * @return projectId
   */
  
  @Schema(name = "projectId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("projectId")
  public Long getProjectId() {
    return projectId;
  }

  public void setProjectId(Long projectId) {
    this.projectId = projectId;
  }

  public StockStatementRequestDto equipmentId(Long equipmentId) {
    this.equipmentId = equipmentId;
    return this;
  }

  /**
   * Get equipmentId
   * @return equipmentId
   */
  
  @Schema(name = "equipmentId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("equipmentId")
  public Long getEquipmentId() {
    return equipmentId;
  }

  public void setEquipmentId(Long equipmentId) {
    this.equipmentId = equipmentId;
  }

  public StockStatementRequestDto lastIssueOn(LocalDate lastIssueOn) {
    this.lastIssueOn = lastIssueOn;
    return this;
  }

  /**
   * Get lastIssueOn
   * @return lastIssueOn
   */
  @Valid 
  @Schema(name = "lastIssueOn", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastIssueOn")
  public LocalDate getLastIssueOn() {
    return lastIssueOn;
  }

  public void setLastIssueOn(LocalDate lastIssueOn) {
    this.lastIssueOn = lastIssueOn;
  }

  public StockStatementRequestDto lastReceiptOn(LocalDate lastReceiptOn) {
    this.lastReceiptOn = lastReceiptOn;
    return this;
  }

  /**
   * Get lastReceiptOn
   * @return lastReceiptOn
   */
  @Valid 
  @Schema(name = "lastReceiptOn", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastReceiptOn")
  public LocalDate getLastReceiptOn() {
    return lastReceiptOn;
  }

  public void setLastReceiptOn(LocalDate lastReceiptOn) {
    this.lastReceiptOn = lastReceiptOn;
  }

  public StockStatementRequestDto month(Integer month) {
    this.month = month;
    return this;
  }

  /**
   * Get month
   * @return month
   */
  
  @Schema(name = "month", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("month")
  public Integer getMonth() {
    return month;
  }

  public void setMonth(Integer month) {
    this.month = month;
  }

  public StockStatementRequestDto year(Integer year) {
    this.year = year;
    return this;
  }

  /**
   * Get year
   * @return year
   */
  
  @Schema(name = "year", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("year")
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public StockStatementRequestDto balance(Double balance) {
    this.balance = balance;
    return this;
  }

  /**
   * Get balance
   * @return balance
   */
  
  @Schema(name = "balance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("balance")
  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public StockStatementRequestDto landedValue(Double landedValue) {
    this.landedValue = landedValue;
    return this;
  }

  /**
   * Get landedValue
   * @return landedValue
   */
  
  @Schema(name = "landedValue", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("landedValue")
  public Double getLandedValue() {
    return landedValue;
  }

  public void setLandedValue(Double landedValue) {
    this.landedValue = landedValue;
  }

  public StockStatementRequestDto landedRate(Double landedRate) {
    this.landedRate = landedRate;
    return this;
  }

  /**
   * Get landedRate
   * @return landedRate
   */
  
  @Schema(name = "landedRate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("landedRate")
  public Double getLandedRate() {
    return landedRate;
  }

  public void setLandedRate(Double landedRate) {
    this.landedRate = landedRate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StockStatementRequestDto stockStatementRequestDto = (StockStatementRequestDto) o;
    return Objects.equals(this.itemId, stockStatementRequestDto.itemId) &&
        Objects.equals(this.projectId, stockStatementRequestDto.projectId) &&
        Objects.equals(this.equipmentId, stockStatementRequestDto.equipmentId) &&
        Objects.equals(this.lastIssueOn, stockStatementRequestDto.lastIssueOn) &&
        Objects.equals(this.lastReceiptOn, stockStatementRequestDto.lastReceiptOn) &&
        Objects.equals(this.month, stockStatementRequestDto.month) &&
        Objects.equals(this.year, stockStatementRequestDto.year) &&
        Objects.equals(this.balance, stockStatementRequestDto.balance) &&
        Objects.equals(this.landedValue, stockStatementRequestDto.landedValue) &&
        Objects.equals(this.landedRate, stockStatementRequestDto.landedRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemId, projectId, equipmentId, lastIssueOn, lastReceiptOn, month, year, balance, landedValue, landedRate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StockStatementRequestDto {\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    equipmentId: ").append(toIndentedString(equipmentId)).append("\n");
    sb.append("    lastIssueOn: ").append(toIndentedString(lastIssueOn)).append("\n");
    sb.append("    lastReceiptOn: ").append(toIndentedString(lastReceiptOn)).append("\n");
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    landedValue: ").append(toIndentedString(landedValue)).append("\n");
    sb.append("    landedRate: ").append(toIndentedString(landedRate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

