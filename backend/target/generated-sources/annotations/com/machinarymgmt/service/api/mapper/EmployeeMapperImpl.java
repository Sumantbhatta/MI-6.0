package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Department;
import com.machinarymgmt.service.api.data.model.Designation;
import com.machinarymgmt.service.api.data.model.Employee;
import com.machinarymgmt.service.dto.DesignationDto;
import com.machinarymgmt.service.dto.EmployeeDto;
import com.machinarymgmt.service.dto.EmployeeListResponse;
import com.machinarymgmt.service.dto.EmployeeRequestDto;
import com.machinarymgmt.service.dto.EmployeeResponse;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T16:53:17+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private DesignationMapper designationMapper;

    @Override
    public EmployeeDto toDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( employee.getId() );
        employeeDto.setName( employee.getName() );
        employeeDto.setRemarks( employee.getRemarks() );
        employeeDto.setDepartment( departmentMapper.toDto( employee.getDepartment() ) );
        employeeDto.setDesignation( designationMapper.toDto( employee.getDesignation() ) );

        return employeeDto;
    }

    @Override
    public List<EmployeeDto> toDtoList(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( toDto( employee ) );
        }

        return list;
    }

    @Override
    public Employee toEntity(EmployeeRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.name( dto.getName() );
        employee.remarks( dto.getRemarks() );

        return employee.build();
    }

    @Override
    public void updateEntityFromDto(EmployeeRequestDto dto, Employee employee) {
        if ( dto == null ) {
            return;
        }

        employee.setName( dto.getName() );
        employee.setRemarks( dto.getRemarks() );
    }

    @Override
    public EmployeeListResponse toEmployeeListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        EmployeeListResponse employeeListResponse = new EmployeeListResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            employeeListResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        employeeListResponse.metadata( baseApiResponse.getMetadata() );
        employeeListResponse.respType( baseApiResponse.getRespType() );
        employeeListResponse.status( baseApiResponse.getStatus() );

        return employeeListResponse;
    }

    @Override
    public EmployeeResponse toEmployeeResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        EmployeeResponse employeeResponse = new EmployeeResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            employeeResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        employeeResponse.metadata( baseApiResponse.getMetadata() );
        employeeResponse.respType( baseApiResponse.getRespType() );
        employeeResponse.status( baseApiResponse.getStatus() );

        return employeeResponse;
    }

    @Override
    public void updateEntityFromDto(EmployeeDto dto, Employee employee) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getDepartment() != null ) {
            if ( employee.getDepartment() == null ) {
                employee.setDepartment( Department.builder().build() );
            }
            departmentMapper.updateEntityFromDto( dto.getDepartment(), employee.getDepartment() );
        }
        else {
            employee.setDepartment( null );
        }
        if ( dto.getDesignation() != null ) {
            if ( employee.getDesignation() == null ) {
                employee.setDesignation( Designation.builder().build() );
            }
            designationDtoToDesignation( dto.getDesignation(), employee.getDesignation() );
        }
        else {
            employee.setDesignation( null );
        }
        employee.setId( dto.getId() );
        employee.setName( dto.getName() );
        employee.setRemarks( dto.getRemarks() );
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

    protected void designationDtoToDesignation(DesignationDto designationDto, Designation mappingTarget) {
        if ( designationDto == null ) {
            return;
        }

        mappingTarget.setDescription( designationDto.getDescription() );
        mappingTarget.setId( designationDto.getId() );
        mappingTarget.setName( designationDto.getName() );
    }
}
