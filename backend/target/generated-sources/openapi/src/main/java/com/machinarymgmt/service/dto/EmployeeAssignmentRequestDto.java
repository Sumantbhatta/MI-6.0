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
 * EmployeeAssignmentRequestDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-27T12:57:30.564361800+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class EmployeeAssignmentRequestDto {

  private @Nullable Long employeeId;

  private @Nullable Long projectId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate joiningDate;

  private @Nullable Long equipmentId;

  public EmployeeAssignmentRequestDto employeeId(Long employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  /**
   * Get employeeId
   * @return employeeId
   */
  
  @Schema(name = "employeeId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("employeeId")
  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public EmployeeAssignmentRequestDto projectId(Long projectId) {
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

  public EmployeeAssignmentRequestDto joiningDate(LocalDate joiningDate) {
    this.joiningDate = joiningDate;
    return this;
  }

  /**
   * Get joiningDate
   * @return joiningDate
   */
  @Valid 
  @Schema(name = "joiningDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("joiningDate")
  public LocalDate getJoiningDate() {
    return joiningDate;
  }

  public void setJoiningDate(LocalDate joiningDate) {
    this.joiningDate = joiningDate;
  }

  public EmployeeAssignmentRequestDto equipmentId(Long equipmentId) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmployeeAssignmentRequestDto employeeAssignmentRequestDto = (EmployeeAssignmentRequestDto) o;
    return Objects.equals(this.employeeId, employeeAssignmentRequestDto.employeeId) &&
        Objects.equals(this.projectId, employeeAssignmentRequestDto.projectId) &&
        Objects.equals(this.joiningDate, employeeAssignmentRequestDto.joiningDate) &&
        Objects.equals(this.equipmentId, employeeAssignmentRequestDto.equipmentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeId, projectId, joiningDate, equipmentId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmployeeAssignmentRequestDto {\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    joiningDate: ").append(toIndentedString(joiningDate)).append("\n");
    sb.append("    equipmentId: ").append(toIndentedString(equipmentId)).append("\n");
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

