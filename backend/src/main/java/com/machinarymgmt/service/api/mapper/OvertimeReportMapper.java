package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Employee;
import com.machinarymgmt.service.api.data.model.OvertimeReport;

import com.machinarymgmt.service.dto.OvertimeReportDto;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.dto.OvertimeReportListResponse;
import com.machinarymgmt.service.dto.OvertimeReportResponse;

import com.machinarymgmt.service.dto.*;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.math.BigDecimal;
import java.util.List;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {EmployeeMapper.class}
)
public interface OvertimeReportMapper extends MachinaryMgmtMapper {

    OvertimeReportDto toDto(OvertimeReport overtimeReport);
    
    List<OvertimeReportDto> toDtoList(List<OvertimeReport> overtimeReports);

    OvertimeReport toEntity(OvertimeReportRequestDto dto);

    void updateEntityFromDto(OvertimeReportRequestDto dto, @MappingTarget OvertimeReport overtimeReport);
    
    default OvertimeReport fromDtoWithReferences(
            OvertimeReportRequestDto dto,
            Employee employee) {
        OvertimeReport overtimeReport = toEntity(dto);
        overtimeReport.setEmployee(employee);
        return overtimeReport;
    }
    
    default Double mapBigDecimalToDouble(BigDecimal value) {
        return value != null ? value.doubleValue() : null;
    }
    
    default BigDecimal mapDoubleToDecimal(Double value) {
        return value != null ? BigDecimal.valueOf(value) : null;
    }

    OvertimeReportListResponse toDtoList(BaseApiResponse baseApiResponse);
    
    OvertimeReportResponse toOvertimeReportResponse(BaseApiResponse baseApiResponse);

    OvertimeReportListResponse toOvertimeReportListResponse(BaseApiResponse baseApiResponse);

    MachinaryMgmtBaseApiResponse toBaseApiResponse(BaseApiResponse baseApiResponse);

}
