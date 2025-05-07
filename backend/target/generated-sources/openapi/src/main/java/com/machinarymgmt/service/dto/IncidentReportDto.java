package com.machinarymgmt.service.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.machinarymgmt.service.dto.EquipmentSummaryDto;
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
 * IncidentReportDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-06T14:34:14.883037100+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class IncidentReportDto {

  private @Nullable Long id;

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

  private @Nullable EquipmentSummaryDto equipment;

  private @Nullable ProjectSummaryDto project;

  public IncidentReportDto id(Long id) {
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

  public IncidentReportDto incidentDate(LocalDate incidentDate) {
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

  public IncidentReportDto closedDate(LocalDate closedDate) {
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

  public IncidentReportDto estimatedCompletionDate(LocalDate estimatedCompletionDate) {
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

  public IncidentReportDto incidentType(IncidentTypeEnum incidentType) {
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

  public IncidentReportDto actionTaken(String actionTaken) {
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

  public IncidentReportDto incidentDetails(String incidentDetails) {
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

  public IncidentReportDto status(StatusEnum status) {
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

  public IncidentReportDto equipment(EquipmentSummaryDto equipment) {
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

  public IncidentReportDto project(ProjectSummaryDto project) {
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
    IncidentReportDto incidentReportDto = (IncidentReportDto) o;
    return Objects.equals(this.id, incidentReportDto.id) &&
        Objects.equals(this.incidentDate, incidentReportDto.incidentDate) &&
        Objects.equals(this.closedDate, incidentReportDto.closedDate) &&
        Objects.equals(this.estimatedCompletionDate, incidentReportDto.estimatedCompletionDate) &&
        Objects.equals(this.incidentType, incidentReportDto.incidentType) &&
        Objects.equals(this.actionTaken, incidentReportDto.actionTaken) &&
        Objects.equals(this.incidentDetails, incidentReportDto.incidentDetails) &&
        Objects.equals(this.status, incidentReportDto.status) &&
        Objects.equals(this.equipment, incidentReportDto.equipment) &&
        Objects.equals(this.project, incidentReportDto.project);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, incidentDate, closedDate, estimatedCompletionDate, incidentType, actionTaken, incidentDetails, status, equipment, project);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IncidentReportDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    incidentDate: ").append(toIndentedString(incidentDate)).append("\n");
    sb.append("    closedDate: ").append(toIndentedString(closedDate)).append("\n");
    sb.append("    estimatedCompletionDate: ").append(toIndentedString(estimatedCompletionDate)).append("\n");
    sb.append("    incidentType: ").append(toIndentedString(incidentType)).append("\n");
    sb.append("    actionTaken: ").append(toIndentedString(actionTaken)).append("\n");
    sb.append("    incidentDetails: ").append(toIndentedString(incidentDetails)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

