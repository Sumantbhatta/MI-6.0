package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Employee;
import com.machinarymgmt.service.api.data.model.EmployeeAssignment;
import com.machinarymgmt.service.api.data.model.Equipment;
import com.machinarymgmt.service.api.data.model.Project;
import com.machinarymgmt.service.dto.EmployeeAssignmentDto;
import com.machinarymgmt.service.dto.EmployeeAssignmentListResponse;
import com.machinarymgmt.service.dto.EmployeeAssignmentRequestDto;
import com.machinarymgmt.service.dto.EmployeeAssignmentResponse;
import com.machinarymgmt.service.dto.EmployeeSummaryDto;
import com.machinarymgmt.service.dto.EquipmentSummaryDto;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
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
public class EmployeeAssignmentMapperImpl implements EmployeeAssignmentMapper {

    @Override
    public EmployeeAssignmentDto toDto(EmployeeAssignment assignment) {
        if ( assignment == null ) {
            return null;
        }

        EmployeeAssignmentDto employeeAssignmentDto = new EmployeeAssignmentDto();

        employeeAssignmentDto.setId( assignment.getId() );
        employeeAssignmentDto.setJoiningDate( assignment.getJoiningDate() );
        employeeAssignmentDto.setEmployee( employeeToEmployeeSummaryDto( assignment.getEmployee() ) );
        employeeAssignmentDto.setProject( projectToProjectSummaryDto( assignment.getProject() ) );
        employeeAssignmentDto.setEquipment( equipmentToEquipmentSummaryDto( assignment.getEquipment() ) );

        return employeeAssignmentDto;
    }

    @Override
    public List<EmployeeAssignmentDto> toDtoList(List<EmployeeAssignment> assignments) {
        if ( assignments == null ) {
            return null;
        }

        List<EmployeeAssignmentDto> list = new ArrayList<EmployeeAssignmentDto>( assignments.size() );
        for ( EmployeeAssignment employeeAssignment : assignments ) {
            list.add( toDto( employeeAssignment ) );
        }

        return list;
    }

    @Override
    public EmployeeAssignment toEntity(EmployeeAssignmentDto dto) {
        if ( dto == null ) {
            return null;
        }

        EmployeeAssignment.EmployeeAssignmentBuilder employeeAssignment = EmployeeAssignment.builder();

        employeeAssignment.employee( employeeSummaryDtoToEmployee( dto.getEmployee() ) );
        employeeAssignment.equipment( equipmentSummaryDtoToEquipment( dto.getEquipment() ) );
        employeeAssignment.id( dto.getId() );
        employeeAssignment.joiningDate( dto.getJoiningDate() );
        employeeAssignment.project( projectSummaryDtoToProject( dto.getProject() ) );

        return employeeAssignment.build();
    }

    @Override
    public EmployeeAssignment toEntity(EmployeeAssignmentRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        EmployeeAssignment.EmployeeAssignmentBuilder employeeAssignment = EmployeeAssignment.builder();

        employeeAssignment.joiningDate( dto.getJoiningDate() );

        return employeeAssignment.build();
    }

    @Override
    public void updateEntityFromDto(EmployeeAssignmentRequestDto dto, EmployeeAssignment assignment) {
        if ( dto == null ) {
            return;
        }

        assignment.setJoiningDate( dto.getJoiningDate() );
    }

    @Override
    public EmployeeAssignmentListResponse toEmployeeAssignmentListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        EmployeeAssignmentListResponse employeeAssignmentListResponse = new EmployeeAssignmentListResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            employeeAssignmentListResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        employeeAssignmentListResponse.metadata( baseApiResponse.getMetadata() );
        employeeAssignmentListResponse.respType( baseApiResponse.getRespType() );
        employeeAssignmentListResponse.status( baseApiResponse.getStatus() );

        return employeeAssignmentListResponse;
    }

    @Override
    public EmployeeAssignmentResponse toEmployeeAssignmentResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        EmployeeAssignmentResponse employeeAssignmentResponse = new EmployeeAssignmentResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            employeeAssignmentResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        employeeAssignmentResponse.metadata( baseApiResponse.getMetadata() );
        employeeAssignmentResponse.respType( baseApiResponse.getRespType() );
        employeeAssignmentResponse.status( baseApiResponse.getStatus() );

        return employeeAssignmentResponse;
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

    protected EmployeeSummaryDto employeeToEmployeeSummaryDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeSummaryDto employeeSummaryDto = new EmployeeSummaryDto();

        employeeSummaryDto.setId( employee.getId() );
        employeeSummaryDto.setName( employee.getName() );

        return employeeSummaryDto;
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

    protected EquipmentSummaryDto equipmentToEquipmentSummaryDto(Equipment equipment) {
        if ( equipment == null ) {
            return null;
        }

        EquipmentSummaryDto equipmentSummaryDto = new EquipmentSummaryDto();

        equipmentSummaryDto.setId( equipment.getId() );
        equipmentSummaryDto.setName( equipment.getName() );

        return equipmentSummaryDto;
    }

    protected Employee employeeSummaryDtoToEmployee(EmployeeSummaryDto employeeSummaryDto) {
        if ( employeeSummaryDto == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.id( employeeSummaryDto.getId() );
        employee.name( employeeSummaryDto.getName() );

        return employee.build();
    }

    protected Equipment equipmentSummaryDtoToEquipment(EquipmentSummaryDto equipmentSummaryDto) {
        if ( equipmentSummaryDto == null ) {
            return null;
        }

        Equipment.EquipmentBuilder equipment = Equipment.builder();

        equipment.id( equipmentSummaryDto.getId() );
        equipment.name( equipmentSummaryDto.getName() );

        return equipment.build();
    }

    protected Project projectSummaryDtoToProject(ProjectSummaryDto projectSummaryDto) {
        if ( projectSummaryDto == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.id( projectSummaryDto.getId() );
        project.name( projectSummaryDto.getName() );

        return project.build();
    }
}
