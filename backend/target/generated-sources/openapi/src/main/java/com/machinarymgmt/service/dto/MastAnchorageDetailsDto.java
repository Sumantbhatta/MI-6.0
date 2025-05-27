package com.machinarymgmt.service.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.machinarymgmt.service.dto.EquipmentSummaryDto;
import com.machinarymgmt.service.dto.ProjectSummaryDto;
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
 * MastAnchorageDetailsDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-27T12:57:30.564361800+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class MastAnchorageDetailsDto {

  private @Nullable Long id;

  private @Nullable Integer anchorageAtSite;

  private @Nullable Integer anchorageFixedAtSite;

  private @Nullable Integer anchorageIdleAtSite;

  private @Nullable Integer mastAvailableAtSite;

  private @Nullable Integer mastFixedAtSite;

  private @Nullable Integer mastIdleAtSite;

  private @Nullable Integer totalAnchorageRequirement;

  private @Nullable Integer totalMastRequirement;

  private @Nullable String location;

  private @Nullable String presentBuildingHeight;

  private @Nullable String presentHeightOfHoist;

  private @Nullable String remarks;

  private @Nullable String totalBuildingHeight;

  private @Nullable String status;

  private @Nullable ProjectSummaryDto project;

  private @Nullable EquipmentSummaryDto equipment;

  public MastAnchorageDetailsDto id(Long id) {
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

  public MastAnchorageDetailsDto anchorageAtSite(Integer anchorageAtSite) {
    this.anchorageAtSite = anchorageAtSite;
    return this;
  }

  /**
   * Get anchorageAtSite
   * @return anchorageAtSite
   */
  
  @Schema(name = "anchorageAtSite", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("anchorageAtSite")
  public Integer getAnchorageAtSite() {
    return anchorageAtSite;
  }

  public void setAnchorageAtSite(Integer anchorageAtSite) {
    this.anchorageAtSite = anchorageAtSite;
  }

  public MastAnchorageDetailsDto anchorageFixedAtSite(Integer anchorageFixedAtSite) {
    this.anchorageFixedAtSite = anchorageFixedAtSite;
    return this;
  }

  /**
   * Get anchorageFixedAtSite
   * @return anchorageFixedAtSite
   */
  
  @Schema(name = "anchorageFixedAtSite", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("anchorageFixedAtSite")
  public Integer getAnchorageFixedAtSite() {
    return anchorageFixedAtSite;
  }

  public void setAnchorageFixedAtSite(Integer anchorageFixedAtSite) {
    this.anchorageFixedAtSite = anchorageFixedAtSite;
  }

  public MastAnchorageDetailsDto anchorageIdleAtSite(Integer anchorageIdleAtSite) {
    this.anchorageIdleAtSite = anchorageIdleAtSite;
    return this;
  }

  /**
   * Get anchorageIdleAtSite
   * @return anchorageIdleAtSite
   */
  
  @Schema(name = "anchorageIdleAtSite", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("anchorageIdleAtSite")
  public Integer getAnchorageIdleAtSite() {
    return anchorageIdleAtSite;
  }

  public void setAnchorageIdleAtSite(Integer anchorageIdleAtSite) {
    this.anchorageIdleAtSite = anchorageIdleAtSite;
  }

  public MastAnchorageDetailsDto mastAvailableAtSite(Integer mastAvailableAtSite) {
    this.mastAvailableAtSite = mastAvailableAtSite;
    return this;
  }

  /**
   * Get mastAvailableAtSite
   * @return mastAvailableAtSite
   */
  
  @Schema(name = "mastAvailableAtSite", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mastAvailableAtSite")
  public Integer getMastAvailableAtSite() {
    return mastAvailableAtSite;
  }

  public void setMastAvailableAtSite(Integer mastAvailableAtSite) {
    this.mastAvailableAtSite = mastAvailableAtSite;
  }

  public MastAnchorageDetailsDto mastFixedAtSite(Integer mastFixedAtSite) {
    this.mastFixedAtSite = mastFixedAtSite;
    return this;
  }

  /**
   * Get mastFixedAtSite
   * @return mastFixedAtSite
   */
  
  @Schema(name = "mastFixedAtSite", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mastFixedAtSite")
  public Integer getMastFixedAtSite() {
    return mastFixedAtSite;
  }

  public void setMastFixedAtSite(Integer mastFixedAtSite) {
    this.mastFixedAtSite = mastFixedAtSite;
  }

  public MastAnchorageDetailsDto mastIdleAtSite(Integer mastIdleAtSite) {
    this.mastIdleAtSite = mastIdleAtSite;
    return this;
  }

  /**
   * Get mastIdleAtSite
   * @return mastIdleAtSite
   */
  
  @Schema(name = "mastIdleAtSite", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mastIdleAtSite")
  public Integer getMastIdleAtSite() {
    return mastIdleAtSite;
  }

  public void setMastIdleAtSite(Integer mastIdleAtSite) {
    this.mastIdleAtSite = mastIdleAtSite;
  }

  public MastAnchorageDetailsDto totalAnchorageRequirement(Integer totalAnchorageRequirement) {
    this.totalAnchorageRequirement = totalAnchorageRequirement;
    return this;
  }

  /**
   * Get totalAnchorageRequirement
   * @return totalAnchorageRequirement
   */
  
  @Schema(name = "totalAnchorageRequirement", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalAnchorageRequirement")
  public Integer getTotalAnchorageRequirement() {
    return totalAnchorageRequirement;
  }

  public void setTotalAnchorageRequirement(Integer totalAnchorageRequirement) {
    this.totalAnchorageRequirement = totalAnchorageRequirement;
  }

  public MastAnchorageDetailsDto totalMastRequirement(Integer totalMastRequirement) {
    this.totalMastRequirement = totalMastRequirement;
    return this;
  }

  /**
   * Get totalMastRequirement
   * @return totalMastRequirement
   */
  
  @Schema(name = "totalMastRequirement", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalMastRequirement")
  public Integer getTotalMastRequirement() {
    return totalMastRequirement;
  }

  public void setTotalMastRequirement(Integer totalMastRequirement) {
    this.totalMastRequirement = totalMastRequirement;
  }

  public MastAnchorageDetailsDto location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   */
  
  @Schema(name = "location", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("location")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public MastAnchorageDetailsDto presentBuildingHeight(String presentBuildingHeight) {
    this.presentBuildingHeight = presentBuildingHeight;
    return this;
  }

  /**
   * Get presentBuildingHeight
   * @return presentBuildingHeight
   */
  
  @Schema(name = "presentBuildingHeight", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("presentBuildingHeight")
  public String getPresentBuildingHeight() {
    return presentBuildingHeight;
  }

  public void setPresentBuildingHeight(String presentBuildingHeight) {
    this.presentBuildingHeight = presentBuildingHeight;
  }

  public MastAnchorageDetailsDto presentHeightOfHoist(String presentHeightOfHoist) {
    this.presentHeightOfHoist = presentHeightOfHoist;
    return this;
  }

  /**
   * Get presentHeightOfHoist
   * @return presentHeightOfHoist
   */
  
  @Schema(name = "presentHeightOfHoist", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("presentHeightOfHoist")
  public String getPresentHeightOfHoist() {
    return presentHeightOfHoist;
  }

  public void setPresentHeightOfHoist(String presentHeightOfHoist) {
    this.presentHeightOfHoist = presentHeightOfHoist;
  }

  public MastAnchorageDetailsDto remarks(String remarks) {
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

  public MastAnchorageDetailsDto totalBuildingHeight(String totalBuildingHeight) {
    this.totalBuildingHeight = totalBuildingHeight;
    return this;
  }

  /**
   * Get totalBuildingHeight
   * @return totalBuildingHeight
   */
  
  @Schema(name = "totalBuildingHeight", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalBuildingHeight")
  public String getTotalBuildingHeight() {
    return totalBuildingHeight;
  }

  public void setTotalBuildingHeight(String totalBuildingHeight) {
    this.totalBuildingHeight = totalBuildingHeight;
  }

  public MastAnchorageDetailsDto status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public MastAnchorageDetailsDto project(ProjectSummaryDto project) {
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

  public MastAnchorageDetailsDto equipment(EquipmentSummaryDto equipment) {
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
    MastAnchorageDetailsDto mastAnchorageDetailsDto = (MastAnchorageDetailsDto) o;
    return Objects.equals(this.id, mastAnchorageDetailsDto.id) &&
        Objects.equals(this.anchorageAtSite, mastAnchorageDetailsDto.anchorageAtSite) &&
        Objects.equals(this.anchorageFixedAtSite, mastAnchorageDetailsDto.anchorageFixedAtSite) &&
        Objects.equals(this.anchorageIdleAtSite, mastAnchorageDetailsDto.anchorageIdleAtSite) &&
        Objects.equals(this.mastAvailableAtSite, mastAnchorageDetailsDto.mastAvailableAtSite) &&
        Objects.equals(this.mastFixedAtSite, mastAnchorageDetailsDto.mastFixedAtSite) &&
        Objects.equals(this.mastIdleAtSite, mastAnchorageDetailsDto.mastIdleAtSite) &&
        Objects.equals(this.totalAnchorageRequirement, mastAnchorageDetailsDto.totalAnchorageRequirement) &&
        Objects.equals(this.totalMastRequirement, mastAnchorageDetailsDto.totalMastRequirement) &&
        Objects.equals(this.location, mastAnchorageDetailsDto.location) &&
        Objects.equals(this.presentBuildingHeight, mastAnchorageDetailsDto.presentBuildingHeight) &&
        Objects.equals(this.presentHeightOfHoist, mastAnchorageDetailsDto.presentHeightOfHoist) &&
        Objects.equals(this.remarks, mastAnchorageDetailsDto.remarks) &&
        Objects.equals(this.totalBuildingHeight, mastAnchorageDetailsDto.totalBuildingHeight) &&
        Objects.equals(this.status, mastAnchorageDetailsDto.status) &&
        Objects.equals(this.project, mastAnchorageDetailsDto.project) &&
        Objects.equals(this.equipment, mastAnchorageDetailsDto.equipment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, anchorageAtSite, anchorageFixedAtSite, anchorageIdleAtSite, mastAvailableAtSite, mastFixedAtSite, mastIdleAtSite, totalAnchorageRequirement, totalMastRequirement, location, presentBuildingHeight, presentHeightOfHoist, remarks, totalBuildingHeight, status, project, equipment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MastAnchorageDetailsDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    anchorageAtSite: ").append(toIndentedString(anchorageAtSite)).append("\n");
    sb.append("    anchorageFixedAtSite: ").append(toIndentedString(anchorageFixedAtSite)).append("\n");
    sb.append("    anchorageIdleAtSite: ").append(toIndentedString(anchorageIdleAtSite)).append("\n");
    sb.append("    mastAvailableAtSite: ").append(toIndentedString(mastAvailableAtSite)).append("\n");
    sb.append("    mastFixedAtSite: ").append(toIndentedString(mastFixedAtSite)).append("\n");
    sb.append("    mastIdleAtSite: ").append(toIndentedString(mastIdleAtSite)).append("\n");
    sb.append("    totalAnchorageRequirement: ").append(toIndentedString(totalAnchorageRequirement)).append("\n");
    sb.append("    totalMastRequirement: ").append(toIndentedString(totalMastRequirement)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    presentBuildingHeight: ").append(toIndentedString(presentBuildingHeight)).append("\n");
    sb.append("    presentHeightOfHoist: ").append(toIndentedString(presentHeightOfHoist)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
    sb.append("    totalBuildingHeight: ").append(toIndentedString(totalBuildingHeight)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
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

