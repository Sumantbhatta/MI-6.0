package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.dto.EmployeeListResponse;
import com.machinarymgmt.service.dto.EmployeeResponse;


import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Department;
import com.machinarymgmt.service.api.data.model.Designation;
import com.machinarymgmt.service.api.data.model.Employee;
import com.machinarymgmt.service.dto.EmployeeDto;

import com.machinarymgmt.service.dto.EmployeeRequestDto;

//import com.machinarymgmt.service.dto.EmployeeRequestDto;

import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {DepartmentMapper.class, DesignationMapper.class}
)
public interface EmployeeMapper extends MachinaryMgmtMapper {

    EmployeeDto toDto(Employee employee);
    
    List<EmployeeDto> toDtoList(List<Employee> employees);

    Employee toEntity(EmployeeRequestDto dto);

//    EmployeeDto toEntity(EmployeeRequestDto dto);

    void updateEntityFromDto(EmployeeRequestDto dto, @MappingTarget Employee employee);

    EmployeeListResponse toEmployeeListResponse(BaseApiResponse baseApiResponse);

    EmployeeResponse toEmployeeResponse(BaseApiResponse baseApiResponse);

    void updateEntityFromDto(EmployeeDto dto, @MappingTarget Employee employee);
    
    default Employee fromDtoWithReferences(
            EmployeeRequestDto dto,
            Designation designation,
            Department department) {
        Employee employee = toEntity(dto);
        employee.setDesignation(designation);
        employee.setDepartment(department);
        return employee;
    }

    MachinaryMgmtBaseApiResponse toBaseApiResponse(BaseApiResponse baseApiResponse);
}


// package com.machinarymgmt.service.api.mapper;
// import com.machinarymgmt.service.dto.EmployeeListResponse;
// import com.machinarymgmt.service.dto.EmployeeResponse;
// import com.machinarymgmt.service.dto.ProjectRequestDto;
// import com.machinarymgmt.service.dto.EmployeeRequestDto;
// import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
// import com.machinarymgmt.service.api.data.model.Department;
// import com.machinarymgmt.service.api.data.model.Designation;
// import com.machinarymgmt.service.api.data.model.Employee;
// import com.machinarymgmt.service.api.data.model.Project;
// import com.machinarymgmt.service.dto.EmployeeDto;
// import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;
// import org.mapstruct.MappingTarget;
// import org.mapstruct.ReportingPolicy;

// import java.util.List;

// @Mapper(
//     componentModel = "spring",
//     unmappedTargetPolicy = ReportingPolicy.IGNORE,
//     uses = {DepartmentMapper.class, DesignationMapper.class}
// )
// public interface EmployeeMapper extends MachinaryMgmtMapper {

//     EmployeeDto toDto(Employee employee);

//     EmployeeRequestDto toEmployeeRequestDto(Employee employee);
    
//     List<EmployeeDto> toDtoList(List<Employee> employees);

//     Employee toEntity(EmployeeRequestDto dto);

//     void updateEntityFromDto(EmployeeDto dto, @MappingTarget Employee employee);

//     EmployeeListResponse toEmployeeListResponse(BaseApiResponse baseApiResponse);

//     EmployeeResponse toEmployeeResponse(BaseApiResponse baseApiResponse);
    
    
//     // default Employee fromDtoWithReferences(
//     //         EmployeeDto dto,
//     //         Designation designation,
//     //         Department department) {
//     //     Employee employee = toEntity(dto);
//     //     employee.setDesignation(designation);
//     //     employee.setDepartment(department);
//     //     return employee;
//     }
