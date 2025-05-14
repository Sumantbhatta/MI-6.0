package com.machinarymgmt.service.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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
 * IncidentReportRequestDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-13T15:41:51.742519800+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class IncidentReportRequestDto {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate incidentDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate closedDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate estimatedCompletionDate;

  /**
   * The type of the incident.
   */
  public enum IncidentTypeEnum {
    MECHANICAL_FAILURE("MECHANICAL_FAILURE"),
    
    ELECTRICAL_FAILURE("ELECTRICAL_FAILURE"),
    
    MAINTENANCE_ISSUE("MAINTENANCE_ISSUE"),
    
    OPERATOR_ERROR("OPERATOR_ERROR"),
    
    SAFETY_NEAR_MISS("SAFETY_NEAR_MISS"),
    
    UNAUTHORIZED_USE("UNAUTHORIZED_USE"),
    
    ENVIRONMENTAL_DAMAGE("ENVIRONMENTAL_DAMAGE"),
    
    STRUCTURAL_FAILURE("STRUCTURAL_FAILURE"),
    
    PERFORMANCE_ISSUE("PERFORMANCE_ISSUE"),
    
    COMPLIANCE_BREACH("COMPLIANCE_BREACH");

    private final String value;

    IncidentTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static IncidentTypeEnum fromValue(String value) {
      for (IncidentTypeEnum b : IncidentTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable IncidentTypeEnum incidentType;

  private @Nullable Long equipmentId;

  private @Nullable Long projectId;

  private @Nullable String actionTaken;

  private @Nullable String incidentDetails;

  /**
   * The type of the incident.
   */
  public enum StatusEnum {
    OPEN("OPEN"),
    
    IN_PROGRESS("IN_PROGRESS"),
    
    CLOSED("CLOSED"),
    
    RESOLVED("RESOLVED");

    private final String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable StatusEnum status;

  public IncidentReportRequestDto incidentDate(LocalDate incidentDate) {
    this.incidentDate = incidentDate;
    return this;
  }

  /**
   * Get incidentDate
   * @return incidentDate
   */
  @Valid 
  @Schema(name = "incidentDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("incidentDate")
  public LocalDate getIncidentDate() {
    return incidentDate;
  }

  public void setIncidentDate(LocalDate incidentDate) {
    this.incidentDate = incidentDate;
  }

  public IncidentReportRequestDto closedDate(LocalDate closedDate) {
    this.closedDate = closedDate;
    return this;
  }

  /**
   * Get closedDate
   * @return closedDate
   */
  @Valid 
  @Schema(name = "closedDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("closedDate")
  public LocalDate getClosedDate() {
    return closedDate;
  }

  public void setClosedDate(LocalDate closedDate) {
    this.closedDate = closedDate;
  }

  public IncidentReportRequestDto estimatedCompletionDate(LocalDate estimatedCompletionDate) {
    this.estimatedCompletionDate = estimatedCompletionDate;
    return this;
  }

  /**
   * Get estimatedCompletionDate
   * @return estimatedCompletionDate
   */
  @Valid 
  @Schema(name = "estimatedCompletionDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("estimatedCompletionDate")
  public LocalDate getEstimatedCompletionDate() {
    return estimatedCompletionDate;
  }

  public void setEstimatedCompletionDate(LocalDate estimatedCompletionDate) {
    this.estimatedCompletionDate = estimatedCompletionDate;
  }

  public IncidentReportRequestDto incidentType(IncidentTypeEnum incidentType) {
    this.incidentType = incidentType;
    return this;
  }

  /**
   * The type of the incident.
   * @return incidentType
   */
  
  @Schema(name = "incidentType", description = "The type of the incident.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("incidentType")
  public IncidentTypeEnum getIncidentType() {
    return incidentType;
  }

  public void setIncidentType(IncidentTypeEnum incidentType) {
    this.incidentType = incidentType;
  }

  public IncidentReportRequestDto equipmentId(Long equipmentId) {
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

  public IncidentReportRequestDto projectId(Long projectId) {
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

  public IncidentReportRequestDto actionTaken(String actionTaken) {
    this.actionTaken = actionTaken;
    return this;
  }

  /**
   * Get actionTaken
   * @return actionTaken
   */
  
  @Schema(name = "actionTaken", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("actionTaken")
  public String getActionTaken() {
    return actionTaken;
  }

  public void setActionTaken(String actionTaken) {
    this.actionTaken = actionTaken;
  }

  public IncidentReportRequestDto incidentDetails(String incidentDetails) {
    this.incidentDetails = incidentDetails;
    return this;
  }

  /**
   * Get incidentDetails
   * @return incidentDetails
   */
  
  @Schema(name = "incidentDetails", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("incidentDetails")
  public String getIncidentDetails() {
    return incidentDetails;
  }

  public void setIncidentDetails(String incidentDetails) {
    this.incidentDetails = incidentDetails;
  }

  public IncidentReportRequestDto status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * The type of the incident.
   * @return status
   */
  
  @Schema(name = "status", description = "The type of the incident.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IncidentReportRequestDto incidentReportRequestDto = (IncidentReportRequestDto) o;
    return Objects.equals(this.incidentDate, incidentReportRequestDto.incidentDate) &&
        Objects.equals(this.closedDate, incidentReportRequestDto.closedDate) &&
        Objects.equals(this.estimatedCompletionDate, incidentReportRequestDto.estimatedCompletionDate) &&
        Objects.equals(this.incidentType, incidentReportRequestDto.incidentType) &&
        Objects.equals(this.equipmentId, incidentReportRequestDto.equipmentId) &&
        Objects.equals(this.projectId, incidentReportRequestDto.projectId) &&
        Objects.equals(this.actionTaken, incidentReportRequestDto.actionTaken) &&
        Objects.equals(this.incidentDetails, incidentReportRequestDto.incidentDetails) &&
        Objects.equals(this.status, incidentReportRequestDto.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(incidentDate, closedDate, estimatedCompletionDate, incidentType, equipmentId, projectId, actionTaken, incidentDetails, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IncidentReportRequestDto {\n");
    sb.append("    incidentDate: ").append(toIndentedString(incidentDate)).append("\n");
    sb.append("    closedDate: ").append(toIndentedString(closedDate)).append("\n");
    sb.append("    estimatedCompletionDate: ").append(toIndentedString(estimatedCompletionDate)).append("\n");
    sb.append("    incidentType: ").append(toIndentedString(incidentType)).append("\n");
    sb.append("    equipmentId: ").append(toIndentedString(equipmentId)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    actionTaken: ").append(toIndentedString(actionTaken)).append("\n");
    sb.append("    incidentDetails: ").append(toIndentedString(incidentDetails)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

