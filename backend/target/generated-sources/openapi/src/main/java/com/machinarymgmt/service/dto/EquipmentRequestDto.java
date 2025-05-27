package com.machinarymgmt.service.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * EquipmentRequestDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-27T12:57:30.564361800+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class EquipmentRequestDto {

  private @Nullable String name;

  private @Nullable Long categoryId;

  private @Nullable Long modelId;

  private @Nullable String assetCode;

  private @Nullable String vehicleNumber;

  private @Nullable Integer yearOfManufacture;

  private @Nullable Long projectId;

  public EquipmentRequestDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EquipmentRequestDto categoryId(Long categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * Get categoryId
   * @return categoryId
   */
  
  @Schema(name = "categoryId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categoryId")
  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public EquipmentRequestDto modelId(Long modelId) {
    this.modelId = modelId;
    return this;
  }

  /**
   * Get modelId
   * @return modelId
   */
  
  @Schema(name = "modelId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("modelId")
  public Long getModelId() {
    return modelId;
  }

  public void setModelId(Long modelId) {
    this.modelId = modelId;
  }

  public EquipmentRequestDto assetCode(String assetCode) {
    this.assetCode = assetCode;
    return this;
  }

  /**
   * Get assetCode
   * @return assetCode
   */
  
  @Schema(name = "assetCode", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("assetCode")
  public String getAssetCode() {
    return assetCode;
  }

  public void setAssetCode(String assetCode) {
    this.assetCode = assetCode;
  }

  public EquipmentRequestDto vehicleNumber(String vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
    return this;
  }

  /**
   * Get vehicleNumber
   * @return vehicleNumber
   */
  @Size(max = 20) 
  @Schema(name = "vehicleNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("vehicleNumber")
  public String getVehicleNumber() {
    return vehicleNumber;
  }

  public void setVehicleNumber(String vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
  }

  public EquipmentRequestDto yearOfManufacture(Integer yearOfManufacture) {
    this.yearOfManufacture = yearOfManufacture;
    return this;
  }

  /**
   * Get yearOfManufacture
   * @return yearOfManufacture
   */
  
  @Schema(name = "yearOfManufacture", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("yearOfManufacture")
  public Integer getYearOfManufacture() {
    return yearOfManufacture;
  }

  public void setYearOfManufacture(Integer yearOfManufacture) {
    this.yearOfManufacture = yearOfManufacture;
  }

  public EquipmentRequestDto projectId(Long projectId) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EquipmentRequestDto equipmentRequestDto = (EquipmentRequestDto) o;
    return Objects.equals(this.name, equipmentRequestDto.name) &&
        Objects.equals(this.categoryId, equipmentRequestDto.categoryId) &&
        Objects.equals(this.modelId, equipmentRequestDto.modelId) &&
        Objects.equals(this.assetCode, equipmentRequestDto.assetCode) &&
        Objects.equals(this.vehicleNumber, equipmentRequestDto.vehicleNumber) &&
        Objects.equals(this.yearOfManufacture, equipmentRequestDto.yearOfManufacture) &&
        Objects.equals(this.projectId, equipmentRequestDto.projectId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, categoryId, modelId, assetCode, vehicleNumber, yearOfManufacture, projectId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EquipmentRequestDto {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    modelId: ").append(toIndentedString(modelId)).append("\n");
    sb.append("    assetCode: ").append(toIndentedString(assetCode)).append("\n");
    sb.append("    vehicleNumber: ").append(toIndentedString(vehicleNumber)).append("\n");
    sb.append("    yearOfManufacture: ").append(toIndentedString(yearOfManufacture)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
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

