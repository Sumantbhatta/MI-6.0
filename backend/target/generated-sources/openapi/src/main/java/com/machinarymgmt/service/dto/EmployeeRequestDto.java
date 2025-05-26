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
 * EmployeeRequestDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-26T16:53:22.870701700+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class EmployeeRequestDto {

  private @Nullable String name;

  private @Nullable String remarks;

  private @Nullable Long departmentId;

  private @Nullable Long designationId;

  public EmployeeRequestDto name(String name) {
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

  public EmployeeRequestDto remarks(String remarks) {
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

  public EmployeeRequestDto departmentId(Long departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  /**
   * Get departmentId
   * @return departmentId
   */
  
  @Schema(name = "departmentId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("departmentId")
  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }

  public EmployeeRequestDto designationId(Long designationId) {
    this.designationId = designationId;
    return this;
  }

  /**
   * Get designationId
   * @return designationId
   */
  
  @Schema(name = "designationId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("designationId")
  public Long getDesignationId() {
    return designationId;
  }

  public void setDesignationId(Long designationId) {
    this.designationId = designationId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmployeeRequestDto employeeRequestDto = (EmployeeRequestDto) o;
    return Objects.equals(this.name, employeeRequestDto.name) &&
        Objects.equals(this.remarks, employeeRequestDto.remarks) &&
        Objects.equals(this.departmentId, employeeRequestDto.departmentId) &&
        Objects.equals(this.designationId, employeeRequestDto.designationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, remarks, departmentId, designationId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmployeeRequestDto {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
    sb.append("    departmentId: ").append(toIndentedString(departmentId)).append("\n");
    sb.append("    designationId: ").append(toIndentedString(designationId)).append("\n");
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

