package com.machinarymgmt.service.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.machinarymgmt.service.dto.EquipmentSummaryDto;
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
 * EquipmentUtilizationDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-06T14:34:14.883037100+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class EquipmentUtilizationDto {

  private @Nullable Long id;

  private @Nullable Double startingHoursKms;

  private @Nullable Double targetHoursKms;

  private @Nullable Double closingHoursKms;

  private @Nullable Double breakdownHoursKms;

  private @Nullable Double availabilityHours;

  private @Nullable Double dieselConsumedLtrs;

  private @Nullable Double avgFuelConsumption;

  private @Nullable Double utilizationPercentage;

  private @Nullable Long month;

  private @Nullable Long year;

  private @Nullable String remarks;

  private @Nullable EquipmentSummaryDto equipment;

  private @Nullable ProjectSummaryDto project;

  public EquipmentUtilizationDto id(Long id) {
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

  public EquipmentUtilizationDto startingHoursKms(Double startingHoursKms) {
    this.startingHoursKms = startingHoursKms;
    return this;
  }

  /**
   * Get startingHoursKms
   * @return startingHoursKms
   */
  
  @Schema(name = "startingHoursKms", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("startingHoursKms")
  public Double getStartingHoursKms() {
    return startingHoursKms;
  }

  public void setStartingHoursKms(Double startingHoursKms) {
    this.startingHoursKms = startingHoursKms;
  }

  public EquipmentUtilizationDto targetHoursKms(Double targetHoursKms) {
    this.targetHoursKms = targetHoursKms;
    return this;
  }

  /**
   * Get targetHoursKms
   * @return targetHoursKms
   */
  
  @Schema(name = "targetHoursKms", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("targetHoursKms")
  public Double getTargetHoursKms() {
    return targetHoursKms;
  }

  public void setTargetHoursKms(Double targetHoursKms) {
    this.targetHoursKms = targetHoursKms;
  }

  public EquipmentUtilizationDto closingHoursKms(Double closingHoursKms) {
    this.closingHoursKms = closingHoursKms;
    return this;
  }

  /**
   * Get closingHoursKms
   * @return closingHoursKms
   */
  
  @Schema(name = "closingHoursKms", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("closingHoursKms")
  public Double getClosingHoursKms() {
    return closingHoursKms;
  }

  public void setClosingHoursKms(Double closingHoursKms) {
    this.closingHoursKms = closingHoursKms;
  }

  public EquipmentUtilizationDto breakdownHoursKms(Double breakdownHoursKms) {
    this.breakdownHoursKms = breakdownHoursKms;
    return this;
  }

  /**
   * Get breakdownHoursKms
   * @return breakdownHoursKms
   */
  
  @Schema(name = "breakdownHoursKms", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("breakdownHoursKms")
  public Double getBreakdownHoursKms() {
    return breakdownHoursKms;
  }

  public void setBreakdownHoursKms(Double breakdownHoursKms) {
    this.breakdownHoursKms = breakdownHoursKms;
  }

  public EquipmentUtilizationDto availabilityHours(Double availabilityHours) {
    this.availabilityHours = availabilityHours;
    return this;
  }

  /**
   * Get availabilityHours
   * @return availabilityHours
   */
  
  @Schema(name = "availabilityHours", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("availabilityHours")
  public Double getAvailabilityHours() {
    return availabilityHours;
  }

  public void setAvailabilityHours(Double availabilityHours) {
    this.availabilityHours = availabilityHours;
  }

  public EquipmentUtilizationDto dieselConsumedLtrs(Double dieselConsumedLtrs) {
    this.dieselConsumedLtrs = dieselConsumedLtrs;
    return this;
  }

  /**
   * Get dieselConsumedLtrs
   * @return dieselConsumedLtrs
   */
  
  @Schema(name = "dieselConsumedLtrs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dieselConsumedLtrs")
  public Double getDieselConsumedLtrs() {
    return dieselConsumedLtrs;
  }

  public void setDieselConsumedLtrs(Double dieselConsumedLtrs) {
    this.dieselConsumedLtrs = dieselConsumedLtrs;
  }

  public EquipmentUtilizationDto avgFuelConsumption(Double avgFuelConsumption) {
    this.avgFuelConsumption = avgFuelConsumption;
    return this;
  }

  /**
   * Get avgFuelConsumption
   * @return avgFuelConsumption
   */
  
  @Schema(name = "avgFuelConsumption", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("avgFuelConsumption")
  public Double getAvgFuelConsumption() {
    return avgFuelConsumption;
  }

  public void setAvgFuelConsumption(Double avgFuelConsumption) {
    this.avgFuelConsumption = avgFuelConsumption;
  }

  public EquipmentUtilizationDto utilizationPercentage(Double utilizationPercentage) {
    this.utilizationPercentage = utilizationPercentage;
    return this;
  }

  /**
   * Get utilizationPercentage
   * @return utilizationPercentage
   */
  
  @Schema(name = "utilizationPercentage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("utilizationPercentage")
  public Double getUtilizationPercentage() {
    return utilizationPercentage;
  }

  public void setUtilizationPercentage(Double utilizationPercentage) {
    this.utilizationPercentage = utilizationPercentage;
  }

  public EquipmentUtilizationDto month(Long month) {
    this.month = month;
    return this;
  }

  /**
   * Get month
   * @return month
   */
  
  @Schema(name = "month", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("month")
  public Long getMonth() {
    return month;
  }

  public void setMonth(Long month) {
    this.month = month;
  }

  public EquipmentUtilizationDto year(Long year) {
    this.year = year;
    return this;
  }

  /**
   * Get year
   * @return year
   */
  
  @Schema(name = "year", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("year")
  public Long getYear() {
    return year;
  }

  public void setYear(Long year) {
    this.year = year;
  }

  public EquipmentUtilizationDto remarks(String remarks) {
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

  public EquipmentUtilizationDto equipment(EquipmentSummaryDto equipment) {
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

  public EquipmentUtilizationDto project(ProjectSummaryDto project) {
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
    EquipmentUtilizationDto equipmentUtilizationDto = (EquipmentUtilizationDto) o;
    return Objects.equals(this.id, equipmentUtilizationDto.id) &&
        Objects.equals(this.startingHoursKms, equipmentUtilizationDto.startingHoursKms) &&
        Objects.equals(this.targetHoursKms, equipmentUtilizationDto.targetHoursKms) &&
        Objects.equals(this.closingHoursKms, equipmentUtilizationDto.closingHoursKms) &&
        Objects.equals(this.breakdownHoursKms, equipmentUtilizationDto.breakdownHoursKms) &&
        Objects.equals(this.availabilityHours, equipmentUtilizationDto.availabilityHours) &&
        Objects.equals(this.dieselConsumedLtrs, equipmentUtilizationDto.dieselConsumedLtrs) &&
        Objects.equals(this.avgFuelConsumption, equipmentUtilizationDto.avgFuelConsumption) &&
        Objects.equals(this.utilizationPercentage, equipmentUtilizationDto.utilizationPercentage) &&
        Objects.equals(this.month, equipmentUtilizationDto.month) &&
        Objects.equals(this.year, equipmentUtilizationDto.year) &&
        Objects.equals(this.remarks, equipmentUtilizationDto.remarks) &&
        Objects.equals(this.equipment, equipmentUtilizationDto.equipment) &&
        Objects.equals(this.project, equipmentUtilizationDto.project);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, startingHoursKms, targetHoursKms, closingHoursKms, breakdownHoursKms, availabilityHours, dieselConsumedLtrs, avgFuelConsumption, utilizationPercentage, month, year, remarks, equipment, project);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EquipmentUtilizationDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    startingHoursKms: ").append(toIndentedString(startingHoursKms)).append("\n");
    sb.append("    targetHoursKms: ").append(toIndentedString(targetHoursKms)).append("\n");
    sb.append("    closingHoursKms: ").append(toIndentedString(closingHoursKms)).append("\n");
    sb.append("    breakdownHoursKms: ").append(toIndentedString(breakdownHoursKms)).append("\n");
    sb.append("    availabilityHours: ").append(toIndentedString(availabilityHours)).append("\n");
    sb.append("    dieselConsumedLtrs: ").append(toIndentedString(dieselConsumedLtrs)).append("\n");
    sb.append("    avgFuelConsumption: ").append(toIndentedString(avgFuelConsumption)).append("\n");
    sb.append("    utilizationPercentage: ").append(toIndentedString(utilizationPercentage)).append("\n");
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
    sb.append("    equipment: ").append(toIndentedString(equipment)).append("\n");
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

