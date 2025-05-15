package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Equipment;
import com.machinarymgmt.service.api.data.model.EquipmentCategory;
import com.machinarymgmt.service.api.data.model.Model;
import com.machinarymgmt.service.api.data.model.Project;
import com.machinarymgmt.service.dto.CategorySummaryDto;
import com.machinarymgmt.service.dto.EquipmentDto;
import com.machinarymgmt.service.dto.EquipmentListResponse;
import com.machinarymgmt.service.dto.EquipmentRequestDto;
import com.machinarymgmt.service.dto.EquipmentResponse;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
import com.machinarymgmt.service.dto.ModelSummaryDto;
import com.machinarymgmt.service.dto.ProjectSummaryDto;
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
public class EquipmentMapperImpl implements EquipmentMapper {

    @Override
    public EquipmentDto toDto(Equipment equipment) {
        if ( equipment == null ) {
            return null;
        }

        EquipmentDto equipmentDto = new EquipmentDto();

        equipmentDto.setId( equipment.getId() );
        equipmentDto.setName( equipment.getName() );
        equipmentDto.setAssetCode( equipment.getAssetCode() );
        equipmentDto.setVehicleNumber( equipment.getVehicleNumber() );
        equipmentDto.setYearOfManufacture( equipment.getYearOfManufacture() );
        equipmentDto.setCategory( equipmentCategoryToCategorySummaryDto( equipment.getCategory() ) );
        equipmentDto.setModel( modelToModelSummaryDto( equipment.getModel() ) );
        equipmentDto.setProject( projectToProjectSummaryDto( equipment.getProject() ) );

        return equipmentDto;
    }

    @Override
    public List<EquipmentDto> toDtoList(List<Equipment> equipmentList) {
        if ( equipmentList == null ) {
            return null;
        }

        List<EquipmentDto> list = new ArrayList<EquipmentDto>( equipmentList.size() );
        for ( Equipment equipment : equipmentList ) {
            list.add( toDto( equipment ) );
        }

        return list;
    }

    @Override
    public Equipment toEntity(EquipmentRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Equipment.EquipmentBuilder equipment = Equipment.builder();

        equipment.name( dto.getName() );
        equipment.assetCode( dto.getAssetCode() );
        equipment.vehicleNumber( dto.getVehicleNumber() );
        equipment.yearOfManufacture( dto.getYearOfManufacture() );

        return equipment.build();
    }

    @Override
    public void updateEntityFromDto(EquipmentRequestDto dto, Equipment equipment) {
        if ( dto == null ) {
            return;
        }

        equipment.setName( dto.getName() );
        equipment.setAssetCode( dto.getAssetCode() );
        equipment.setVehicleNumber( dto.getVehicleNumber() );
        equipment.setYearOfManufacture( dto.getYearOfManufacture() );
    }

    @Override
    public EquipmentListResponse toEquipmentListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        EquipmentListResponse equipmentListResponse = new EquipmentListResponse();

        equipmentListResponse.setRespType( baseApiResponse.getRespType() );
        equipmentListResponse.setMetadata( baseApiResponse.getMetadata() );
        equipmentListResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            equipmentListResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return equipmentListResponse;
    }

    @Override
    public EquipmentResponse toEquipmentResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        EquipmentResponse equipmentResponse = new EquipmentResponse();

        equipmentResponse.setRespType( baseApiResponse.getRespType() );
        equipmentResponse.setMetadata( baseApiResponse.getMetadata() );
        equipmentResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            equipmentResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return equipmentResponse;
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

    protected CategorySummaryDto equipmentCategoryToCategorySummaryDto(EquipmentCategory equipmentCategory) {
        if ( equipmentCategory == null ) {
            return null;
        }

        CategorySummaryDto categorySummaryDto = new CategorySummaryDto();

        categorySummaryDto.setId( equipmentCategory.getId() );
        categorySummaryDto.setName( equipmentCategory.getName() );

        return categorySummaryDto;
    }

    protected ModelSummaryDto modelToModelSummaryDto(Model model) {
        if ( model == null ) {
            return null;
        }

        ModelSummaryDto modelSummaryDto = new ModelSummaryDto();

        modelSummaryDto.setId( model.getId() );
        modelSummaryDto.setName( model.getName() );

        return modelSummaryDto;
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
}
