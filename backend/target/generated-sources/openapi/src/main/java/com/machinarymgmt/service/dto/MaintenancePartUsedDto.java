package com.machinarymgmt.service.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.machinarymgmt.service.dto.ItemSummaryDto;
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
 * MaintenancePartUsedDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-26T16:53:22.870701700+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class MaintenancePartUsedDto {

  private @Nullable Long id;

  private @Nullable Double quantity;

  private @Nullable ItemSummaryDto item;

  private @Nullable MaintenanceLogSummaryDto maintenanceLog;

  public MaintenancePartUsedDto id(Long id) {
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

  public MaintenancePartUsedDto quantity(Double quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
   */
  
  @Schema(name = "quantity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quantity")
  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public MaintenancePartUsedDto item(ItemSummaryDto item) {
    this.item = item;
    return this;
  }

  /**
   * Get item
   * @return item
   */
  @Valid 
  @Schema(name = "item", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("item")
  public ItemSummaryDto getItem() {
    return item;
  }

  public void setItem(ItemSummaryDto item) {
    this.item = item;
  }

  public MaintenancePartUsedDto maintenanceLog(MaintenanceLogSummaryDto maintenanceLog) {
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
    MaintenancePartUsedDto maintenancePartUsedDto = (MaintenancePartUsedDto) o;
    return Objects.equals(this.id, maintenancePartUsedDto.id) &&
        Objects.equals(this.quantity, maintenancePartUsedDto.quantity) &&
        Objects.equals(this.item, maintenancePartUsedDto.item) &&
        Objects.equals(this.maintenanceLog, maintenancePartUsedDto.maintenanceLog);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, quantity, item, maintenanceLog);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MaintenancePartUsedDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
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

