package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Equipment;
import com.machinarymgmt.service.api.data.model.Item;
import com.machinarymgmt.service.api.data.model.PettyCashTransaction;
import com.machinarymgmt.service.api.data.model.Project;
import com.machinarymgmt.service.dto.EquipmentSummaryDto;
import com.machinarymgmt.service.dto.ItemSummaryDto;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
import com.machinarymgmt.service.dto.PettyCashTransactionDto;
import com.machinarymgmt.service.dto.PettyCashTransactionListResponse;
import com.machinarymgmt.service.dto.PettyCashTransactionRequestDto;
import com.machinarymgmt.service.dto.PettyCashTransactionResponse;
import com.machinarymgmt.service.dto.ProjectSummaryDto;
import java.math.BigDecimal;
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
public class PettyCashTransactionMapperImpl implements PettyCashTransactionMapper {

    @Override
    public PettyCashTransactionDto toDto(PettyCashTransaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        PettyCashTransactionDto pettyCashTransactionDto = new PettyCashTransactionDto();

        pettyCashTransactionDto.setId( transaction.getId() );
        pettyCashTransactionDto.setReportDate( transaction.getReportDate() );
        pettyCashTransactionDto.setRemarks( transaction.getRemarks() );
        if ( transaction.getAmountSpent() != null ) {
            pettyCashTransactionDto.setAmountSpent( transaction.getAmountSpent().doubleValue() );
        }
        if ( transaction.getQuantity() != null ) {
            pettyCashTransactionDto.setQuantity( transaction.getQuantity().doubleValue() );
        }
        if ( transaction.getRate() != null ) {
            pettyCashTransactionDto.setRate( transaction.getRate().doubleValue() );
        }
        if ( transaction.getCumulativeTotalAmount() != null ) {
            pettyCashTransactionDto.setCumulativeTotalAmount( transaction.getCumulativeTotalAmount().doubleValue() );
        }
        pettyCashTransactionDto.setPurposeJustification( transaction.getPurposeJustification() );
        pettyCashTransactionDto.setProject( projectToProjectSummaryDto( transaction.getProject() ) );
        pettyCashTransactionDto.setEquipment( equipmentToEquipmentSummaryDto( transaction.getEquipment() ) );
        pettyCashTransactionDto.setItem( itemToItemSummaryDto( transaction.getItem() ) );

        return pettyCashTransactionDto;
    }

    @Override
    public List<PettyCashTransactionDto> toDtoList(List<PettyCashTransaction> transactions) {
        if ( transactions == null ) {
            return null;
        }

        List<PettyCashTransactionDto> list = new ArrayList<PettyCashTransactionDto>( transactions.size() );
        for ( PettyCashTransaction pettyCashTransaction : transactions ) {
            list.add( toDto( pettyCashTransaction ) );
        }

        return list;
    }

    @Override
    public PettyCashTransaction toEntity(PettyCashTransactionRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        PettyCashTransaction.PettyCashTransactionBuilder pettyCashTransaction = PettyCashTransaction.builder();

        pettyCashTransaction.reportDate( dto.getReportDate() );
        if ( dto.getQuantity() != null ) {
            pettyCashTransaction.quantity( dto.getQuantity().intValue() );
        }
        if ( dto.getRate() != null ) {
            pettyCashTransaction.rate( BigDecimal.valueOf( dto.getRate() ) );
        }
        if ( dto.getCumulativeTotalAmount() != null ) {
            pettyCashTransaction.cumulativeTotalAmount( BigDecimal.valueOf( dto.getCumulativeTotalAmount() ) );
        }
        if ( dto.getAmountSpent() != null ) {
            pettyCashTransaction.amountSpent( BigDecimal.valueOf( dto.getAmountSpent() ) );
        }
        pettyCashTransaction.purposeJustification( dto.getPurposeJustification() );
        pettyCashTransaction.remarks( dto.getRemarks() );

        return pettyCashTransaction.build();
    }

    @Override
    public PettyCashTransactionListResponse toDtoList(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        PettyCashTransactionListResponse pettyCashTransactionListResponse = new PettyCashTransactionListResponse();

        pettyCashTransactionListResponse.setRespType( baseApiResponse.getRespType() );
        pettyCashTransactionListResponse.setMetadata( baseApiResponse.getMetadata() );
        pettyCashTransactionListResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            pettyCashTransactionListResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return pettyCashTransactionListResponse;
    }

    @Override
    public PettyCashTransactionResponse toPettyCashTransactionResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        PettyCashTransactionResponse pettyCashTransactionResponse = new PettyCashTransactionResponse();

        pettyCashTransactionResponse.setRespType( baseApiResponse.getRespType() );
        pettyCashTransactionResponse.setMetadata( baseApiResponse.getMetadata() );
        pettyCashTransactionResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            pettyCashTransactionResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return pettyCashTransactionResponse;
    }

    @Override
    public void updateEntityFromDto(PettyCashTransactionRequestDto dto, PettyCashTransaction transaction) {
        if ( dto == null ) {
            return;
        }

        transaction.setReportDate( dto.getReportDate() );
        if ( dto.getQuantity() != null ) {
            transaction.setQuantity( dto.getQuantity().intValue() );
        }
        else {
            transaction.setQuantity( null );
        }
        if ( dto.getRate() != null ) {
            transaction.setRate( BigDecimal.valueOf( dto.getRate() ) );
        }
        else {
            transaction.setRate( null );
        }
        if ( dto.getCumulativeTotalAmount() != null ) {
            transaction.setCumulativeTotalAmount( BigDecimal.valueOf( dto.getCumulativeTotalAmount() ) );
        }
        else {
            transaction.setCumulativeTotalAmount( null );
        }
        if ( dto.getAmountSpent() != null ) {
            transaction.setAmountSpent( BigDecimal.valueOf( dto.getAmountSpent() ) );
        }
        else {
            transaction.setAmountSpent( null );
        }
        transaction.setPurposeJustification( dto.getPurposeJustification() );
        transaction.setRemarks( dto.getRemarks() );
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

    protected ProjectSummaryDto projectToProjectSummaryDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectSummaryDto projectSummaryDto = new ProjectSummaryDto();

        projectSummaryDto.setId( project.getId() );
        projectSummaryDto.setName( project.getName() );

        return projectSummaryDto;
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

    protected ItemSummaryDto itemToItemSummaryDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemSummaryDto itemSummaryDto = new ItemSummaryDto();

        itemSummaryDto.setId( item.getId() );
        itemSummaryDto.setCode( item.getCode() );

        return itemSummaryDto;
    }
}
