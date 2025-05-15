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
    date = "2025-05-15T11:58:38+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
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

        designation.name( dto.getName() );
        designation.description( dto.getDescription() );

        return designation.build();
    }

    @Override
    public void updateEntityFromDto(DesignationRequestDto dto, Designation designation) {
        if ( dto == null ) {
            return;
        }

        designation.setName( dto.getName() );
        designation.setDescription( dto.getDescription() );
    }

    @Override
    public DesignationListResponse toDesignationListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        DesignationListResponse designationListResponse = new DesignationListResponse();

        designationListResponse.setRespType( baseApiResponse.getRespType() );
        designationListResponse.setMetadata( baseApiResponse.getMetadata() );
        designationListResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            designationListResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return designationListResponse;
    }

    @Override
    public DesignationResponse toDesignationResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        DesignationResponse designationResponse = new DesignationResponse();

        designationResponse.setRespType( baseApiResponse.getRespType() );
        designationResponse.setMetadata( baseApiResponse.getMetadata() );
        designationResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            designationResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return designationResponse;
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
}
