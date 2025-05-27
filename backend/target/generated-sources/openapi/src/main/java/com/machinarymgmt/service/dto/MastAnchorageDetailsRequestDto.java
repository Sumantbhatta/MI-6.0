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
 * MastAnchorageDetailsRequestDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-27T12:57:30.564361800+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class MastAnchorageDetailsRequestDto {

  private @Nullable Long projectId;

  private @Nullable Long equipmentId;

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

  public MastAnchorageDetailsRequestDto projectId(Long projectId) {
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

  public MastAnchorageDetailsRequestDto equipmentId(Long equipmentId) {
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

  public MastAnchorageDetailsRequestDto anchorageAtSite(Integer anchorageAtSite) {
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

  public MastAnchorageDetailsRequestDto anchorageFixedAtSite(Integer anchorageFixedAtSite) {
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

  public MastAnchorageDetailsRequestDto anchorageIdleAtSite(Integer anchorageIdleAtSite) {
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

  public MastAnchorageDetailsRequestDto mastAvailableAtSite(Integer mastAvailableAtSite) {
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

  public MastAnchorageDetailsRequestDto mastFixedAtSite(Integer mastFixedAtSite) {
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

  public MastAnchorageDetailsRequestDto mastIdleAtSite(Integer mastIdleAtSite) {
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

  public MastAnchorageDetailsRequestDto totalAnchorageRequirement(Integer totalAnchorageRequirement) {
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

  public MastAnchorageDetailsRequestDto totalMastRequirement(Integer totalMastRequirement) {
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

  public MastAnchorageDetailsRequestDto location(String location) {
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

  public MastAnchorageDetailsRequestDto presentBuildingHeight(String presentBuildingHeight) {
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

  public MastAnchorageDetailsRequestDto presentHeightOfHoist(String presentHeightOfHoist) {
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

  public MastAnchorageDetailsRequestDto remarks(String remarks) {
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

  public MastAnchorageDetailsRequestDto totalBuildingHeight(String totalBuildingHeight) {
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

  public MastAnchorageDetailsRequestDto status(String status) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MastAnchorageDetailsRequestDto mastAnchorageDetailsRequestDto = (MastAnchorageDetailsRequestDto) o;
    return Objects.equals(this.projectId, mastAnchorageDetailsRequestDto.projectId) &&
        Objects.equals(this.equipmentId, mastAnchorageDetailsRequestDto.equipmentId) &&
        Objects.equals(this.anchorageAtSite, mastAnchorageDetailsRequestDto.anchorageAtSite) &&
        Objects.equals(this.anchorageFixedAtSite, mastAnchorageDetailsRequestDto.anchorageFixedAtSite) &&
        Objects.equals(this.anchorageIdleAtSite, mastAnchorageDetailsRequestDto.anchorageIdleAtSite) &&
        Objects.equals(this.mastAvailableAtSite, mastAnchorageDetailsRequestDto.mastAvailableAtSite) &&
        Objects.equals(this.mastFixedAtSite, mastAnchorageDetailsRequestDto.mastFixedAtSite) &&
        Objects.equals(this.mastIdleAtSite, mastAnchorageDetailsRequestDto.mastIdleAtSite) &&
        Objects.equals(this.totalAnchorageRequirement, mastAnchorageDetailsRequestDto.totalAnchorageRequirement) &&
        Objects.equals(this.totalMastRequirement, mastAnchorageDetailsRequestDto.totalMastRequirement) &&
        Objects.equals(this.location, mastAnchorageDetailsRequestDto.location) &&
        Objects.equals(this.presentBuildingHeight, mastAnchorageDetailsRequestDto.presentBuildingHeight) &&
        Objects.equals(this.presentHeightOfHoist, mastAnchorageDetailsRequestDto.presentHeightOfHoist) &&
        Objects.equals(this.remarks, mastAnchorageDetailsRequestDto.remarks) &&
        Objects.equals(this.totalBuildingHeight, mastAnchorageDetailsRequestDto.totalBuildingHeight) &&
        Objects.equals(this.status, mastAnchorageDetailsRequestDto.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectId, equipmentId, anchorageAtSite, anchorageFixedAtSite, anchorageIdleAtSite, mastAvailableAtSite, mastFixedAtSite, mastIdleAtSite, totalAnchorageRequirement, totalMastRequirement, location, presentBuildingHeight, presentHeightOfHoist, remarks, totalBuildingHeight, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MastAnchorageDetailsRequestDto {\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    equipmentId: ").append(toIndentedString(equipmentId)).append("\n");
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

