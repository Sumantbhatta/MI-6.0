package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Employee;
import com.machinarymgmt.service.api.data.model.OvertimeReport;
import com.machinarymgmt.service.dto.EmployeeSummaryDto;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
import com.machinarymgmt.service.dto.OvertimeReportDto;
import com.machinarymgmt.service.dto.OvertimeReportListResponse;
import com.machinarymgmt.service.dto.OvertimeReportRequestDto;
import com.machinarymgmt.service.dto.OvertimeReportResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T16:53:16+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class OvertimeReportMapperImpl implements OvertimeReportMapper {

    @Override
    public OvertimeReportDto toDto(OvertimeReport overtimeReport) {
        if ( overtimeReport == null ) {
            return null;
        }

        OvertimeReportDto overtimeReportDto = new OvertimeReportDto();

        overtimeReportDto.setId( overtimeReport.getId() );
        overtimeReportDto.setDate( overtimeReport.getDate() );
        overtimeReportDto.setEmployee( employeeToEmployeeSummaryDto( overtimeReport.getEmployee() ) );
        overtimeReportDto.setPresentDays( overtimeReport.getPresentDays() );
        overtimeReportDto.setOtHours( mapBigDecimalToDouble( overtimeReport.getOtHours() ) );
        overtimeReportDto.setRemarks( overtimeReport.getRemarks() );

        return overtimeReportDto;
    }

    @Override
    public List<OvertimeReportDto> toDtoList(List<OvertimeReport> overtimeReports) {
        if ( overtimeReports == null ) {
            return null;
        }

        List<OvertimeReportDto> list = new ArrayList<OvertimeReportDto>( overtimeReports.size() );
        for ( OvertimeReport overtimeReport : overtimeReports ) {
            list.add( toDto( overtimeReport ) );
        }

        return list;
    }

    @Override
    public OvertimeReport toEntity(OvertimeReportRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        OvertimeReport.OvertimeReportBuilder overtimeReport = OvertimeReport.builder();

        overtimeReport.date( dto.getDate() );
        overtimeReport.otHours( mapDoubleToDecimal( dto.getOtHours() ) );
        overtimeReport.presentDays( dto.getPresentDays() );
        overtimeReport.remarks( dto.getRemarks() );

        return overtimeReport.build();
    }

    @Override
    public void updateEntityFromDto(OvertimeReportRequestDto dto, OvertimeReport overtimeReport) {
        if ( dto == null ) {
            return;
        }

        overtimeReport.setDate( dto.getDate() );
        overtimeReport.setOtHours( mapDoubleToDecimal( dto.getOtHours() ) );
        overtimeReport.setPresentDays( dto.getPresentDays() );
        overtimeReport.setRemarks( dto.getRemarks() );
    }

    @Override
    public OvertimeReportListResponse toDtoList(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        OvertimeReportListResponse overtimeReportListResponse = new OvertimeReportListResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            overtimeReportListResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        overtimeReportListResponse.metadata( baseApiResponse.getMetadata() );
        overtimeReportListResponse.respType( baseApiResponse.getRespType() );
        overtimeReportListResponse.status( baseApiResponse.getStatus() );

        return overtimeReportListResponse;
    }

    @Override
    public OvertimeReportResponse toOvertimeReportResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        OvertimeReportResponse overtimeReportResponse = new OvertimeReportResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            overtimeReportResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        overtimeReportResponse.metadata( baseApiResponse.getMetadata() );
        overtimeReportResponse.respType( baseApiResponse.getRespType() );
        overtimeReportResponse.status( baseApiResponse.getStatus() );

        return overtimeReportResponse;
    }

    @Override
    public OvertimeReportListResponse toOvertimeReportListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        OvertimeReportListResponse overtimeReportListResponse = new OvertimeReportListResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            overtimeReportListResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        overtimeReportListResponse.metadata( baseApiResponse.getMetadata() );
        overtimeReportListResponse.respType( baseApiResponse.getRespType() );
        overtimeReportListResponse.status( baseApiResponse.getStatus() );

        return overtimeReportListResponse;
    }

    @Override
    public MachinaryMgmtBaseApiResponse toBaseApiResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MachinaryMgmtBaseApiResponse machinaryMgmtBaseApiResponse = new MachinaryMgmtBaseApiResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            machinaryMgmtBaseApiResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        machinaryMgmtBaseApiResponse.metadata( baseApiResponse.getMetadata() );
        machinaryMgmtBaseApiResponse.respType( baseApiResponse.getRespType() );
        machinaryMgmtBaseApiResponse.status( baseApiResponse.getStatus() );

        return machinaryMgmtBaseApiResponse;
    }

    protected EmployeeSummaryDto employeeToEmployeeSummaryDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeSummaryDto employeeSummaryDto = new EmployeeSummaryDto();

        employeeSummaryDto.setId( employee.getId() );
        employeeSummaryDto.setName( employee.getName() );

        return employeeSummaryDto;
    }
}
