package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Equipment;
import com.machinarymgmt.service.api.data.model.IncidentReport;
import com.machinarymgmt.service.api.data.model.Project;
import com.machinarymgmt.service.dto.EquipmentSummaryDto;
import com.machinarymgmt.service.dto.IncidentReportDto;
import com.machinarymgmt.service.dto.IncidentReportListResponse;
import com.machinarymgmt.service.dto.IncidentReportRequestDto;
import com.machinarymgmt.service.dto.IncidentReportResponse;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
import com.machinarymgmt.service.dto.ProjectSummaryDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T14:35:35+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class IncidentReportMapperImpl implements IncidentReportMapper {

    @Override
    public IncidentReportDto toDto(IncidentReport incidentReport) {
        if ( incidentReport == null ) {
            return null;
        }

        IncidentReportDto incidentReportDto = new IncidentReportDto();

        incidentReportDto.setId( incidentReport.getId() );
        incidentReportDto.setIncidentDate( incidentReport.getIncidentDate() );
        incidentReportDto.setClosedDate( incidentReport.getClosedDate() );
        incidentReportDto.setEstimatedCompletionDate( incidentReport.getEstimatedCompletionDate() );
        incidentReportDto.setIncidentType( incidentTypeToIncidentTypeEnum( incidentReport.getIncidentType() ) );
        incidentReportDto.setActionTaken( incidentReport.getActionTaken() );
        incidentReportDto.setIncidentDetails( incidentReport.getIncidentDetails() );
        incidentReportDto.setStatus( statusToStatusEnum( incidentReport.getStatus() ) );
        incidentReportDto.setEquipment( equipmentToEquipmentSummaryDto( incidentReport.getEquipment() ) );
        incidentReportDto.setProject( projectToProjectSummaryDto( incidentReport.getProject() ) );

        return incidentReportDto;
    }

    @Override
    public List<IncidentReportDto> toDtoList(List<IncidentReport> incidentReports) {
        if ( incidentReports == null ) {
            return null;
        }

        List<IncidentReportDto> list = new ArrayList<IncidentReportDto>( incidentReports.size() );
        for ( IncidentReport incidentReport : incidentReports ) {
            list.add( toDto( incidentReport ) );
        }

        return list;
    }

    @Override
    public IncidentReport toEntity(IncidentReportRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        IncidentReport.IncidentReportBuilder incidentReport = IncidentReport.builder();

        incidentReport.incidentType( incidentTypeEnumToIncidentType( dto.getIncidentType() ) );
        incidentReport.incidentDetails( dto.getIncidentDetails() );
        incidentReport.incidentDate( dto.getIncidentDate() );
        incidentReport.actionTaken( dto.getActionTaken() );
        incidentReport.estimatedCompletionDate( dto.getEstimatedCompletionDate() );
        incidentReport.closedDate( dto.getClosedDate() );
        incidentReport.status( statusEnumToStatus( dto.getStatus() ) );

        return incidentReport.build();
    }

    @Override
    public MachinaryMgmtBaseApiResponse toBaseApiResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MachinaryMgmtBaseApiResponse machinaryMgmtBaseApiResponse = new MachinaryMgmtBaseApiResponse();

        machinaryMgmtBaseApiResponse.setRespType( baseApiResponse.getRespType() );
        machinaryMgmtBaseApiResponse.setMetadata( baseApiResponse.getMetadata() );
        machinaryMgmtBaseApiResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            machinaryMgmtBaseApiResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return machinaryMgmtBaseApiResponse;
    }

    @Override
    public void updateIncidentReportFromDto(IncidentReportRequestDto dto, IncidentReport incidentReport) {
        if ( dto == null ) {
            return;
        }

        incidentReport.setIncidentType( incidentTypeEnumToIncidentType( dto.getIncidentType() ) );
        incidentReport.setIncidentDetails( dto.getIncidentDetails() );
        incidentReport.setIncidentDate( dto.getIncidentDate() );
        incidentReport.setActionTaken( dto.getActionTaken() );
        incidentReport.setEstimatedCompletionDate( dto.getEstimatedCompletionDate() );
        incidentReport.setClosedDate( dto.getClosedDate() );
        incidentReport.setStatus( statusEnumToStatus( dto.getStatus() ) );
    }

    @Override
    public IncidentReportResponse toIncidentReportResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        IncidentReportResponse incidentReportResponse = new IncidentReportResponse();

        incidentReportResponse.setRespType( baseApiResponse.getRespType() );
        incidentReportResponse.setMetadata( baseApiResponse.getMetadata() );
        incidentReportResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            incidentReportResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return incidentReportResponse;
    }

    @Override
    public void updateEntityFromDto(IncidentReportRequestDto dto, IncidentReport incidentReport) {
        if ( dto == null ) {
            return;
        }

        incidentReport.setIncidentType( incidentTypeEnumToIncidentType( dto.getIncidentType() ) );
        incidentReport.setIncidentDetails( dto.getIncidentDetails() );
        incidentReport.setIncidentDate( dto.getIncidentDate() );
        incidentReport.setActionTaken( dto.getActionTaken() );
        incidentReport.setEstimatedCompletionDate( dto.getEstimatedCompletionDate() );
        incidentReport.setClosedDate( dto.getClosedDate() );
        incidentReport.setStatus( statusEnumToStatus( dto.getStatus() ) );
    }

    @Override
    public IncidentReportListResponse toDtoList(BaseApiResponse successApiResponse) {
        if ( successApiResponse == null ) {
            return null;
        }

        IncidentReportListResponse incidentReportListResponse = new IncidentReportListResponse();

        incidentReportListResponse.setRespType( successApiResponse.getRespType() );
        incidentReportListResponse.setMetadata( successApiResponse.getMetadata() );
        incidentReportListResponse.setStatus( successApiResponse.getStatus() );
        List<ApiMessage> list = successApiResponse.getMessages();
        if ( list != null ) {
            incidentReportListResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return incidentReportListResponse;
    }

    protected IncidentReportDto.IncidentTypeEnum incidentTypeToIncidentTypeEnum(IncidentReport.IncidentType incidentType) {
        if ( incidentType == null ) {
            return null;
        }

        IncidentReportDto.IncidentTypeEnum incidentTypeEnum;

        switch ( incidentType ) {
            case MECHANICAL_FAILURE: incidentTypeEnum = IncidentReportDto.IncidentTypeEnum.MECHANICAL_FAILURE;
            break;
            case ELECTRICAL_FAILURE: incidentTypeEnum = IncidentReportDto.IncidentTypeEnum.ELECTRICAL_FAILURE;
            break;
            case MAINTENANCE_ISSUE: incidentTypeEnum = IncidentReportDto.IncidentTypeEnum.MAINTENANCE_ISSUE;
            break;
            case OPERATOR_ERROR: incidentTypeEnum = IncidentReportDto.IncidentTypeEnum.OPERATOR_ERROR;
            break;
            case SAFETY_NEAR_MISS: incidentTypeEnum = IncidentReportDto.IncidentTypeEnum.SAFETY_NEAR_MISS;
            break;
            case UNAUTHORIZED_USE: incidentTypeEnum = IncidentReportDto.IncidentTypeEnum.UNAUTHORIZED_USE;
            break;
            case ENVIRONMENTAL_DAMAGE: incidentTypeEnum = IncidentReportDto.IncidentTypeEnum.ENVIRONMENTAL_DAMAGE;
            break;
            case STRUCTURAL_FAILURE: incidentTypeEnum = IncidentReportDto.IncidentTypeEnum.STRUCTURAL_FAILURE;
            break;
            case PERFORMANCE_ISSUE: incidentTypeEnum = IncidentReportDto.IncidentTypeEnum.PERFORMANCE_ISSUE;
            break;
            case COMPLIANCE_BREACH: incidentTypeEnum = IncidentReportDto.IncidentTypeEnum.COMPLIANCE_BREACH;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + incidentType );
        }

        return incidentTypeEnum;
    }

    protected IncidentReportDto.StatusEnum statusToStatusEnum(IncidentReport.Status status) {
        if ( status == null ) {
            return null;
        }

        IncidentReportDto.StatusEnum statusEnum;

        switch ( status ) {
            case OPEN: statusEnum = IncidentReportDto.StatusEnum.OPEN;
            break;
            case IN_PROGRESS: statusEnum = IncidentReportDto.StatusEnum.IN_PROGRESS;
            break;
            case RESOLVED: statusEnum = IncidentReportDto.StatusEnum.RESOLVED;
            break;
            case CLOSED: statusEnum = IncidentReportDto.StatusEnum.CLOSED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + status );
        }

        return statusEnum;
    }

    protected EquipmentSummaryDto equipmentToEquipmentSummaryDto(Equipment equipment) {
        if ( equipment == null ) {
            return null;
        }

        EquipmentSummaryDto equipmentSummaryDto = new EquipmentSummaryDto();

        equipmentSummaryDto.setId( equipment.getId() );
        equipmentSummaryDto.setName( equipment.getName() );

        return equipmentSummaryDto;
    }

    protected ProjectSummaryDto projectToProjectSummaryDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectSummaryDto projectSummaryDto = new ProjectSummaryDto();

        projectSummaryDto.setId( project.getId() );
        projectSummaryDto.setName( project.getName() );

        return projectSummaryDto;
    }

    protected IncidentReport.IncidentType incidentTypeEnumToIncidentType(IncidentReportRequestDto.IncidentTypeEnum incidentTypeEnum) {
        if ( incidentTypeEnum == null ) {
            return null;
        }

        IncidentReport.IncidentType incidentType;

        switch ( incidentTypeEnum ) {
            case MECHANICAL_FAILURE: incidentType = IncidentReport.IncidentType.MECHANICAL_FAILURE;
            break;
            case ELECTRICAL_FAILURE: incidentType = IncidentReport.IncidentType.ELECTRICAL_FAILURE;
            break;
            case MAINTENANCE_ISSUE: incidentType = IncidentReport.IncidentType.MAINTENANCE_ISSUE;
            break;
            case OPERATOR_ERROR: incidentType = IncidentReport.IncidentType.OPERATOR_ERROR;
            break;
            case SAFETY_NEAR_MISS: incidentType = IncidentReport.IncidentType.SAFETY_NEAR_MISS;
            break;
            case UNAUTHORIZED_USE: incidentType = IncidentReport.IncidentType.UNAUTHORIZED_USE;
            break;
            case ENVIRONMENTAL_DAMAGE: incidentType = IncidentReport.IncidentType.ENVIRONMENTAL_DAMAGE;
            break;
            case STRUCTURAL_FAILURE: incidentType = IncidentReport.IncidentType.STRUCTURAL_FAILURE;
            break;
            case PERFORMANCE_ISSUE: incidentType = IncidentReport.IncidentType.PERFORMANCE_ISSUE;
            break;
            case COMPLIANCE_BREACH: incidentType = IncidentReport.IncidentType.COMPLIANCE_BREACH;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + incidentTypeEnum );
        }

        return incidentType;
    }

    protected IncidentReport.Status statusEnumToStatus(IncidentReportRequestDto.StatusEnum statusEnum) {
        if ( statusEnum == null ) {
            return null;
        }

        IncidentReport.Status status;

        switch ( statusEnum ) {
            case OPEN: status = IncidentReport.Status.OPEN;
            break;
            case IN_PROGRESS: status = IncidentReport.Status.IN_PROGRESS;
            break;
            case CLOSED: status = IncidentReport.Status.CLOSED;
            break;
            case RESOLVED: status = IncidentReport.Status.RESOLVED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + statusEnum );
        }

        return status;
    }
}
