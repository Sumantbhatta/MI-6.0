package com.machinarymgmt.service.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.machinarymgmt.service.dto.MaintenanceLogSummaryDto;
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
 * MaintenanceReadingDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-26T16:53:22.870701700+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class MaintenanceReadingDto {

  private @Nullable Long id;

  private @Nullable Long airPressure;

  private @Nullable Long engineOil;

  private @Nullable Long engineTemperature;

  private @Nullable Long gearOil;

  private @Nullable Long greaseUsed;

  private @Nullable Long hsdUsed;

  private @Nullable Long hydraulicOil;

  private @Nullable Long hydraulicTemperature;

  private @Nullable Long oilPressure;

  private @Nullable MaintenanceLogSummaryDto maintenanceLog;

  public MaintenanceReadingDto id(Long id) {
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

  public MaintenanceReadingDto airPressure(Long airPressure) {
    this.airPressure = airPressure;
    return this;
  }

  /**
   * Get airPressure
   * @return airPressure
   */
  
  @Schema(name = "airPressure", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("airPressure")
  public Long getAirPressure() {
    return airPressure;
  }

  public void setAirPressure(Long airPressure) {
    this.airPressure = airPressure;
  }

  public MaintenanceReadingDto engineOil(Long engineOil) {
    this.engineOil = engineOil;
    return this;
  }

  /**
   * Get engineOil
   * @return engineOil
   */
  
  @Schema(name = "engineOil", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("engineOil")
  public Long getEngineOil() {
    return engineOil;
  }

  public void setEngineOil(Long engineOil) {
    this.engineOil = engineOil;
  }

  public MaintenanceReadingDto engineTemperature(Long engineTemperature) {
    this.engineTemperature = engineTemperature;
    return this;
  }

  /**
   * Get engineTemperature
   * @return engineTemperature
   */
  
  @Schema(name = "engineTemperature", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("engineTemperature")
  public Long getEngineTemperature() {
    return engineTemperature;
  }

  public void setEngineTemperature(Long engineTemperature) {
    this.engineTemperature = engineTemperature;
  }

  public MaintenanceReadingDto gearOil(Long gearOil) {
    this.gearOil = gearOil;
    return this;
  }

  /**
   * Get gearOil
   * @return gearOil
   */
  
  @Schema(name = "gearOil", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("gearOil")
  public Long getGearOil() {
    return gearOil;
  }

  public void setGearOil(Long gearOil) {
    this.gearOil = gearOil;
  }

  public MaintenanceReadingDto greaseUsed(Long greaseUsed) {
    this.greaseUsed = greaseUsed;
    return this;
  }

  /**
   * Get greaseUsed
   * @return greaseUsed
   */
  
  @Schema(name = "greaseUsed", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("greaseUsed")
  public Long getGreaseUsed() {
    return greaseUsed;
  }

  public void setGreaseUsed(Long greaseUsed) {
    this.greaseUsed = greaseUsed;
  }

  public MaintenanceReadingDto hsdUsed(Long hsdUsed) {
    this.hsdUsed = hsdUsed;
    return this;
  }

  /**
   * Get hsdUsed
   * @return hsdUsed
   */
  
  @Schema(name = "hsdUsed", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hsdUsed")
  public Long getHsdUsed() {
    return hsdUsed;
  }

  public void setHsdUsed(Long hsdUsed) {
    this.hsdUsed = hsdUsed;
  }

  public MaintenanceReadingDto hydraulicOil(Long hydraulicOil) {
    this.hydraulicOil = hydraulicOil;
    return this;
  }

  /**
   * Get hydraulicOil
   * @return hydraulicOil
   */
  
  @Schema(name = "hydraulicOil", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hydraulicOil")
  public Long getHydraulicOil() {
    return hydraulicOil;
  }

  public void setHydraulicOil(Long hydraulicOil) {
    this.hydraulicOil = hydraulicOil;
  }

  public MaintenanceReadingDto hydraulicTemperature(Long hydraulicTemperature) {
    this.hydraulicTemperature = hydraulicTemperature;
    return this;
  }

  /**
   * Get hydraulicTemperature
   * @return hydraulicTemperature
   */
  
  @Schema(name = "hydraulicTemperature", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hydraulicTemperature")
  public Long getHydraulicTemperature() {
    return hydraulicTemperature;
  }

  public void setHydraulicTemperature(Long hydraulicTemperature) {
    this.hydraulicTemperature = hydraulicTemperature;
  }

  public MaintenanceReadingDto oilPressure(Long oilPressure) {
    this.oilPressure = oilPressure;
    return this;
  }

  /**
   * Get oilPressure
   * @return oilPressure
   */
  
  @Schema(name = "oilPressure", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("oilPressure")
  public Long getOilPressure() {
    return oilPressure;
  }

  public void setOilPressure(Long oilPressure) {
    this.oilPressure = oilPressure;
  }

  public MaintenanceReadingDto maintenanceLog(MaintenanceLogSummaryDto maintenanceLog) {
    this.maintenanceLog = maintenanceLog;
    return this;
  }

  /**
   * Get maintenanceLog
   * @return maintenanceLog
   */
  @Valid 
  @Schema(name = "maintenanceLog", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maintenanceLog")
  public MaintenanceLogSummaryDto getMaintenanceLog() {
    return maintenanceLog;
  }

  public void setMaintenanceLog(MaintenanceLogSummaryDto maintenanceLog) {
    this.maintenanceLog = maintenanceLog;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MaintenanceReadingDto maintenanceReadingDto = (MaintenanceReadingDto) o;
    return Objects.equals(this.id, maintenanceReadingDto.id) &&
        Objects.equals(this.airPressure, maintenanceReadingDto.airPressure) &&
        Objects.equals(this.engineOil, maintenanceReadingDto.engineOil) &&
        Objects.equals(this.engineTemperature, maintenanceReadingDto.engineTemperature) &&
        Objects.equals(this.gearOil, maintenanceReadingDto.gearOil) &&
        Objects.equals(this.greaseUsed, maintenanceReadingDto.greaseUsed) &&
        Objects.equals(this.hsdUsed, maintenanceReadingDto.hsdUsed) &&
        Objects.equals(this.hydraulicOil, maintenanceReadingDto.hydraulicOil) &&
        Objects.equals(this.hydraulicTemperature, maintenanceReadingDto.hydraulicTemperature) &&
        Objects.equals(this.oilPressure, maintenanceReadingDto.oilPressure) &&
        Objects.equals(this.maintenanceLog, maintenanceReadingDto.maintenanceLog);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, airPressure, engineOil, engineTemperature, gearOil, greaseUsed, hsdUsed, hydraulicOil, hydraulicTemperature, oilPressure, maintenanceLog);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MaintenanceReadingDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    airPressure: ").append(toIndentedString(airPressure)).append("\n");
    sb.append("    engineOil: ").append(toIndentedString(engineOil)).append("\n");
    sb.append("    engineTemperature: ").append(toIndentedString(engineTemperature)).append("\n");
    sb.append("    gearOil: ").append(toIndentedString(gearOil)).append("\n");
    sb.append("    greaseUsed: ").append(toIndentedString(greaseUsed)).append("\n");
    sb.append("    hsdUsed: ").append(toIndentedString(hsdUsed)).append("\n");
    sb.append("    hydraulicOil: ").append(toIndentedString(hydraulicOil)).append("\n");
    sb.append("    hydraulicTemperature: ").append(toIndentedString(hydraulicTemperature)).append("\n");
    sb.append("    oilPressure: ").append(toIndentedString(oilPressure)).append("\n");
    sb.append("    maintenanceLog: ").append(toIndentedString(maintenanceLog)).append("\n");
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

