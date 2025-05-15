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
    date = "2025-05-15T11:58:38+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
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

        employeeAssignment.id( dto.getId() );
        employeeAssignment.employee( employeeSummaryDtoToEmployee( dto.getEmployee() ) );
        employeeAssignment.project( projectSummaryDtoToProject( dto.getProject() ) );
        employeeAssignment.equipment( equipmentSummaryDtoToEquipment( dto.getEquipment() ) );
        employeeAssignment.joiningDate( dto.getJoiningDate() );

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

        employeeAssignmentListResponse.setRespType( baseApiResponse.getRespType() );
        employeeAssignmentListResponse.setMetadata( baseApiResponse.getMetadata() );
        employeeAssignmentListResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            employeeAssignmentListResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return employeeAssignmentListResponse;
    }

    @Override
    public EmployeeAssignmentResponse toEmployeeAssignmentResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        EmployeeAssignmentResponse employeeAssignmentResponse = new EmployeeAssignmentResponse();

        employeeAssignmentResponse.setRespType( baseApiResponse.getRespType() );
        employeeAssignmentResponse.setMetadata( baseApiResponse.getMetadata() );
        employeeAssignmentResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            employeeAssignmentResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return employeeAssignmentResponse;
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

    protected Project projectSummaryDtoToProject(ProjectSummaryDto projectSummaryDto) {
        if ( projectSummaryDto == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.id( projectSummaryDto.getId() );
        project.name( projectSummaryDto.getName() );

        return project.build();
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
}
