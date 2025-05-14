package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Item;
import com.machinarymgmt.service.api.data.model.MachineryMaintenanceLog;
import com.machinarymgmt.service.api.data.model.MaintenancePartsUsed;
import com.machinarymgmt.service.dto.ItemSummaryDto;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
import com.machinarymgmt.service.dto.MaintenanceLogSummaryDto;
import com.machinarymgmt.service.dto.MaintenancePartUsedDto;
import com.machinarymgmt.service.dto.MaintenancePartUsedListResponse;
import com.machinarymgmt.service.dto.MaintenancePartUsedRequestDto;
import com.machinarymgmt.service.dto.MaintenancePartUsedResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-13T15:41:59+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class MaintenancePartUsedMapperImpl implements MaintenancePartUsedMapper {

    @Override
    public MaintenancePartUsedDto toDto(MaintenancePartsUsed partsUsed) {
        if ( partsUsed == null ) {
            return null;
        }

        MaintenancePartUsedDto maintenancePartUsedDto = new MaintenancePartUsedDto();

        maintenancePartUsedDto.setId( partsUsed.getId() );
        maintenancePartUsedDto.setQuantity( mapBigDecimalToDouble( partsUsed.getQuantity() ) );
        maintenancePartUsedDto.setItem( itemToItemSummaryDto( partsUsed.getItem() ) );
        maintenancePartUsedDto.setMaintenanceLog( machineryMaintenanceLogToMaintenanceLogSummaryDto( partsUsed.getMaintenanceLog() ) );

        return maintenancePartUsedDto;
    }

    @Override
    public List<MaintenancePartUsedDto> toDtoList(List<MaintenancePartsUsed> partsUsed) {
        if ( partsUsed == null ) {
            return null;
        }

        List<MaintenancePartUsedDto> list = new ArrayList<MaintenancePartUsedDto>( partsUsed.size() );
        for ( MaintenancePartsUsed maintenancePartsUsed : partsUsed ) {
            list.add( toDto( maintenancePartsUsed ) );
        }

        return list;
    }

    @Override
    public MaintenancePartsUsed toEntity(MaintenancePartUsedRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        MaintenancePartsUsed.MaintenancePartsUsedBuilder maintenancePartsUsed = MaintenancePartsUsed.builder();

        maintenancePartsUsed.quantity( mapDoubleToDecimal( dto.getQuantity() ) );

        return maintenancePartsUsed.build();
    }

    @Override
    public MaintenancePartUsedListResponse toMaintenancePartUsedListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MaintenancePartUsedListResponse maintenancePartUsedListResponse = new MaintenancePartUsedListResponse();

        maintenancePartUsedListResponse.setRespType( baseApiResponse.getRespType() );
        maintenancePartUsedListResponse.setMetadata( baseApiResponse.getMetadata() );
        maintenancePartUsedListResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            maintenancePartUsedListResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return maintenancePartUsedListResponse;
    }

    @Override
    public MaintenancePartUsedResponse toMaintenancePartUsedResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MaintenancePartUsedResponse maintenancePartUsedResponse = new MaintenancePartUsedResponse();

        maintenancePartUsedResponse.setRespType( baseApiResponse.getRespType() );
        maintenancePartUsedResponse.setMetadata( baseApiResponse.getMetadata() );
        maintenancePartUsedResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            maintenancePartUsedResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return maintenancePartUsedResponse;
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
    public void updateEntityFromDto(MaintenancePartUsedRequestDto dto, MaintenancePartsUsed log) {
        if ( dto == null ) {
            return;
        }

        log.setQuantity( mapDoubleToDecimal( dto.getQuantity() ) );
    }

    protected ItemSummaryDto itemToItemSummaryDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemSummaryDto itemSummaryDto = new ItemSummaryDto();

        itemSummaryDto.setId( item.getId() );
        itemSummaryDto.setCode( item.getCode() );

        return itemSummaryDto;
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
