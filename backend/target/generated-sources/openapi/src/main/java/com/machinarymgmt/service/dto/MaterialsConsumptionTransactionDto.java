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
 * MaterialsConsumptionTransactionDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-27T12:57:30.564361800+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class MaterialsConsumptionTransactionDto {

  private @Nullable Long id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate issueDate;

  private @Nullable Integer quantity;

  private @Nullable Double costPerUnit;

  private @Nullable Double totalCost;

  private @Nullable String remarks;

  private @Nullable ProjectSummaryDto project;

  private @Nullable EquipmentSummaryDto equipment;

  private @Nullable ItemSummaryDto item;

  public MaterialsConsumptionTransactionDto id(Long id) {
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

  public MaterialsConsumptionTransactionDto issueDate(LocalDate issueDate) {
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

  public MaterialsConsumptionTransactionDto quantity(Integer quantity) {
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

  public MaterialsConsumptionTransactionDto costPerUnit(Double costPerUnit) {
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

  public MaterialsConsumptionTransactionDto totalCost(Double totalCost) {
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

  public MaterialsConsumptionTransactionDto remarks(String remarks) {
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

  public MaterialsConsumptionTransactionDto project(ProjectSummaryDto project) {
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

  public MaterialsConsumptionTransactionDto equipment(EquipmentSummaryDto equipment) {
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

  public MaterialsConsumptionTransactionDto item(ItemSummaryDto item) {
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
    MaterialsConsumptionTransactionDto materialsConsumptionTransactionDto = (MaterialsConsumptionTransactionDto) o;
    return Objects.equals(this.id, materialsConsumptionTransactionDto.id) &&
        Objects.equals(this.issueDate, materialsConsumptionTransactionDto.issueDate) &&
        Objects.equals(this.quantity, materialsConsumptionTransactionDto.quantity) &&
        Objects.equals(this.costPerUnit, materialsConsumptionTransactionDto.costPerUnit) &&
        Objects.equals(this.totalCost, materialsConsumptionTransactionDto.totalCost) &&
        Objects.equals(this.remarks, materialsConsumptionTransactionDto.remarks) &&
        Objects.equals(this.project, materialsConsumptionTransactionDto.project) &&
        Objects.equals(this.equipment, materialsConsumptionTransactionDto.equipment) &&
        Objects.equals(this.item, materialsConsumptionTransactionDto.item);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, issueDate, quantity, costPerUnit, totalCost, remarks, project, equipment, item);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MaterialsConsumptionTransactionDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    issueDate: ").append(toIndentedString(issueDate)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    costPerUnit: ").append(toIndentedString(costPerUnit)).append("\n");
    sb.append("    totalCost: ").append(toIndentedString(totalCost)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
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

