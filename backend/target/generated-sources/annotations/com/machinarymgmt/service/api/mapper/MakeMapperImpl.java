package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Make;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
import com.machinarymgmt.service.dto.MakeDto;
import com.machinarymgmt.service.dto.MakeListResponse;
import com.machinarymgmt.service.dto.MakeRequestDto;
import com.machinarymgmt.service.dto.MakeResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T16:53:18+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class MakeMapperImpl implements MakeMapper {

    @Override
    public MakeDto toDto(Make make) {
        if ( make == null ) {
            return null;
        }

        MakeDto makeDto = new MakeDto();

        makeDto.setId( make.getId() );
        makeDto.setName( make.getName() );

        return makeDto;
    }

    @Override
    public List<MakeDto> toDtoList(List<Make> makes) {
        if ( makes == null ) {
            return null;
        }

        List<MakeDto> list = new ArrayList<MakeDto>( makes.size() );
        for ( Make make : makes ) {
            list.add( toDto( make ) );
        }

        return list;
    }

    @Override
    public Make toEntity(MakeRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Make.MakeBuilder make = Make.builder();

        make.name( dto.getName() );

        return make.build();
    }

    @Override
    public MakeListResponse toDtoList(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MakeListResponse makeListResponse = new MakeListResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            makeListResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        makeListResponse.metadata( baseApiResponse.getMetadata() );
        makeListResponse.respType( baseApiResponse.getRespType() );
        makeListResponse.status( baseApiResponse.getStatus() );

        return makeListResponse;
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
    public MakeResponse toMakeApiResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MakeResponse makeResponse = new MakeResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            makeResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        makeResponse.metadata( baseApiResponse.getMetadata() );
        makeResponse.respType( baseApiResponse.getRespType() );
        makeResponse.status( baseApiResponse.getStatus() );

        return makeResponse;
    }

    @Override
    public void updateMakeFromDto(MakeRequestDto dto, Make make) {
        if ( dto == null ) {
            return;
        }

        make.setName( dto.getName() );
    }
}
