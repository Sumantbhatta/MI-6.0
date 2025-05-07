package com.machinarymgmt.service.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.machinarymgmt.service.dto.EquipmentSummaryDto;
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
 * MaintenanceLogDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-06T14:34:14.883037100+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class MaintenanceLogDto {

  private @Nullable Long id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate date;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate serviceDate;

  private @Nullable String breakdownSynopsis;

  private @Nullable String feedback;

  private @Nullable Long balanceForService;

  private @Nullable Long closeReading;

  private @Nullable Long serviceHours;

  private @Nullable Long startReading;

  private @Nullable String maintenanceSignature;

  private @Nullable String operatorSignature;

  private @Nullable String operatorName;

  private @Nullable String purposeActivities;

  private @Nullable String remarks;

  private @Nullable String typeOfMaintenance;

  private @Nullable EquipmentSummaryDto equipment;

  public MaintenanceLogDto id(Long id) {
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

  public MaintenanceLogDto date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   */
  @Valid 
  @Schema(name = "date", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public MaintenanceLogDto serviceDate(LocalDate serviceDate) {
    this.serviceDate = serviceDate;
    return this;
  }

  /**
   * Get serviceDate
   * @return serviceDate
   */
  @Valid 
  @Schema(name = "serviceDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("serviceDate")
  public LocalDate getServiceDate() {
    return serviceDate;
  }

  public void setServiceDate(LocalDate serviceDate) {
    this.serviceDate = serviceDate;
  }

  public MaintenanceLogDto breakdownSynopsis(String breakdownSynopsis) {
    this.breakdownSynopsis = breakdownSynopsis;
    return this;
  }

  /**
   * Get breakdownSynopsis
   * @return breakdownSynopsis
   */
  
  @Schema(name = "breakdownSynopsis", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("breakdownSynopsis")
  public String getBreakdownSynopsis() {
    return breakdownSynopsis;
  }

  public void setBreakdownSynopsis(String breakdownSynopsis) {
    this.breakdownSynopsis = breakdownSynopsis;
  }

  public MaintenanceLogDto feedback(String feedback) {
    this.feedback = feedback;
    return this;
  }

  /**
   * Get feedback
   * @return feedback
   */
  
  @Schema(name = "feedback", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("feedback")
  public String getFeedback() {
    return feedback;
  }

  public void setFeedback(String feedback) {
    this.feedback = feedback;
  }

  public MaintenanceLogDto balanceForService(Long balanceForService) {
    this.balanceForService = balanceForService;
    return this;
  }

  /**
   * Get balanceForService
   * @return balanceForService
   */
  
  @Schema(name = "balanceForService", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("balanceForService")
  public Long getBalanceForService() {
    return balanceForService;
  }

  public void setBalanceForService(Long balanceForService) {
    this.balanceForService = balanceForService;
  }

  public MaintenanceLogDto closeReading(Long closeReading) {
    this.closeReading = closeReading;
    return this;
  }

  /**
   * Get closeReading
   * @return closeReading
   */
  
  @Schema(name = "closeReading", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("closeReading")
  public Long getCloseReading() {
    return closeReading;
  }

  public void setCloseReading(Long closeReading) {
    this.closeReading = closeReading;
  }

  public MaintenanceLogDto serviceHours(Long serviceHours) {
    this.serviceHours = serviceHours;
    return this;
  }

  /**
   * Get serviceHours
   * @return serviceHours
   */
  
  @Schema(name = "serviceHours", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("serviceHours")
  public Long getServiceHours() {
    return serviceHours;
  }

  public void setServiceHours(Long serviceHours) {
    this.serviceHours = serviceHours;
  }

  public MaintenanceLogDto startReading(Long startReading) {
    this.startReading = startReading;
    return this;
  }

  /**
   * Get startReading
   * @return startReading
   */
  
  @Schema(name = "startReading", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("startReading")
  public Long getStartReading() {
    return startReading;
  }

  public void setStartReading(Long startReading) {
    this.startReading = startReading;
  }

  public MaintenanceLogDto maintenanceSignature(String maintenanceSignature) {
    this.maintenanceSignature = maintenanceSignature;
    return this;
  }

  /**
   * Get maintenanceSignature
   * @return maintenanceSignature
   */
  
  @Schema(name = "maintenanceSignature", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maintenanceSignature")
  public String getMaintenanceSignature() {
    return maintenanceSignature;
  }

  public void setMaintenanceSignature(String maintenanceSignature) {
    this.maintenanceSignature = maintenanceSignature;
  }

  public MaintenanceLogDto operatorSignature(String operatorSignature) {
    this.operatorSignature = operatorSignature;
    return this;
  }

  /**
   * Get operatorSignature
   * @return operatorSignature
   */
  
  @Schema(name = "operatorSignature", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("operatorSignature")
  public String getOperatorSignature() {
    return operatorSignature;
  }

  public void setOperatorSignature(String operatorSignature) {
    this.operatorSignature = operatorSignature;
  }

  public MaintenanceLogDto operatorName(String operatorName) {
    this.operatorName = operatorName;
    return this;
  }

  /**
   * Get operatorName
   * @return operatorName
   */
  
  @Schema(name = "operatorName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("operatorName")
  public String getOperatorName() {
    return operatorName;
  }

  public void setOperatorName(String operatorName) {
    this.operatorName = operatorName;
  }

  public MaintenanceLogDto purposeActivities(String purposeActivities) {
    this.purposeActivities = purposeActivities;
    return this;
  }

  /**
   * Get purposeActivities
   * @return purposeActivities
   */
  
  @Schema(name = "purposeActivities", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("purposeActivities")
  public String getPurposeActivities() {
    return purposeActivities;
  }

  public void setPurposeActivities(String purposeActivities) {
    this.purposeActivities = purposeActivities;
  }

  public MaintenanceLogDto remarks(String remarks) {
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

  public MaintenanceLogDto typeOfMaintenance(String typeOfMaintenance) {
    this.typeOfMaintenance = typeOfMaintenance;
    return this;
  }

  /**
   * Get typeOfMaintenance
   * @return typeOfMaintenance
   */
  
  @Schema(name = "typeOfMaintenance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("typeOfMaintenance")
  public String getTypeOfMaintenance() {
    return typeOfMaintenance;
  }

  public void setTypeOfMaintenance(String typeOfMaintenance) {
    this.typeOfMaintenance = typeOfMaintenance;
  }

  public MaintenanceLogDto equipment(EquipmentSummaryDto equipment) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MaintenanceLogDto maintenanceLogDto = (MaintenanceLogDto) o;
    return Objects.equals(this.id, maintenanceLogDto.id) &&
        Objects.equals(this.date, maintenanceLogDto.date) &&
        Objects.equals(this.serviceDate, maintenanceLogDto.serviceDate) &&
        Objects.equals(this.breakdownSynopsis, maintenanceLogDto.breakdownSynopsis) &&
        Objects.equals(this.feedback, maintenanceLogDto.feedback) &&
        Objects.equals(this.balanceForService, maintenanceLogDto.balanceForService) &&
        Objects.equals(this.closeReading, maintenanceLogDto.closeReading) &&
        Objects.equals(this.serviceHours, maintenanceLogDto.serviceHours) &&
        Objects.equals(this.startReading, maintenanceLogDto.startReading) &&
        Objects.equals(this.maintenanceSignature, maintenanceLogDto.maintenanceSignature) &&
        Objects.equals(this.operatorSignature, maintenanceLogDto.operatorSignature) &&
        Objects.equals(this.operatorName, maintenanceLogDto.operatorName) &&
        Objects.equals(this.purposeActivities, maintenanceLogDto.purposeActivities) &&
        Objects.equals(this.remarks, maintenanceLogDto.remarks) &&
        Objects.equals(this.typeOfMaintenance, maintenanceLogDto.typeOfMaintenance) &&
        Objects.equals(this.equipment, maintenanceLogDto.equipment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, date, serviceDate, breakdownSynopsis, feedback, balanceForService, closeReading, serviceHours, startReading, maintenanceSignature, operatorSignature, operatorName, purposeActivities, remarks, typeOfMaintenance, equipment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MaintenanceLogDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    serviceDate: ").append(toIndentedString(serviceDate)).append("\n");
    sb.append("    breakdownSynopsis: ").append(toIndentedString(breakdownSynopsis)).append("\n");
    sb.append("    feedback: ").append(toIndentedString(feedback)).append("\n");
    sb.append("    balanceForService: ").append(toIndentedString(balanceForService)).append("\n");
    sb.append("    closeReading: ").append(toIndentedString(closeReading)).append("\n");
    sb.append("    serviceHours: ").append(toIndentedString(serviceHours)).append("\n");
    sb.append("    startReading: ").append(toIndentedString(startReading)).append("\n");
    sb.append("    maintenanceSignature: ").append(toIndentedString(maintenanceSignature)).append("\n");
    sb.append("    operatorSignature: ").append(toIndentedString(operatorSignature)).append("\n");
    sb.append("    operatorName: ").append(toIndentedString(operatorName)).append("\n");
    sb.append("    purposeActivities: ").append(toIndentedString(purposeActivities)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
    sb.append("    typeOfMaintenance: ").append(toIndentedString(typeOfMaintenance)).append("\n");
    sb.append("    equipment: ").append(toIndentedString(equipment)).append("\n");
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

