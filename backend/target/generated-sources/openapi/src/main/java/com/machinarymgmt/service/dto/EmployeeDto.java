package com.machinarymgmt.service.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.machinarymgmt.service.dto.DepartmentDto;
import com.machinarymgmt.service.dto.DesignationDto;
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
 * EmployeeDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-26T16:53:22.870701700+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class EmployeeDto {

  private @Nullable Long id;

  private @Nullable String name;

  private @Nullable String remarks;

  private @Nullable DepartmentDto department;

  private @Nullable DesignationDto designation;

  public EmployeeDto id(Long id) {
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

  public EmployeeDto name(String name) {
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

  public EmployeeDto remarks(String remarks) {
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

  public EmployeeDto department(DepartmentDto department) {
    this.department = department;
    return this;
  }

  /**
   * Get department
   * @return department
   */
  @Valid 
  @Schema(name = "department", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("department")
  public DepartmentDto getDepartment() {
    return department;
  }

  public void setDepartment(DepartmentDto department) {
    this.department = department;
  }

  public EmployeeDto designation(DesignationDto designation) {
    this.designation = designation;
    return this;
  }

  /**
   * Get designation
   * @return designation
   */
  @Valid 
  @Schema(name = "designation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("designation")
  public DesignationDto getDesignation() {
    return designation;
  }

  public void setDesignation(DesignationDto designation) {
    this.designation = designation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmployeeDto employeeDto = (EmployeeDto) o;
    return Objects.equals(this.id, employeeDto.id) &&
        Objects.equals(this.name, employeeDto.name) &&
        Objects.equals(this.remarks, employeeDto.remarks) &&
        Objects.equals(this.department, employeeDto.department) &&
        Objects.equals(this.designation, employeeDto.designation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, remarks, department, designation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmployeeDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    designation: ").append(toIndentedString(designation)).append("\n");
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

