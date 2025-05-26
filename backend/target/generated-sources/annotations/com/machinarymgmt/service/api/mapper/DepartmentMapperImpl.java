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
    date = "2025-05-26T16:53:17+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
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

        department.description( dto.getDescription() );
        department.name( dto.getName() );

        return department.build();
    }

    @Override
    public void updateEntityFromDto(DepartmentDto dto, Department department) {
        if ( dto == null ) {
            return;
        }

        department.setDescription( dto.getDescription() );
        department.setId( dto.getId() );
        department.setName( dto.getName() );
    }

    @Override
    public void updateEntityFromDto(DepartmentRequestDto dto, Department department) {
        if ( dto == null ) {
            return;
        }

        department.setDescription( dto.getDescription() );
        department.setName( dto.getName() );
    }

    @Override
    public DepartmentListResponse toDepartmentListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        DepartmentListResponse departmentListResponse = new DepartmentListResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            departmentListResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        departmentListResponse.metadata( baseApiResponse.getMetadata() );
        departmentListResponse.respType( baseApiResponse.getRespType() );
        departmentListResponse.status( baseApiResponse.getStatus() );

        return departmentListResponse;
    }

    @Override
    public DepartmentResponse toDepartmentResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        DepartmentResponse departmentResponse = new DepartmentResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            departmentResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        departmentResponse.metadata( baseApiResponse.getMetadata() );
        departmentResponse.respType( baseApiResponse.getRespType() );
        departmentResponse.status( baseApiResponse.getStatus() );

        return departmentResponse;
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
