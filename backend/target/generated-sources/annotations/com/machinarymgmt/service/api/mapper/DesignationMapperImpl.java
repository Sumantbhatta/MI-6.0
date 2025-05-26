package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Designation;
import com.machinarymgmt.service.dto.DesignationDto;
import com.machinarymgmt.service.dto.DesignationListResponse;
import com.machinarymgmt.service.dto.DesignationRequestDto;
import com.machinarymgmt.service.dto.DesignationResponse;
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
public class DesignationMapperImpl implements DesignationMapper {

    @Override
    public DesignationDto toDto(Designation designation) {
        if ( designation == null ) {
            return null;
        }

        DesignationDto designationDto = new DesignationDto();

        designationDto.setId( designation.getId() );
        designationDto.setName( designation.getName() );
        designationDto.setDescription( designation.getDescription() );

        return designationDto;
    }

    @Override
    public List<DesignationDto> toDtoList(List<Designation> designations) {
        if ( designations == null ) {
            return null;
        }

        List<DesignationDto> list = new ArrayList<DesignationDto>( designations.size() );
        for ( Designation designation : designations ) {
            list.add( toDto( designation ) );
        }

        return list;
    }

    @Override
    public DesignationRequestDto toDesignationRequestDto(Designation designation) {
        if ( designation == null ) {
            return null;
        }

        DesignationRequestDto designationRequestDto = new DesignationRequestDto();

        designationRequestDto.setName( designation.getName() );
        designationRequestDto.setDescription( designation.getDescription() );

        return designationRequestDto;
    }

    @Override
    public Designation toEntity(DesignationRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Designation.DesignationBuilder designation = Designation.builder();

        designation.description( dto.getDescription() );
        designation.name( dto.getName() );

        return designation.build();
    }

    @Override
    public void updateEntityFromDto(DesignationRequestDto dto, Designation designation) {
        if ( dto == null ) {
            return;
        }

        designation.setDescription( dto.getDescription() );
        designation.setName( dto.getName() );
    }

    @Override
    public DesignationListResponse toDesignationListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        DesignationListResponse designationListResponse = new DesignationListResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            designationListResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        designationListResponse.metadata( baseApiResponse.getMetadata() );
        designationListResponse.respType( baseApiResponse.getRespType() );
        designationListResponse.status( baseApiResponse.getStatus() );

        return designationListResponse;
    }

    @Override
    public DesignationResponse toDesignationResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        DesignationResponse designationResponse = new DesignationResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            designationResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        designationResponse.metadata( baseApiResponse.getMetadata() );
        designationResponse.respType( baseApiResponse.getRespType() );
        designationResponse.status( baseApiResponse.getStatus() );

        return designationResponse;
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
}
