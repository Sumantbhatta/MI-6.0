package com.machinarymgmt.service.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.machinarymgmt.service.dto.EquipmentSummaryDto;
import com.machinarymgmt.service.dto.ItemSummaryDto;
import com.machinarymgmt.service.dto.ProjectSummaryDto;
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
 * StockStatementDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-26T16:53:22.870701700+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class StockStatementDto {

  private @Nullable Long id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate lastIssueOn;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate lastReceiptOn;

  private @Nullable Integer month;

  private @Nullable Integer year;

  private @Nullable Double balance;

  private @Nullable Double landedValue;

  private @Nullable Double landedRate;

  private @Nullable ProjectSummaryDto project;

  private @Nullable EquipmentSummaryDto equipment;

  private @Nullable ItemSummaryDto item;

  public StockStatementDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public StockStatementDto lastIssueOn(LocalDate lastIssueOn) {
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

  public StockStatementDto lastReceiptOn(LocalDate lastReceiptOn) {
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

  public StockStatementDto month(Integer month) {
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

  public StockStatementDto year(Integer year) {
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

  public StockStatementDto balance(Double balance) {
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

  public StockStatementDto landedValue(Double landedValue) {
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

  public StockStatementDto landedRate(Double landedRate) {
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

  public StockStatementDto project(ProjectSummaryDto project) {
    this.project = project;
    return this;
  }

  /**
   * Get project
   * @return project
   */
  @Valid 
  @Schema(name = "project", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("project")
  public ProjectSummaryDto getProject() {
    return project;
  }

  public void setProject(ProjectSummaryDto project) {
    this.project = project;
  }

  public StockStatementDto equipment(EquipmentSummaryDto equipment) {
    this.equipment = equipment;
    return this;
  }

  /**
   * Get equipment
   * @return equipment
   */
  @Valid 
  @Schema(name = "equipment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("equipment")
  public EquipmentSummaryDto getEquipment() {
    return equipment;
  }

  public void setEquipment(EquipmentSummaryDto equipment) {
    this.equipment = equipment;
  }

  public StockStatementDto item(ItemSummaryDto item) {
    this.item = item;
    return this;
  }

  /**
   * Get item
   * @return item
   */
  @Valid 
  @Schema(name = "item", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("item")
  public ItemSummaryDto getItem() {
    return item;
  }

  public void setItem(ItemSummaryDto item) {
    this.item = item;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StockStatementDto stockStatementDto = (StockStatementDto) o;
    return Objects.equals(this.id, stockStatementDto.id) &&
        Objects.equals(this.lastIssueOn, stockStatementDto.lastIssueOn) &&
        Objects.equals(this.lastReceiptOn, stockStatementDto.lastReceiptOn) &&
        Objects.equals(this.month, stockStatementDto.month) &&
        Objects.equals(this.year, stockStatementDto.year) &&
        Objects.equals(this.balance, stockStatementDto.balance) &&
        Objects.equals(this.landedValue, stockStatementDto.landedValue) &&
        Objects.equals(this.landedRate, stockStatementDto.landedRate) &&
        Objects.equals(this.project, stockStatementDto.project) &&
        Objects.equals(this.equipment, stockStatementDto.equipment) &&
        Objects.equals(this.item, stockStatementDto.item);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, lastIssueOn, lastReceiptOn, month, year, balance, landedValue, landedRate, project, equipment, item);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StockStatementDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lastIssueOn: ").append(toIndentedString(lastIssueOn)).append("\n");
    sb.append("    lastReceiptOn: ").append(toIndentedString(lastReceiptOn)).append("\n");
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    landedValue: ").append(toIndentedString(landedValue)).append("\n");
    sb.append("    landedRate: ").append(toIndentedString(landedRate)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    equipment: ").append(toIndentedString(equipment)).append("\n");
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
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

