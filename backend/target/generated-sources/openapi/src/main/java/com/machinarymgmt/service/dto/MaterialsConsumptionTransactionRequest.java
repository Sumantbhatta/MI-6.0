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
 * MaterialsConsumptionTransactionRequest
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-06T14:34:14.883037100+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class MaterialsConsumptionTransactionRequest {

  private @Nullable Long projectId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate issueDate;

  private @Nullable Long equipmentId;

  private @Nullable Long itemId;

  private @Nullable Integer quantity;

  private @Nullable Double costPerUnit;

  private @Nullable Double totalCost;

  private @Nullable String remarks;

  public MaterialsConsumptionTransactionRequest projectId(Long projectId) {
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

  public MaterialsConsumptionTransactionRequest issueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
    return this;
  }

  /**
   * Get issueDate
   * @return issueDate
   */
  @Valid 
  @Schema(name = "issueDate", example = "2025-04-14", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("issueDate")
  public LocalDate getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
  }

  public MaterialsConsumptionTransactionRequest equipmentId(Long equipmentId) {
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

  public MaterialsConsumptionTransactionRequest itemId(Long itemId) {
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

  public MaterialsConsumptionTransactionRequest quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * minimum: 1
   * @return quantity
   */
  @Min(1) 
  @Schema(name = "quantity", example = "50", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public MaterialsConsumptionTransactionRequest costPerUnit(Double costPerUnit) {
    this.costPerUnit = costPerUnit;
    return this;
  }

  /**
   * Get costPerUnit
   * @return costPerUnit
   */
  
  @Schema(name = "costPerUnit", example = "123.45", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("costPerUnit")
  public Double getCostPerUnit() {
    return costPerUnit;
  }

  public void setCostPerUnit(Double costPerUnit) {
    this.costPerUnit = costPerUnit;
  }

  public MaterialsConsumptionTransactionRequest totalCost(Double totalCost) {
    this.totalCost = totalCost;
    return this;
  }

  /**
   * Get totalCost
   * @return totalCost
   */
  
  @Schema(name = "totalCost", example = "6172.5", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalCost")
  public Double getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(Double totalCost) {
    this.totalCost = totalCost;
  }

  public MaterialsConsumptionTransactionRequest remarks(String remarks) {
    this.remarks = remarks;
    return this;
  }

  /**
   * Get remarks
   * @return remarks
   */
  
  @Schema(name = "remarks", example = "Used for foundation setup on site A", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("remarks")
  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MaterialsConsumptionTransactionRequest materialsConsumptionTransactionRequest = (MaterialsConsumptionTransactionRequest) o;
    return Objects.equals(this.projectId, materialsConsumptionTransactionRequest.projectId) &&
        Objects.equals(this.issueDate, materialsConsumptionTransactionRequest.issueDate) &&
        Objects.equals(this.equipmentId, materialsConsumptionTransactionRequest.equipmentId) &&
        Objects.equals(this.itemId, materialsConsumptionTransactionRequest.itemId) &&
        Objects.equals(this.quantity, materialsConsumptionTransactionRequest.quantity) &&
        Objects.equals(this.costPerUnit, materialsConsumptionTransactionRequest.costPerUnit) &&
        Objects.equals(this.totalCost, materialsConsumptionTransactionRequest.totalCost) &&
        Objects.equals(this.remarks, materialsConsumptionTransactionRequest.remarks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectId, issueDate, equipmentId, itemId, quantity, costPerUnit, totalCost, remarks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MaterialsConsumptionTransactionRequest {\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    issueDate: ").append(toIndentedString(issueDate)).append("\n");
    sb.append("    equipmentId: ").append(toIndentedString(equipmentId)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    costPerUnit: ").append(toIndentedString(costPerUnit)).append("\n");
    sb.append("    totalCost: ").append(toIndentedString(totalCost)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
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

