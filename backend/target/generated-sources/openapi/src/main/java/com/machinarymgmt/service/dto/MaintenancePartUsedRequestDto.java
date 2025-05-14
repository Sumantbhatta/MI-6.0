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
 * MaintenancePartUsedRequestDto
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-13T15:41:51.742519800+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class MaintenancePartUsedRequestDto {

  private @Nullable Long maintenanceLogId;

  private @Nullable Long itemId;

  private @Nullable Double quantity;

  public MaintenancePartUsedRequestDto maintenanceLogId(Long maintenanceLogId) {
    this.maintenanceLogId = maintenanceLogId;
    return this;
  }

  /**
   * Get maintenanceLogId
   * @return maintenanceLogId
   */
  
  @Schema(name = "maintenanceLogId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maintenanceLogId")
  public Long getMaintenanceLogId() {
    return maintenanceLogId;
  }

  public void setMaintenanceLogId(Long maintenanceLogId) {
    this.maintenanceLogId = maintenanceLogId;
  }

  public MaintenancePartUsedRequestDto itemId(Long itemId) {
    this.itemId = itemId;
    return this;
  }

  /**
   * Get itemId
   * @return itemId
   */
  
  @Schema(name = "itemId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("itemId")
  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public MaintenancePartUsedRequestDto quantity(Double quantity) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MaintenancePartUsedRequestDto maintenancePartUsedRequestDto = (MaintenancePartUsedRequestDto) o;
    return Objects.equals(this.maintenanceLogId, maintenancePartUsedRequestDto.maintenanceLogId) &&
        Objects.equals(this.itemId, maintenancePartUsedRequestDto.itemId) &&
        Objects.equals(this.quantity, maintenancePartUsedRequestDto.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maintenanceLogId, itemId, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MaintenancePartUsedRequestDto {\n");
    sb.append("    maintenanceLogId: ").append(toIndentedString(maintenanceLogId)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
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

