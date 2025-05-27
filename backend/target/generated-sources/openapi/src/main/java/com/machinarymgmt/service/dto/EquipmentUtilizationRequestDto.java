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
 * EquipmentUtilizationRequestDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-27T12:57:30.564361800+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class EquipmentUtilizationRequestDto {

  private @Nullable Long equipmentId;

  private @Nullable Long projectId;

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

  public EquipmentUtilizationRequestDto equipmentId(Long equipmentId) {
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

  public EquipmentUtilizationRequestDto projectId(Long projectId) {
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

  public EquipmentUtilizationRequestDto startingHoursKms(Double startingHoursKms) {
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

  public EquipmentUtilizationRequestDto targetHoursKms(Double targetHoursKms) {
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

  public EquipmentUtilizationRequestDto closingHoursKms(Double closingHoursKms) {
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

  public EquipmentUtilizationRequestDto breakdownHoursKms(Double breakdownHoursKms) {
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

  public EquipmentUtilizationRequestDto availabilityHours(Double availabilityHours) {
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

  public EquipmentUtilizationRequestDto dieselConsumedLtrs(Double dieselConsumedLtrs) {
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

  public EquipmentUtilizationRequestDto avgFuelConsumption(Double avgFuelConsumption) {
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

  public EquipmentUtilizationRequestDto utilizationPercentage(Double utilizationPercentage) {
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

  public EquipmentUtilizationRequestDto month(Long month) {
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

  public EquipmentUtilizationRequestDto year(Long year) {
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

  public EquipmentUtilizationRequestDto remarks(String remarks) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EquipmentUtilizationRequestDto equipmentUtilizationRequestDto = (EquipmentUtilizationRequestDto) o;
    return Objects.equals(this.equipmentId, equipmentUtilizationRequestDto.equipmentId) &&
        Objects.equals(this.projectId, equipmentUtilizationRequestDto.projectId) &&
        Objects.equals(this.startingHoursKms, equipmentUtilizationRequestDto.startingHoursKms) &&
        Objects.equals(this.targetHoursKms, equipmentUtilizationRequestDto.targetHoursKms) &&
        Objects.equals(this.closingHoursKms, equipmentUtilizationRequestDto.closingHoursKms) &&
        Objects.equals(this.breakdownHoursKms, equipmentUtilizationRequestDto.breakdownHoursKms) &&
        Objects.equals(this.availabilityHours, equipmentUtilizationRequestDto.availabilityHours) &&
        Objects.equals(this.dieselConsumedLtrs, equipmentUtilizationRequestDto.dieselConsumedLtrs) &&
        Objects.equals(this.avgFuelConsumption, equipmentUtilizationRequestDto.avgFuelConsumption) &&
        Objects.equals(this.utilizationPercentage, equipmentUtilizationRequestDto.utilizationPercentage) &&
        Objects.equals(this.month, equipmentUtilizationRequestDto.month) &&
        Objects.equals(this.year, equipmentUtilizationRequestDto.year) &&
        Objects.equals(this.remarks, equipmentUtilizationRequestDto.remarks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(equipmentId, projectId, startingHoursKms, targetHoursKms, closingHoursKms, breakdownHoursKms, availabilityHours, dieselConsumedLtrs, avgFuelConsumption, utilizationPercentage, month, year, remarks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EquipmentUtilizationRequestDto {\n");
    sb.append("    equipmentId: ").append(toIndentedString(equipmentId)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
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

