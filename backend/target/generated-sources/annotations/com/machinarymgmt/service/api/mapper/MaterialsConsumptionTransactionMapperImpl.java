package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Equipment;
import com.machinarymgmt.service.api.data.model.Item;
import com.machinarymgmt.service.api.data.model.MaterialsConsumptionTransaction;
import com.machinarymgmt.service.api.data.model.Project;
import com.machinarymgmt.service.dto.EquipmentSummaryDto;
import com.machinarymgmt.service.dto.ItemSummaryDto;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
import com.machinarymgmt.service.dto.MaterialsConsumptionTransactionDto;
import com.machinarymgmt.service.dto.MaterialsConsumptionTransactionListResponse;
import com.machinarymgmt.service.dto.MaterialsConsumptionTransactionRequest;
import com.machinarymgmt.service.dto.MaterialsConsumptionTransactionResponse;
import com.machinarymgmt.service.dto.ProjectSummaryDto;
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
public class MaterialsConsumptionTransactionMapperImpl implements MaterialsConsumptionTransactionMapper {

    @Override
    public MaterialsConsumptionTransactionDto toDto(MaterialsConsumptionTransaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        MaterialsConsumptionTransactionDto materialsConsumptionTransactionDto = new MaterialsConsumptionTransactionDto();

        materialsConsumptionTransactionDto.setId( transaction.getId() );
        materialsConsumptionTransactionDto.setIssueDate( transaction.getIssueDate() );
        materialsConsumptionTransactionDto.setQuantity( transaction.getQuantity() );
        if ( transaction.getCostPerUnit() != null ) {
            materialsConsumptionTransactionDto.setCostPerUnit( transaction.getCostPerUnit().doubleValue() );
        }
        if ( transaction.getTotalCost() != null ) {
            materialsConsumptionTransactionDto.setTotalCost( transaction.getTotalCost().doubleValue() );
        }
        materialsConsumptionTransactionDto.setRemarks( transaction.getRemarks() );
        materialsConsumptionTransactionDto.setProject( projectToProjectSummaryDto( transaction.getProject() ) );
        materialsConsumptionTransactionDto.setEquipment( equipmentToEquipmentSummaryDto( transaction.getEquipment() ) );
        materialsConsumptionTransactionDto.setItem( itemToItemSummaryDto( transaction.getItem() ) );

        return materialsConsumptionTransactionDto;
    }

    @Override
    public List<MaterialsConsumptionTransactionDto> toDtoList(List<MaterialsConsumptionTransaction> transactions) {
        if ( transactions == null ) {
            return null;
        }

        List<MaterialsConsumptionTransactionDto> list = new ArrayList<MaterialsConsumptionTransactionDto>( transactions.size() );
        for ( MaterialsConsumptionTransaction materialsConsumptionTransaction : transactions ) {
            list.add( toDto( materialsConsumptionTransaction ) );
        }

        return list;
    }

    @Override
    public MaterialsConsumptionTransaction toEntity(MaterialsConsumptionTransactionRequest request) {
        if ( request == null ) {
            return null;
        }

        MaterialsConsumptionTransaction.MaterialsConsumptionTransactionBuilder materialsConsumptionTransaction = MaterialsConsumptionTransaction.builder();

        if ( request.getCostPerUnit() != null ) {
            materialsConsumptionTransaction.costPerUnit( BigDecimal.valueOf( request.getCostPerUnit() ) );
        }
        materialsConsumptionTransaction.issueDate( request.getIssueDate() );
        materialsConsumptionTransaction.quantity( request.getQuantity() );
        materialsConsumptionTransaction.remarks( request.getRemarks() );
        if ( request.getTotalCost() != null ) {
            materialsConsumptionTransaction.totalCost( BigDecimal.valueOf( request.getTotalCost() ) );
        }

        return materialsConsumptionTransaction.build();
    }

    @Override
    public void updateEntityFromDto(MaterialsConsumptionTransactionRequest request, MaterialsConsumptionTransaction transaction) {
        if ( request == null ) {
            return;
        }

        if ( request.getCostPerUnit() != null ) {
            transaction.setCostPerUnit( BigDecimal.valueOf( request.getCostPerUnit() ) );
        }
        else {
            transaction.setCostPerUnit( null );
        }
        transaction.setIssueDate( request.getIssueDate() );
        transaction.setQuantity( request.getQuantity() );
        transaction.setRemarks( request.getRemarks() );
        if ( request.getTotalCost() != null ) {
            transaction.setTotalCost( BigDecimal.valueOf( request.getTotalCost() ) );
        }
        else {
            transaction.setTotalCost( null );
        }
    }

    @Override
    public MaterialsConsumptionTransactionListResponse toListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MaterialsConsumptionTransactionListResponse materialsConsumptionTransactionListResponse = new MaterialsConsumptionTransactionListResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            materialsConsumptionTransactionListResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        materialsConsumptionTransactionListResponse.metadata( baseApiResponse.getMetadata() );
        materialsConsumptionTransactionListResponse.respType( baseApiResponse.getRespType() );
        materialsConsumptionTransactionListResponse.status( baseApiResponse.getStatus() );

        return materialsConsumptionTransactionListResponse;
    }

    @Override
    public MachinaryMgmtBaseApiResponse toDtoResponse(BaseApiResponse baseApiResponse) {
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
    public MaterialsConsumptionTransactionResponse toResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MaterialsConsumptionTransactionResponse materialsConsumptionTransactionResponse = new MaterialsConsumptionTransactionResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            materialsConsumptionTransactionResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        materialsConsumptionTransactionResponse.metadata( baseApiResponse.getMetadata() );
        materialsConsumptionTransactionResponse.respType( baseApiResponse.getRespType() );
        materialsConsumptionTransactionResponse.status( baseApiResponse.getStatus() );

        return materialsConsumptionTransactionResponse;
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
