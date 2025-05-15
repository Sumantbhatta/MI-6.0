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
    date = "2025-05-15T11:58:38+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
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

        machineryMaintenanceLog.date( dto.getDate() );
        if ( dto.getStartReading() != null ) {
            machineryMaintenanceLog.startReading( dto.getStartReading().intValue() );
        }
        if ( dto.getCloseReading() != null ) {
            machineryMaintenanceLog.closeReading( dto.getCloseReading().intValue() );
        }
        if ( dto.getServiceHours() != null ) {
            machineryMaintenanceLog.serviceHours( dto.getServiceHours().intValue() );
        }
        machineryMaintenanceLog.serviceDate( dto.getServiceDate() );
        if ( dto.getBalanceForService() != null ) {
            machineryMaintenanceLog.balanceForService( dto.getBalanceForService().intValue() );
        }
        machineryMaintenanceLog.purposeActivities( dto.getPurposeActivities() );
        machineryMaintenanceLog.typeOfMaintenance( dto.getTypeOfMaintenance() );
        machineryMaintenanceLog.breakdownSynopsis( dto.getBreakdownSynopsis() );
        machineryMaintenanceLog.operatorName( dto.getOperatorName() );
        machineryMaintenanceLog.operatorSignature( dto.getOperatorSignature() );
        machineryMaintenanceLog.maintenanceSignature( dto.getMaintenanceSignature() );
        machineryMaintenanceLog.feedback( dto.getFeedback() );
        machineryMaintenanceLog.remarks( dto.getRemarks() );

        return machineryMaintenanceLog.build();
    }

    @Override
    public void updateEntityFromDto(MaintenanceLogRequestDto dto, MachineryMaintenanceLog log) {
        if ( dto == null ) {
            return;
        }

        log.setDate( dto.getDate() );
        if ( dto.getStartReading() != null ) {
            log.setStartReading( dto.getStartReading().intValue() );
        }
        else {
            log.setStartReading( null );
        }
        if ( dto.getCloseReading() != null ) {
            log.setCloseReading( dto.getCloseReading().intValue() );
        }
        else {
            log.setCloseReading( null );
        }
        if ( dto.getServiceHours() != null ) {
            log.setServiceHours( dto.getServiceHours().intValue() );
        }
        else {
            log.setServiceHours( null );
        }
        log.setServiceDate( dto.getServiceDate() );
        if ( dto.getBalanceForService() != null ) {
            log.setBalanceForService( dto.getBalanceForService().intValue() );
        }
        else {
            log.setBalanceForService( null );
        }
        log.setPurposeActivities( dto.getPurposeActivities() );
        log.setTypeOfMaintenance( dto.getTypeOfMaintenance() );
        log.setBreakdownSynopsis( dto.getBreakdownSynopsis() );
        log.setOperatorName( dto.getOperatorName() );
        log.setOperatorSignature( dto.getOperatorSignature() );
        log.setMaintenanceSignature( dto.getMaintenanceSignature() );
        log.setFeedback( dto.getFeedback() );
        log.setRemarks( dto.getRemarks() );
    }

    @Override
    public MaintenanceLogListResponse toMaintenanceLogListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MaintenanceLogListResponse maintenanceLogListResponse = new MaintenanceLogListResponse();

        maintenanceLogListResponse.setRespType( baseApiResponse.getRespType() );
        maintenanceLogListResponse.setMetadata( baseApiResponse.getMetadata() );
        maintenanceLogListResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            maintenanceLogListResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return maintenanceLogListResponse;
    }

    @Override
    public MaintenanceLogResponse toMaintenanceLogResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MaintenanceLogResponse maintenanceLogResponse = new MaintenanceLogResponse();

        maintenanceLogResponse.setRespType( baseApiResponse.getRespType() );
        maintenanceLogResponse.setMetadata( baseApiResponse.getMetadata() );
        maintenanceLogResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            maintenanceLogResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return maintenanceLogResponse;
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
