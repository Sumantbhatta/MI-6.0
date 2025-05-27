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
 * PettyCashTransactionRequestDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-27T12:57:30.564361800+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class PettyCashTransactionRequestDto {

  private @Nullable Long projectId;

  private @Nullable Long equipmentId;

  private @Nullable Long itemId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate reportDate;

  private @Nullable String remarks;

  private @Nullable Double amountSpent;

  private @Nullable Double quantity;

  private @Nullable Double rate;

  private @Nullable Double cumulativeTotalAmount;

  private @Nullable String purposeJustification;

  public PettyCashTransactionRequestDto projectId(Long projectId) {
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

  public PettyCashTransactionRequestDto equipmentId(Long equipmentId) {
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

  public PettyCashTransactionRequestDto itemId(Long itemId) {
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

  public PettyCashTransactionRequestDto reportDate(LocalDate reportDate) {
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

  public PettyCashTransactionRequestDto remarks(String remarks) {
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

  public PettyCashTransactionRequestDto amountSpent(Double amountSpent) {
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

  public PettyCashTransactionRequestDto quantity(Double quantity) {
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

  public PettyCashTransactionRequestDto rate(Double rate) {
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

  public PettyCashTransactionRequestDto cumulativeTotalAmount(Double cumulativeTotalAmount) {
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

  public PettyCashTransactionRequestDto purposeJustification(String purposeJustification) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PettyCashTransactionRequestDto pettyCashTransactionRequestDto = (PettyCashTransactionRequestDto) o;
    return Objects.equals(this.projectId, pettyCashTransactionRequestDto.projectId) &&
        Objects.equals(this.equipmentId, pettyCashTransactionRequestDto.equipmentId) &&
        Objects.equals(this.itemId, pettyCashTransactionRequestDto.itemId) &&
        Objects.equals(this.reportDate, pettyCashTransactionRequestDto.reportDate) &&
        Objects.equals(this.remarks, pettyCashTransactionRequestDto.remarks) &&
        Objects.equals(this.amountSpent, pettyCashTransactionRequestDto.amountSpent) &&
        Objects.equals(this.quantity, pettyCashTransactionRequestDto.quantity) &&
        Objects.equals(this.rate, pettyCashTransactionRequestDto.rate) &&
        Objects.equals(this.cumulativeTotalAmount, pettyCashTransactionRequestDto.cumulativeTotalAmount) &&
        Objects.equals(this.purposeJustification, pettyCashTransactionRequestDto.purposeJustification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectId, equipmentId, itemId, reportDate, remarks, amountSpent, quantity, rate, cumulativeTotalAmount, purposeJustification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PettyCashTransactionRequestDto {\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    equipmentId: ").append(toIndentedString(equipmentId)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    reportDate: ").append(toIndentedString(reportDate)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
    sb.append("    amountSpent: ").append(toIndentedString(amountSpent)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    cumulativeTotalAmount: ").append(toIndentedString(cumulativeTotalAmount)).append("\n");
    sb.append("    purposeJustification: ").append(toIndentedString(purposeJustification)).append("\n");
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

