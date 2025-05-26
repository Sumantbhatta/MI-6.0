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
    date = "2025-05-26T16:53:17+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
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

        equipment.assetCode( dto.getAssetCode() );
        equipment.name( dto.getName() );
        equipment.vehicleNumber( dto.getVehicleNumber() );
        equipment.yearOfManufacture( dto.getYearOfManufacture() );

        return equipment.build();
    }

    @Override
    public void updateEntityFromDto(EquipmentRequestDto dto, Equipment equipment) {
        if ( dto == null ) {
            return;
        }

        equipment.setAssetCode( dto.getAssetCode() );
        equipment.setName( dto.getName() );
        equipment.setVehicleNumber( dto.getVehicleNumber() );
        equipment.setYearOfManufacture( dto.getYearOfManufacture() );
    }

    @Override
    public EquipmentListResponse toEquipmentListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        EquipmentListResponse equipmentListResponse = new EquipmentListResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            equipmentListResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        equipmentListResponse.metadata( baseApiResponse.getMetadata() );
        equipmentListResponse.respType( baseApiResponse.getRespType() );
        equipmentListResponse.status( baseApiResponse.getStatus() );

        return equipmentListResponse;
    }

    @Override
    public EquipmentResponse toEquipmentResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        EquipmentResponse equipmentResponse = new EquipmentResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            equipmentResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        equipmentResponse.metadata( baseApiResponse.getMetadata() );
        equipmentResponse.respType( baseApiResponse.getRespType() );
        equipmentResponse.status( baseApiResponse.getStatus() );

        return equipmentResponse;
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
