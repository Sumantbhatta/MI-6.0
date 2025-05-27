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
 * OvertimeReportRequestDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-27T12:57:30.564361800+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class OvertimeReportRequestDto {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate date;

  private @Nullable Long employeeId;

  private @Nullable Integer presentDays;

  private @Nullable Double otHours;

  private @Nullable String remarks;

  public OvertimeReportRequestDto date(LocalDate date) {
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

  public OvertimeReportRequestDto employeeId(Long employeeId) {
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

  public OvertimeReportRequestDto presentDays(Integer presentDays) {
    this.presentDays = presentDays;
    return this;
  }

  /**
   * Get presentDays
   * @return presentDays
   */
  
  @Schema(name = "presentDays", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("presentDays")
  public Integer getPresentDays() {
    return presentDays;
  }

  public void setPresentDays(Integer presentDays) {
    this.presentDays = presentDays;
  }

  public OvertimeReportRequestDto otHours(Double otHours) {
    this.otHours = otHours;
    return this;
  }

  /**
   * Get otHours
   * @return otHours
   */
  
  @Schema(name = "otHours", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("otHours")
  public Double getOtHours() {
    return otHours;
  }

  public void setOtHours(Double otHours) {
    this.otHours = otHours;
  }

  public OvertimeReportRequestDto remarks(String remarks) {
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
    OvertimeReportRequestDto overtimeReportRequestDto = (OvertimeReportRequestDto) o;
    return Objects.equals(this.date, overtimeReportRequestDto.date) &&
        Objects.equals(this.employeeId, overtimeReportRequestDto.employeeId) &&
        Objects.equals(this.presentDays, overtimeReportRequestDto.presentDays) &&
        Objects.equals(this.otHours, overtimeReportRequestDto.otHours) &&
        Objects.equals(this.remarks, overtimeReportRequestDto.remarks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, employeeId, presentDays, otHours, remarks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OvertimeReportRequestDto {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    presentDays: ").append(toIndentedString(presentDays)).append("\n");
    sb.append("    otHours: ").append(toIndentedString(otHours)).append("\n");
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

