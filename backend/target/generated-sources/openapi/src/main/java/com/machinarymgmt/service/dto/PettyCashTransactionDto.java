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
 * PettyCashTransactionDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-27T12:57:30.564361800+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class PettyCashTransactionDto {

  private @Nullable Long id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate reportDate;

  private @Nullable String remarks;

  private @Nullable Double amountSpent;

  private @Nullable Double quantity;

  private @Nullable Double rate;

  private @Nullable Double cumulativeTotalAmount;

  private @Nullable String purposeJustification;

  private @Nullable ProjectSummaryDto project;

  private @Nullable EquipmentSummaryDto equipment;

  private @Nullable ItemSummaryDto item;

  public PettyCashTransactionDto id(Long id) {
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

  public PettyCashTransactionDto reportDate(LocalDate reportDate) {
    this.reportDate = reportDate;
    return this;
  }

  /**
   * Get reportDate
   * @return reportDate
   */
  @Valid 
  @Schema(name = "reportDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reportDate")
  public LocalDate getReportDate() {
    return reportDate;
  }

  public void setReportDate(LocalDate reportDate) {
    this.reportDate = reportDate;
  }

  public PettyCashTransactionDto remarks(String remarks) {
    this.remarks = remarks;
    return this;
  }

  /**
   * Get remarks
   * @return remarks
   */
  
  @Schema(name = "remarks", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("remarks")
  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public PettyCashTransactionDto amountSpent(Double amountSpent) {
    this.amountSpent = amountSpent;
    return this;
  }

  /**
   * Get amountSpent
   * @return amountSpent
   */
  
  @Schema(name = "amountSpent", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("amountSpent")
  public Double getAmountSpent() {
    return amountSpent;
  }

  public void setAmountSpent(Double amountSpent) {
    this.amountSpent = amountSpent;
  }

  public PettyCashTransactionDto quantity(Double quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
   */
  
  @Schema(name = "quantity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quantity")
  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public PettyCashTransactionDto rate(Double rate) {
    this.rate = rate;
    return this;
  }

  /**
   * Get rate
   * @return rate
   */
  
  @Schema(name = "rate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("rate")
  public Double getRate() {
    return rate;
  }

  public void setRate(Double rate) {
    this.rate = rate;
  }

  public PettyCashTransactionDto cumulativeTotalAmount(Double cumulativeTotalAmount) {
    this.cumulativeTotalAmount = cumulativeTotalAmount;
    return this;
  }

  /**
   * Get cumulativeTotalAmount
   * @return cumulativeTotalAmount
   */
  
  @Schema(name = "cumulativeTotalAmount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cumulativeTotalAmount")
  public Double getCumulativeTotalAmount() {
    return cumulativeTotalAmount;
  }

  public void setCumulativeTotalAmount(Double cumulativeTotalAmount) {
    this.cumulativeTotalAmount = cumulativeTotalAmount;
  }

  public PettyCashTransactionDto purposeJustification(String purposeJustification) {
    this.purposeJustification = purposeJustification;
    return this;
  }

  /**
   * Get purposeJustification
   * @return purposeJustification
   */
  
  @Schema(name = "purposeJustification", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("purposeJustification")
  public String getPurposeJustification() {
    return purposeJustification;
  }

  public void setPurposeJustification(String purposeJustification) {
    this.purposeJustification = purposeJustification;
  }

  public PettyCashTransactionDto project(ProjectSummaryDto project) {
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

  public PettyCashTransactionDto equipment(EquipmentSummaryDto equipment) {
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

  public PettyCashTransactionDto item(ItemSummaryDto item) {
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
    PettyCashTransactionDto pettyCashTransactionDto = (PettyCashTransactionDto) o;
    return Objects.equals(this.id, pettyCashTransactionDto.id) &&
        Objects.equals(this.reportDate, pettyCashTransactionDto.reportDate) &&
        Objects.equals(this.remarks, pettyCashTransactionDto.remarks) &&
        Objects.equals(this.amountSpent, pettyCashTransactionDto.amountSpent) &&
        Objects.equals(this.quantity, pettyCashTransactionDto.quantity) &&
        Objects.equals(this.rate, pettyCashTransactionDto.rate) &&
        Objects.equals(this.cumulativeTotalAmount, pettyCashTransactionDto.cumulativeTotalAmount) &&
        Objects.equals(this.purposeJustification, pettyCashTransactionDto.purposeJustification) &&
        Objects.equals(this.project, pettyCashTransactionDto.project) &&
        Objects.equals(this.equipment, pettyCashTransactionDto.equipment) &&
        Objects.equals(this.item, pettyCashTransactionDto.item);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, reportDate, remarks, amountSpent, quantity, rate, cumulativeTotalAmount, purposeJustification, project, equipment, item);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PettyCashTransactionDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    reportDate: ").append(toIndentedString(reportDate)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
    sb.append("    amountSpent: ").append(toIndentedString(amountSpent)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    cumulativeTotalAmount: ").append(toIndentedString(cumulativeTotalAmount)).append("\n");
    sb.append("    purposeJustification: ").append(toIndentedString(purposeJustification)).append("\n");
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

