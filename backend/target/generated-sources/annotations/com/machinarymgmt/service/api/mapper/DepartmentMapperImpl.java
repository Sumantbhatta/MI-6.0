package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Department;
import com.machinarymgmt.service.dto.DepartmentDto;
import com.machinarymgmt.service.dto.DepartmentListResponse;
import com.machinarymgmt.service.dto.DepartmentRequestDto;
import com.machinarymgmt.service.dto.DepartmentResponse;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
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
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDto toDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId( department.getId() );
        departmentDto.setName( department.getName() );
        departmentDto.setDescription( department.getDescription() );

        return departmentDto;
    }

    @Override
    public DepartmentRequestDto toDepartmentRequestDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentRequestDto departmentRequestDto = new DepartmentRequestDto();

        departmentRequestDto.setName( department.getName() );
        departmentRequestDto.setDescription( department.getDescription() );

        return departmentRequestDto;
    }

    @Override
    public List<DepartmentDto> toDtoList(List<Department> departments) {
        if ( departments == null ) {
            return null;
        }

        List<DepartmentDto> list = new ArrayList<DepartmentDto>( departments.size() );
        for ( Department department : departments ) {
            list.add( toDto( department ) );
        }

        return list;
    }

    @Override
    public Department toEntity(DepartmentRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Department.DepartmentBuilder department = Department.builder();

        department.name( dto.getName() );
        department.description( dto.getDescription() );

        return department.build();
    }

    @Override
    public void updateEntityFromDto(DepartmentDto dto, Department department) {
        if ( dto == null ) {
            return;
        }

        department.setId( dto.getId() );
        department.setName( dto.getName() );
        department.setDescription( dto.getDescription() );
    }

    @Override
    public void updateEntityFromDto(DepartmentRequestDto dto, Department department) {
        if ( dto == null ) {
            return;
        }

        department.setName( dto.getName() );
        department.setDescription( dto.getDescription() );
    }

    @Override
    public DepartmentListResponse toDepartmentListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        DepartmentListResponse departmentListResponse = new DepartmentListResponse();

        departmentListResponse.setRespType( baseApiResponse.getRespType() );
        departmentListResponse.setMetadata( baseApiResponse.getMetadata() );
        departmentListResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            departmentListResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return departmentListResponse;
    }

    @Override
    public DepartmentResponse toDepartmentResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        DepartmentResponse departmentResponse = new DepartmentResponse();

        departmentResponse.setRespType( baseApiResponse.getRespType() );
        departmentResponse.setMetadata( baseApiResponse.getMetadata() );
        departmentResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            departmentResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return departmentResponse;
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
