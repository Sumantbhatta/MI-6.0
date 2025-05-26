package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.EquipmentCategory;
import com.machinarymgmt.service.dto.EquipmentCategoryDto;
import com.machinarymgmt.service.dto.EquipmentCategoryListResponse;
import com.machinarymgmt.service.dto.EquipmentCategoryRequestDto;
import com.machinarymgmt.service.dto.EquipmentCategoryResponse;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
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
public class EquipmentCategoryMapperImpl implements EquipmentCategoryMapper {

    @Override
    public EquipmentCategoryDto toDto(EquipmentCategory category) {
        if ( category == null ) {
            return null;
        }

        EquipmentCategoryDto equipmentCategoryDto = new EquipmentCategoryDto();

        equipmentCategoryDto.setId( category.getId() );
        equipmentCategoryDto.setName( category.getName() );

        return equipmentCategoryDto;
    }

    @Override
    public List<EquipmentCategoryDto> toDtoList(List<EquipmentCategory> categories) {
        if ( categories == null ) {
            return null;
        }

        List<EquipmentCategoryDto> list = new ArrayList<EquipmentCategoryDto>( categories.size() );
        for ( EquipmentCategory equipmentCategory : categories ) {
            list.add( toDto( equipmentCategory ) );
        }

        return list;
    }

    @Override
    public EquipmentCategory toEntity(EquipmentCategoryRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        EquipmentCategory.EquipmentCategoryBuilder equipmentCategory = EquipmentCategory.builder();

        equipmentCategory.name( dto.getName() );

        return equipmentCategory.build();
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
    public EquipmentCategoryListResponse toDtoList(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        EquipmentCategoryListResponse equipmentCategoryListResponse = new EquipmentCategoryListResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            equipmentCategoryListResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        equipmentCategoryListResponse.metadata( baseApiResponse.getMetadata() );
        equipmentCategoryListResponse.respType( baseApiResponse.getRespType() );
        equipmentCategoryListResponse.status( baseApiResponse.getStatus() );

        return equipmentCategoryListResponse;
    }

    @Override
    public EquipmentCategoryResponse toCategoryResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        EquipmentCategoryResponse equipmentCategoryResponse = new EquipmentCategoryResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            equipmentCategoryResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        equipmentCategoryResponse.metadata( baseApiResponse.getMetadata() );
        equipmentCategoryResponse.respType( baseApiResponse.getRespType() );
        equipmentCategoryResponse.status( baseApiResponse.getStatus() );

        return equipmentCategoryResponse;
    }

    @Override
    public void updateEntityFromDto(EquipmentCategoryRequestDto dto, EquipmentCategory equipmentCategory) {
        if ( dto == null ) {
            return;
        }

        equipmentCategory.setName( dto.getName() );
    }
}
