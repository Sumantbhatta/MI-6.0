package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Equipment;
import com.machinarymgmt.service.api.data.model.MachineryMaintenanceLog;
import com.machinarymgmt.service.dto.EquipmentSummaryDto;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
import com.machinarymgmt.service.dto.MaintenanceLogDto;
import com.machinarymgmt.service.dto.MaintenanceLogListResponse;
import com.machinarymgmt.service.dto.MaintenanceLogRequestDto;
import com.machinarymgmt.service.dto.MaintenanceLogResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T16:53:17+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class MaintenanceLogMapperImpl implements MaintenanceLogMapper {

    @Override
    public MaintenanceLogDto toDto(MachineryMaintenanceLog log) {
        if ( log == null ) {
            return null;
        }

        MaintenanceLogDto maintenanceLogDto = new MaintenanceLogDto();

        maintenanceLogDto.setId( log.getId() );
        maintenanceLogDto.setDate( log.getDate() );
        maintenanceLogDto.setServiceDate( log.getServiceDate() );
        maintenanceLogDto.setBreakdownSynopsis( log.getBreakdownSynopsis() );
        maintenanceLogDto.setFeedback( log.getFeedback() );
        if ( log.getBalanceForService() != null ) {
            maintenanceLogDto.setBalanceForService( log.getBalanceForService().longValue() );
        }
        if ( log.getCloseReading() != null ) {
            maintenanceLogDto.setCloseReading( log.getCloseReading().longValue() );
        }
        if ( log.getServiceHours() != null ) {
            maintenanceLogDto.setServiceHours( log.getServiceHours().longValue() );
        }
        if ( log.getStartReading() != null ) {
            maintenanceLogDto.setStartReading( log.getStartReading().longValue() );
        }
        maintenanceLogDto.setMaintenanceSignature( log.getMaintenanceSignature() );
        maintenanceLogDto.setOperatorSignature( log.getOperatorSignature() );
        maintenanceLogDto.setOperatorName( log.getOperatorName() );
        maintenanceLogDto.setPurposeActivities( log.getPurposeActivities() );
        maintenanceLogDto.setRemarks( log.getRemarks() );
        maintenanceLogDto.setTypeOfMaintenance( log.getTypeOfMaintenance() );
        maintenanceLogDto.setEquipment( equipmentToEquipmentSummaryDto( log.getEquipment() ) );

        return maintenanceLogDto;
    }

    @Override
    public List<MaintenanceLogDto> toDtoList(List<MachineryMaintenanceLog> logs) {
        if ( logs == null ) {
            return null;
        }

        List<MaintenanceLogDto> list = new ArrayList<MaintenanceLogDto>( logs.size() );
        for ( MachineryMaintenanceLog machineryMaintenanceLog : logs ) {
            list.add( toDto( machineryMaintenanceLog ) );
        }

        return list;
    }

    @Override
    public MachineryMaintenanceLog toEntity(MaintenanceLogRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        MachineryMaintenanceLog.MachineryMaintenanceLogBuilder machineryMaintenanceLog = MachineryMaintenanceLog.builder();

        if ( dto.getBalanceForService() != null ) {
            machineryMaintenanceLog.balanceForService( dto.getBalanceForService().intValue() );
        }
        machineryMaintenanceLog.breakdownSynopsis( dto.getBreakdownSynopsis() );
        if ( dto.getCloseReading() != null ) {
            machineryMaintenanceLog.closeReading( dto.getCloseReading().intValue() );
        }
        machineryMaintenanceLog.date( dto.getDate() );
        machineryMaintenanceLog.feedback( dto.getFeedback() );
        machineryMaintenanceLog.maintenanceSignature( dto.getMaintenanceSignature() );
        machineryMaintenanceLog.operatorName( dto.getOperatorName() );
        machineryMaintenanceLog.operatorSignature( dto.getOperatorSignature() );
        machineryMaintenanceLog.purposeActivities( dto.getPurposeActivities() );
        machineryMaintenanceLog.remarks( dto.getRemarks() );
        machineryMaintenanceLog.serviceDate( dto.getServiceDate() );
        if ( dto.getServiceHours() != null ) {
            machineryMaintenanceLog.serviceHours( dto.getServiceHours().intValue() );
        }
        if ( dto.getStartReading() != null ) {
            machineryMaintenanceLog.startReading( dto.getStartReading().intValue() );
        }
        machineryMaintenanceLog.typeOfMaintenance( dto.getTypeOfMaintenance() );

        return machineryMaintenanceLog.build();
    }

    @Override
    public void updateEntityFromDto(MaintenanceLogRequestDto dto, MachineryMaintenanceLog log) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getBalanceForService() != null ) {
            log.setBalanceForService( dto.getBalanceForService().intValue() );
        }
        else {
            log.setBalanceForService( null );
        }
        log.setBreakdownSynopsis( dto.getBreakdownSynopsis() );
        if ( dto.getCloseReading() != null ) {
            log.setCloseReading( dto.getCloseReading().intValue() );
        }
        else {
            log.setCloseReading( null );
        }
        log.setDate( dto.getDate() );
        log.setFeedback( dto.getFeedback() );
        log.setMaintenanceSignature( dto.getMaintenanceSignature() );
        log.setOperatorName( dto.getOperatorName() );
        log.setOperatorSignature( dto.getOperatorSignature() );
        log.setPurposeActivities( dto.getPurposeActivities() );
        log.setRemarks( dto.getRemarks() );
        log.setServiceDate( dto.getServiceDate() );
        if ( dto.getServiceHours() != null ) {
            log.setServiceHours( dto.getServiceHours().intValue() );
        }
        else {
            log.setServiceHours( null );
        }
        if ( dto.getStartReading() != null ) {
            log.setStartReading( dto.getStartReading().intValue() );
        }
        else {
            log.setStartReading( null );
        }
        log.setTypeOfMaintenance( dto.getTypeOfMaintenance() );
    }

    @Override
    public MaintenanceLogListResponse toMaintenanceLogListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MaintenanceLogListResponse maintenanceLogListResponse = new MaintenanceLogListResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            maintenanceLogListResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        maintenanceLogListResponse.metadata( baseApiResponse.getMetadata() );
        maintenanceLogListResponse.respType( baseApiResponse.getRespType() );
        maintenanceLogListResponse.status( baseApiResponse.getStatus() );

        return maintenanceLogListResponse;
    }

    @Override
    public MaintenanceLogResponse toMaintenanceLogResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MaintenanceLogResponse maintenanceLogResponse = new MaintenanceLogResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            maintenanceLogResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        maintenanceLogResponse.metadata( baseApiResponse.getMetadata() );
        maintenanceLogResponse.respType( baseApiResponse.getRespType() );
        maintenanceLogResponse.status( baseApiResponse.getStatus() );

        return maintenanceLogResponse;
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

    protected EquipmentSummaryDto equipmentToEquipmentSummaryDto(Equipment equipment) {
        if ( equipment == null ) {
            return null;
        }

        EquipmentSummaryDto equipmentSummaryDto = new EquipmentSummaryDto();

        equipmentSummaryDto.setId( equipment.getId() );
        equipmentSummaryDto.setName( equipment.getName() );

        return equipmentSummaryDto;
    }
}
