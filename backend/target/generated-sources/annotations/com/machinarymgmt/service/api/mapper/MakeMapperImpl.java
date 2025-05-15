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
    date = "2025-05-15T11:58:37+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
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

        makeListResponse.setRespType( baseApiResponse.getRespType() );
        makeListResponse.setMetadata( baseApiResponse.getMetadata() );
        makeListResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            makeListResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return makeListResponse;
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

    @Override
    public MakeResponse toMakeApiResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MakeResponse makeResponse = new MakeResponse();

        makeResponse.setRespType( baseApiResponse.getRespType() );
        makeResponse.setMetadata( baseApiResponse.getMetadata() );
        makeResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            makeResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

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
