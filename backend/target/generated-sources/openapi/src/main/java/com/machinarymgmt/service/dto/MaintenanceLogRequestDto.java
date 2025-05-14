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
 * MaintenanceLogRequestDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-13T15:41:51.742519800+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class MaintenanceLogRequestDto {

  private @Nullable Long equipmentId;

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

  public MaintenanceLogRequestDto equipmentId(Long equipmentId) {
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

  public MaintenanceLogRequestDto date(LocalDate date) {
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

  public MaintenanceLogRequestDto serviceDate(LocalDate serviceDate) {
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

  public MaintenanceLogRequestDto breakdownSynopsis(String breakdownSynopsis) {
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

  public MaintenanceLogRequestDto feedback(String feedback) {
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

  public MaintenanceLogRequestDto balanceForService(Long balanceForService) {
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

  public MaintenanceLogRequestDto closeReading(Long closeReading) {
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

  public MaintenanceLogRequestDto serviceHours(Long serviceHours) {
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

  public MaintenanceLogRequestDto startReading(Long startReading) {
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

  public MaintenanceLogRequestDto maintenanceSignature(String maintenanceSignature) {
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

  public MaintenanceLogRequestDto operatorSignature(String operatorSignature) {
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

  public MaintenanceLogRequestDto operatorName(String operatorName) {
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

  public MaintenanceLogRequestDto purposeActivities(String purposeActivities) {
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

  public MaintenanceLogRequestDto remarks(String remarks) {
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

  public MaintenanceLogRequestDto typeOfMaintenance(String typeOfMaintenance) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MaintenanceLogRequestDto maintenanceLogRequestDto = (MaintenanceLogRequestDto) o;
    return Objects.equals(this.equipmentId, maintenanceLogRequestDto.equipmentId) &&
        Objects.equals(this.date, maintenanceLogRequestDto.date) &&
        Objects.equals(this.serviceDate, maintenanceLogRequestDto.serviceDate) &&
        Objects.equals(this.breakdownSynopsis, maintenanceLogRequestDto.breakdownSynopsis) &&
        Objects.equals(this.feedback, maintenanceLogRequestDto.feedback) &&
        Objects.equals(this.balanceForService, maintenanceLogRequestDto.balanceForService) &&
        Objects.equals(this.closeReading, maintenanceLogRequestDto.closeReading) &&
        Objects.equals(this.serviceHours, maintenanceLogRequestDto.serviceHours) &&
        Objects.equals(this.startReading, maintenanceLogRequestDto.startReading) &&
        Objects.equals(this.maintenanceSignature, maintenanceLogRequestDto.maintenanceSignature) &&
        Objects.equals(this.operatorSignature, maintenanceLogRequestDto.operatorSignature) &&
        Objects.equals(this.operatorName, maintenanceLogRequestDto.operatorName) &&
        Objects.equals(this.purposeActivities, maintenanceLogRequestDto.purposeActivities) &&
        Objects.equals(this.remarks, maintenanceLogRequestDto.remarks) &&
        Objects.equals(this.typeOfMaintenance, maintenanceLogRequestDto.typeOfMaintenance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(equipmentId, date, serviceDate, breakdownSynopsis, feedback, balanceForService, closeReading, serviceHours, startReading, maintenanceSignature, operatorSignature, operatorName, purposeActivities, remarks, typeOfMaintenance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MaintenanceLogRequestDto {\n");
    sb.append("    equipmentId: ").append(toIndentedString(equipmentId)).append("\n");
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

