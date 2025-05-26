package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Equipment;
import com.machinarymgmt.service.api.data.model.Item;
import com.machinarymgmt.service.api.data.model.Project;
import com.machinarymgmt.service.api.data.model.StockStatement;
import com.machinarymgmt.service.dto.EquipmentSummaryDto;
import com.machinarymgmt.service.dto.ItemSummaryDto;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
import com.machinarymgmt.service.dto.ProjectSummaryDto;
import com.machinarymgmt.service.dto.StockStatementDto;
import com.machinarymgmt.service.dto.StockStatementListResponse;
import com.machinarymgmt.service.dto.StockStatementRequestDto;
import com.machinarymgmt.service.dto.StockStatementResponse;
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
public class StockStatementMapperImpl implements StockStatementMapper {

    @Override
    public StockStatementDto toDto(StockStatement stockStatement) {
        if ( stockStatement == null ) {
            return null;
        }

        StockStatementDto stockStatementDto = new StockStatementDto();

        stockStatementDto.setId( stockStatement.getId() );
        stockStatementDto.setLastIssueOn( stockStatement.getLastIssueOn() );
        stockStatementDto.setLastReceiptOn( stockStatement.getLastReceiptOn() );
        stockStatementDto.setMonth( stockStatement.getMonth() );
        stockStatementDto.setYear( stockStatement.getYear() );
        if ( stockStatement.getBalance() != null ) {
            stockStatementDto.setBalance( stockStatement.getBalance().doubleValue() );
        }
        if ( stockStatement.getLandedValue() != null ) {
            stockStatementDto.setLandedValue( stockStatement.getLandedValue().doubleValue() );
        }
        if ( stockStatement.getLandedRate() != null ) {
            stockStatementDto.setLandedRate( stockStatement.getLandedRate().doubleValue() );
        }
        stockStatementDto.setProject( projectToProjectSummaryDto( stockStatement.getProject() ) );
        stockStatementDto.setEquipment( equipmentToEquipmentSummaryDto( stockStatement.getEquipment() ) );
        stockStatementDto.setItem( itemToItemSummaryDto( stockStatement.getItem() ) );

        return stockStatementDto;
    }

    @Override
    public List<StockStatementDto> toDtoList(List<StockStatement> stockStatements) {
        if ( stockStatements == null ) {
            return null;
        }

        List<StockStatementDto> list = new ArrayList<StockStatementDto>( stockStatements.size() );
        for ( StockStatement stockStatement : stockStatements ) {
            list.add( toDto( stockStatement ) );
        }

        return list;
    }

    @Override
    public StockStatement toEntity(StockStatementRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        StockStatement.StockStatementBuilder stockStatement = StockStatement.builder();

        if ( dto.getBalance() != null ) {
            stockStatement.balance( BigDecimal.valueOf( dto.getBalance() ) );
        }
        if ( dto.getLandedRate() != null ) {
            stockStatement.landedRate( BigDecimal.valueOf( dto.getLandedRate() ) );
        }
        if ( dto.getLandedValue() != null ) {
            stockStatement.landedValue( BigDecimal.valueOf( dto.getLandedValue() ) );
        }
        stockStatement.lastIssueOn( dto.getLastIssueOn() );
        stockStatement.lastReceiptOn( dto.getLastReceiptOn() );
        stockStatement.month( dto.getMonth() );
        stockStatement.year( dto.getYear() );

        return stockStatement.build();
    }

    @Override
    public StockStatement toEntity(StockStatementDto dto) {
        if ( dto == null ) {
            return null;
        }

        StockStatement.StockStatementBuilder stockStatement = StockStatement.builder();

        if ( dto.getBalance() != null ) {
            stockStatement.balance( BigDecimal.valueOf( dto.getBalance() ) );
        }
        stockStatement.equipment( equipmentSummaryDtoToEquipment( dto.getEquipment() ) );
        stockStatement.id( dto.getId() );
        stockStatement.item( itemSummaryDtoToItem( dto.getItem() ) );
        if ( dto.getLandedRate() != null ) {
            stockStatement.landedRate( BigDecimal.valueOf( dto.getLandedRate() ) );
        }
        if ( dto.getLandedValue() != null ) {
            stockStatement.landedValue( BigDecimal.valueOf( dto.getLandedValue() ) );
        }
        stockStatement.lastIssueOn( dto.getLastIssueOn() );
        stockStatement.lastReceiptOn( dto.getLastReceiptOn() );
        stockStatement.month( dto.getMonth() );
        stockStatement.project( projectSummaryDtoToProject( dto.getProject() ) );
        stockStatement.year( dto.getYear() );

        return stockStatement.build();
    }

    @Override
    public void updateEntityFromDto(StockStatementRequestDto dto, StockStatement stockStatement) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getBalance() != null ) {
            stockStatement.setBalance( BigDecimal.valueOf( dto.getBalance() ) );
        }
        else {
            stockStatement.setBalance( null );
        }
        if ( dto.getLandedRate() != null ) {
            stockStatement.setLandedRate( BigDecimal.valueOf( dto.getLandedRate() ) );
        }
        else {
            stockStatement.setLandedRate( null );
        }
        if ( dto.getLandedValue() != null ) {
            stockStatement.setLandedValue( BigDecimal.valueOf( dto.getLandedValue() ) );
        }
        else {
            stockStatement.setLandedValue( null );
        }
        stockStatement.setLastIssueOn( dto.getLastIssueOn() );
        stockStatement.setLastReceiptOn( dto.getLastReceiptOn() );
        stockStatement.setMonth( dto.getMonth() );
        stockStatement.setYear( dto.getYear() );
    }

    @Override
    public StockStatementListResponse toStockStatementListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        StockStatementListResponse stockStatementListResponse = new StockStatementListResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            stockStatementListResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        stockStatementListResponse.metadata( baseApiResponse.getMetadata() );
        stockStatementListResponse.respType( baseApiResponse.getRespType() );
        stockStatementListResponse.status( baseApiResponse.getStatus() );

        return stockStatementListResponse;
    }

    @Override
    public StockStatementResponse toStockStatementResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        StockStatementResponse stockStatementResponse = new StockStatementResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            stockStatementResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        stockStatementResponse.metadata( baseApiResponse.getMetadata() );
        stockStatementResponse.respType( baseApiResponse.getRespType() );
        stockStatementResponse.status( baseApiResponse.getStatus() );

        return stockStatementResponse;
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

    protected Equipment equipmentSummaryDtoToEquipment(EquipmentSummaryDto equipmentSummaryDto) {
        if ( equipmentSummaryDto == null ) {
            return null;
        }

        Equipment.EquipmentBuilder equipment = Equipment.builder();

        equipment.id( equipmentSummaryDto.getId() );
        equipment.name( equipmentSummaryDto.getName() );

        return equipment.build();
    }

    protected Item itemSummaryDtoToItem(ItemSummaryDto itemSummaryDto) {
        if ( itemSummaryDto == null ) {
            return null;
        }

        Item.ItemBuilder item = Item.builder();

        item.code( itemSummaryDto.getCode() );
        item.id( itemSummaryDto.getId() );

        return item.build();
    }

    protected Project projectSummaryDtoToProject(ProjectSummaryDto projectSummaryDto) {
        if ( projectSummaryDto == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.id( projectSummaryDto.getId() );
        project.name( projectSummaryDto.getName() );

        return project.build();
    }
}
