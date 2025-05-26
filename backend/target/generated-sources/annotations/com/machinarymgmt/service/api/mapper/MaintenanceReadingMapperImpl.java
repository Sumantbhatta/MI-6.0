package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.MachineryMaintenanceLog;
import com.machinarymgmt.service.api.data.model.MaintenanceReading;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
import com.machinarymgmt.service.dto.MaintenanceLogSummaryDto;
import com.machinarymgmt.service.dto.MaintenanceReadingDto;
import com.machinarymgmt.service.dto.MaintenanceReadingListResponse;
import com.machinarymgmt.service.dto.MaintenanceReadingRequestDto;
import com.machinarymgmt.service.dto.MaintenanceReadingResponse;
import java.math.BigDecimal;
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
public class MaintenanceReadingMapperImpl implements MaintenanceReadingMapper {

    @Override
    public MaintenanceReadingDto toDto(MaintenanceReading reading) {
        if ( reading == null ) {
            return null;
        }

        MaintenanceReadingDto maintenanceReadingDto = new MaintenanceReadingDto();

        maintenanceReadingDto.setId( reading.getId() );
        if ( reading.getAirPressure() != null ) {
            maintenanceReadingDto.setAirPressure( reading.getAirPressure().longValue() );
        }
        if ( reading.getEngineOil() != null ) {
            maintenanceReadingDto.setEngineOil( reading.getEngineOil().longValue() );
        }
        if ( reading.getEngineTemperature() != null ) {
            maintenanceReadingDto.setEngineTemperature( reading.getEngineTemperature().longValue() );
        }
        if ( reading.getGearOil() != null ) {
            maintenanceReadingDto.setGearOil( reading.getGearOil().longValue() );
        }
        if ( reading.getGreaseUsed() != null ) {
            maintenanceReadingDto.setGreaseUsed( reading.getGreaseUsed().longValue() );
        }
        if ( reading.getHsdUsed() != null ) {
            maintenanceReadingDto.setHsdUsed( reading.getHsdUsed().longValue() );
        }
        if ( reading.getHydraulicOil() != null ) {
            maintenanceReadingDto.setHydraulicOil( reading.getHydraulicOil().longValue() );
        }
        if ( reading.getHydraulicTemperature() != null ) {
            maintenanceReadingDto.setHydraulicTemperature( reading.getHydraulicTemperature().longValue() );
        }
        if ( reading.getOilPressure() != null ) {
            maintenanceReadingDto.setOilPressure( reading.getOilPressure().longValue() );
        }
        maintenanceReadingDto.setMaintenanceLog( machineryMaintenanceLogToMaintenanceLogSummaryDto( reading.getMaintenanceLog() ) );

        return maintenanceReadingDto;
    }

    @Override
    public MaintenanceReading toEntity(MaintenanceReadingRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        MaintenanceReading.MaintenanceReadingBuilder maintenanceReading = MaintenanceReading.builder();

        if ( dto.getAirPressure() != null ) {
            maintenanceReading.airPressure( BigDecimal.valueOf( dto.getAirPressure() ) );
        }
        if ( dto.getEngineOil() != null ) {
            maintenanceReading.engineOil( BigDecimal.valueOf( dto.getEngineOil() ) );
        }
        if ( dto.getEngineTemperature() != null ) {
            maintenanceReading.engineTemperature( BigDecimal.valueOf( dto.getEngineTemperature() ) );
        }
        if ( dto.getGearOil() != null ) {
            maintenanceReading.gearOil( BigDecimal.valueOf( dto.getGearOil() ) );
        }
        if ( dto.getGreaseUsed() != null ) {
            maintenanceReading.greaseUsed( BigDecimal.valueOf( dto.getGreaseUsed() ) );
        }
        if ( dto.getHsdUsed() != null ) {
            maintenanceReading.hsdUsed( BigDecimal.valueOf( dto.getHsdUsed() ) );
        }
        if ( dto.getHydraulicOil() != null ) {
            maintenanceReading.hydraulicOil( BigDecimal.valueOf( dto.getHydraulicOil() ) );
        }
        if ( dto.getHydraulicTemperature() != null ) {
            maintenanceReading.hydraulicTemperature( BigDecimal.valueOf( dto.getHydraulicTemperature() ) );
        }
        if ( dto.getOilPressure() != null ) {
            maintenanceReading.oilPressure( BigDecimal.valueOf( dto.getOilPressure() ) );
        }

        return maintenanceReading.build();
    }

    @Override
    public List<MaintenanceReadingDto> toDtoList(List<MaintenanceReading> readings) {
        if ( readings == null ) {
            return null;
        }

        List<MaintenanceReadingDto> list = new ArrayList<MaintenanceReadingDto>( readings.size() );
        for ( MaintenanceReading maintenanceReading : readings ) {
            list.add( toDto( maintenanceReading ) );
        }

        return list;
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

    @Override
    public MaintenanceReadingResponse toMaintenanceReadingResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MaintenanceReadingResponse maintenanceReadingResponse = new MaintenanceReadingResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            maintenanceReadingResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        maintenanceReadingResponse.metadata( baseApiResponse.getMetadata() );
        maintenanceReadingResponse.respType( baseApiResponse.getRespType() );
        maintenanceReadingResponse.status( baseApiResponse.getStatus() );

        return maintenanceReadingResponse;
    }

    @Override
    public MaintenanceReadingListResponse toMaintenancereadingListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MaintenanceReadingListResponse maintenanceReadingListResponse = new MaintenanceReadingListResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            maintenanceReadingListResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        maintenanceReadingListResponse.metadata( baseApiResponse.getMetadata() );
        maintenanceReadingListResponse.respType( baseApiResponse.getRespType() );
        maintenanceReadingListResponse.status( baseApiResponse.getStatus() );

        return maintenanceReadingListResponse;
    }

    @Override
    public void updateEntityFromDto(MaintenanceReadingRequestDto dto, MaintenanceReading log) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getAirPressure() != null ) {
            log.setAirPressure( BigDecimal.valueOf( dto.getAirPressure() ) );
        }
        else {
            log.setAirPressure( null );
        }
        if ( dto.getEngineOil() != null ) {
            log.setEngineOil( BigDecimal.valueOf( dto.getEngineOil() ) );
        }
        else {
            log.setEngineOil( null );
        }
        if ( dto.getEngineTemperature() != null ) {
            log.setEngineTemperature( BigDecimal.valueOf( dto.getEngineTemperature() ) );
        }
        else {
            log.setEngineTemperature( null );
        }
        if ( dto.getGearOil() != null ) {
            log.setGearOil( BigDecimal.valueOf( dto.getGearOil() ) );
        }
        else {
            log.setGearOil( null );
        }
        if ( dto.getGreaseUsed() != null ) {
            log.setGreaseUsed( BigDecimal.valueOf( dto.getGreaseUsed() ) );
        }
        else {
            log.setGreaseUsed( null );
        }
        if ( dto.getHsdUsed() != null ) {
            log.setHsdUsed( BigDecimal.valueOf( dto.getHsdUsed() ) );
        }
        else {
            log.setHsdUsed( null );
        }
        if ( dto.getHydraulicOil() != null ) {
            log.setHydraulicOil( BigDecimal.valueOf( dto.getHydraulicOil() ) );
        }
        else {
            log.setHydraulicOil( null );
        }
        if ( dto.getHydraulicTemperature() != null ) {
            log.setHydraulicTemperature( BigDecimal.valueOf( dto.getHydraulicTemperature() ) );
        }
        else {
            log.setHydraulicTemperature( null );
        }
        if ( dto.getOilPressure() != null ) {
            log.setOilPressure( BigDecimal.valueOf( dto.getOilPressure() ) );
        }
        else {
            log.setOilPressure( null );
        }
    }

    protected MaintenanceLogSummaryDto machineryMaintenanceLogToMaintenanceLogSummaryDto(MachineryMaintenanceLog machineryMaintenanceLog) {
        if ( machineryMaintenanceLog == null ) {
            return null;
        }

        MaintenanceLogSummaryDto maintenanceLogSummaryDto = new MaintenanceLogSummaryDto();

        maintenanceLogSummaryDto.setId( machineryMaintenanceLog.getId() );

        return maintenanceLogSummaryDto;
    }
}
