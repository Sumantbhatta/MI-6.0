package com.machinarymgmt.service.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.machinarymgmt.service.dto.EmployeeSummaryDto;
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
 * OvertimeReportDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-13T15:41:51.742519800+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class OvertimeReportDto {

  private @Nullable Long id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate date;

  private @Nullable EmployeeSummaryDto employee;

  private @Nullable Integer presentDays;

  private @Nullable Double otHours;

  private @Nullable String remarks;

  public OvertimeReportDto id(Long id) {
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

  public OvertimeReportDto date(LocalDate date) {
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

  public OvertimeReportDto employee(EmployeeSummaryDto employee) {
    this.employee = employee;
    return this;
  }

  /**
   * Get employee
   * @return employee
   */
  @Valid 
  @Schema(name = "employee", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("employee")
  public EmployeeSummaryDto getEmployee() {
    return employee;
  }

  public void setEmployee(EmployeeSummaryDto employee) {
    this.employee = employee;
  }

  public OvertimeReportDto presentDays(Integer presentDays) {
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

  public OvertimeReportDto otHours(Double otHours) {
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

  public OvertimeReportDto remarks(String remarks) {
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
    OvertimeReportDto overtimeReportDto = (OvertimeReportDto) o;
    return Objects.equals(this.id, overtimeReportDto.id) &&
        Objects.equals(this.date, overtimeReportDto.date) &&
        Objects.equals(this.employee, overtimeReportDto.employee) &&
        Objects.equals(this.presentDays, overtimeReportDto.presentDays) &&
        Objects.equals(this.otHours, overtimeReportDto.otHours) &&
        Objects.equals(this.remarks, overtimeReportDto.remarks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, date, employee, presentDays, otHours, remarks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OvertimeReportDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    employee: ").append(toIndentedString(employee)).append("\n");
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

