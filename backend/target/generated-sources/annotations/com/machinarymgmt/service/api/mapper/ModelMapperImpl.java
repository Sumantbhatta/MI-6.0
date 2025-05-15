package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Make;
import com.machinarymgmt.service.api.data.model.Model;
import com.machinarymgmt.service.dto.MakeSummaryDto;
import com.machinarymgmt.service.dto.ModelDto;
import com.machinarymgmt.service.dto.ModelListResponse;
import com.machinarymgmt.service.dto.ModelRequestDto;
import com.machinarymgmt.service.dto.ModelResponse;
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
public class ModelMapperImpl implements ModelMapper {

    @Override
    public ModelDto toDto(Model model) {
        if ( model == null ) {
            return null;
        }

        ModelDto modelDto = new ModelDto();

        modelDto.setId( model.getId() );
        modelDto.setName( model.getName() );
        modelDto.setMake( makeToMakeSummaryDto( model.getMake() ) );

        return modelDto;
    }

    @Override
    public List<ModelDto> toDtoList(List<Model> models) {
        if ( models == null ) {
            return null;
        }

        List<ModelDto> list = new ArrayList<ModelDto>( models.size() );
        for ( Model model : models ) {
            list.add( toDto( model ) );
        }

        return list;
    }

    @Override
    public ModelRequestDto toRequestDto(Model model) {
        if ( model == null ) {
            return null;
        }

        ModelRequestDto modelRequestDto = new ModelRequestDto();

        modelRequestDto.setName( model.getName() );

        return modelRequestDto;
    }

    @Override
    public Model toEntity(ModelDto dto) {
        if ( dto == null ) {
            return null;
        }

        Model.ModelBuilder model = Model.builder();

        model.id( dto.getId() );
        model.make( makeSummaryDtoToMake( dto.getMake() ) );
        model.name( dto.getName() );

        return model.build();
    }

    @Override
    public Model toEntity(ModelRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        Model.ModelBuilder model = Model.builder();

        model.name( requestDto.getName() );

        return model.build();
    }

    @Override
    public void updateEntityFromDto(ModelRequestDto dto, Model model) {
        if ( dto == null ) {
            return;
        }

        model.setName( dto.getName() );
    }

    @Override
    public ModelListResponse toDtoList(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        ModelListResponse modelListResponse = new ModelListResponse();

        modelListResponse.setRespType( baseApiResponse.getRespType() );
        modelListResponse.setMetadata( baseApiResponse.getMetadata() );
        modelListResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            modelListResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return modelListResponse;
    }

    @Override
    public ModelResponse toModelResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        ModelResponse modelResponse = new ModelResponse();

        modelResponse.setRespType( baseApiResponse.getRespType() );
        modelResponse.setMetadata( baseApiResponse.getMetadata() );
        modelResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            modelResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return modelResponse;
    }

    protected MakeSummaryDto makeToMakeSummaryDto(Make make) {
        if ( make == null ) {
            return null;
        }

        MakeSummaryDto makeSummaryDto = new MakeSummaryDto();

        makeSummaryDto.setId( make.getId() );
        makeSummaryDto.setName( make.getName() );

        return makeSummaryDto;
    }

    protected Make makeSummaryDtoToMake(MakeSummaryDto makeSummaryDto) {
        if ( makeSummaryDto == null ) {
            return null;
        }

        Make.MakeBuilder make = Make.builder();

        make.id( makeSummaryDto.getId() );
        make.name( makeSummaryDto.getName() );

        return make.build();
    }
}
