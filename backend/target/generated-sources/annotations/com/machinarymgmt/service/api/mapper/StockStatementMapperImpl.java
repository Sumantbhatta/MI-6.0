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
    date = "2025-05-06T14:35:35+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
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

        stockStatement.month( dto.getMonth() );
        stockStatement.year( dto.getYear() );
        if ( dto.getBalance() != null ) {
            stockStatement.balance( BigDecimal.valueOf( dto.getBalance() ) );
        }
        if ( dto.getLandedRate() != null ) {
            stockStatement.landedRate( BigDecimal.valueOf( dto.getLandedRate() ) );
        }
        if ( dto.getLandedValue() != null ) {
            stockStatement.landedValue( BigDecimal.valueOf( dto.getLandedValue() ) );
        }
        stockStatement.lastReceiptOn( dto.getLastReceiptOn() );
        stockStatement.lastIssueOn( dto.getLastIssueOn() );

        return stockStatement.build();
    }

    @Override
    public StockStatement toEntity(StockStatementDto dto) {
        if ( dto == null ) {
            return null;
        }

        StockStatement.StockStatementBuilder stockStatement = StockStatement.builder();

        stockStatement.id( dto.getId() );
        stockStatement.project( projectSummaryDtoToProject( dto.getProject() ) );
        stockStatement.item( itemSummaryDtoToItem( dto.getItem() ) );
        stockStatement.equipment( equipmentSummaryDtoToEquipment( dto.getEquipment() ) );
        stockStatement.month( dto.getMonth() );
        stockStatement.year( dto.getYear() );
        if ( dto.getBalance() != null ) {
            stockStatement.balance( BigDecimal.valueOf( dto.getBalance() ) );
        }
        if ( dto.getLandedRate() != null ) {
            stockStatement.landedRate( BigDecimal.valueOf( dto.getLandedRate() ) );
        }
        if ( dto.getLandedValue() != null ) {
            stockStatement.landedValue( BigDecimal.valueOf( dto.getLandedValue() ) );
        }
        stockStatement.lastReceiptOn( dto.getLastReceiptOn() );
        stockStatement.lastIssueOn( dto.getLastIssueOn() );

        return stockStatement.build();
    }

    @Override
    public void updateEntityFromDto(StockStatementRequestDto dto, StockStatement stockStatement) {
        if ( dto == null ) {
            return;
        }

        stockStatement.setMonth( dto.getMonth() );
        stockStatement.setYear( dto.getYear() );
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
        stockStatement.setLastReceiptOn( dto.getLastReceiptOn() );
        stockStatement.setLastIssueOn( dto.getLastIssueOn() );
    }

    @Override
    public StockStatementListResponse toStockStatementListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        StockStatementListResponse stockStatementListResponse = new StockStatementListResponse();

        stockStatementListResponse.setRespType( baseApiResponse.getRespType() );
        stockStatementListResponse.setMetadata( baseApiResponse.getMetadata() );
        stockStatementListResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            stockStatementListResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return stockStatementListResponse;
    }

    @Override
    public StockStatementResponse toStockStatementResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        StockStatementResponse stockStatementResponse = new StockStatementResponse();

        stockStatementResponse.setRespType( baseApiResponse.getRespType() );
        stockStatementResponse.setMetadata( baseApiResponse.getMetadata() );
        stockStatementResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            stockStatementResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return stockStatementResponse;
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

    protected Project projectSummaryDtoToProject(ProjectSummaryDto projectSummaryDto) {
        if ( projectSummaryDto == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.id( projectSummaryDto.getId() );
        project.name( projectSummaryDto.getName() );

        return project.build();
    }

    protected Item itemSummaryDtoToItem(ItemSummaryDto itemSummaryDto) {
        if ( itemSummaryDto == null ) {
            return null;
        }

        Item.ItemBuilder item = Item.builder();

        item.id( itemSummaryDto.getId() );
        item.code( itemSummaryDto.getCode() );

        return item.build();
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
}
