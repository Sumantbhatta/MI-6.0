package com.machinarymgmt.service.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.machinarymgmt.service.dto.CategorySummaryDto;
import com.machinarymgmt.service.dto.ModelSummaryDto;
import com.machinarymgmt.service.dto.ProjectSummaryDto;
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
 * EquipmentDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-13T15:41:51.742519800+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class EquipmentDto {

  private @Nullable Long id;

  private @Nullable String name;

  private @Nullable String assetCode;

  private @Nullable String vehicleNumber;

  private @Nullable Integer yearOfManufacture;

  private @Nullable CategorySummaryDto category;

  private @Nullable ModelSummaryDto model;

  private @Nullable ProjectSummaryDto project;

  public EquipmentDto id(Long id) {
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

  public EquipmentDto name(String name) {
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

  public EquipmentDto assetCode(String assetCode) {
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

  public EquipmentDto vehicleNumber(String vehicleNumber) {
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

  public EquipmentDto yearOfManufacture(Integer yearOfManufacture) {
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

  public EquipmentDto category(CategorySummaryDto category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   */
  @Valid 
  @Schema(name = "category", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("category")
  public CategorySummaryDto getCategory() {
    return category;
  }

  public void setCategory(CategorySummaryDto category) {
    this.category = category;
  }

  public EquipmentDto model(ModelSummaryDto model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   * @return model
   */
  @Valid 
  @Schema(name = "model", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("model")
  public ModelSummaryDto getModel() {
    return model;
  }

  public void setModel(ModelSummaryDto model) {
    this.model = model;
  }

  public EquipmentDto project(ProjectSummaryDto project) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EquipmentDto equipmentDto = (EquipmentDto) o;
    return Objects.equals(this.id, equipmentDto.id) &&
        Objects.equals(this.name, equipmentDto.name) &&
        Objects.equals(this.assetCode, equipmentDto.assetCode) &&
        Objects.equals(this.vehicleNumber, equipmentDto.vehicleNumber) &&
        Objects.equals(this.yearOfManufacture, equipmentDto.yearOfManufacture) &&
        Objects.equals(this.category, equipmentDto.category) &&
        Objects.equals(this.model, equipmentDto.model) &&
        Objects.equals(this.project, equipmentDto.project);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, assetCode, vehicleNumber, yearOfManufacture, category, model, project);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EquipmentDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    assetCode: ").append(toIndentedString(assetCode)).append("\n");
    sb.append("    vehicleNumber: ").append(toIndentedString(vehicleNumber)).append("\n");
    sb.append("    yearOfManufacture: ").append(toIndentedString(yearOfManufacture)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
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

