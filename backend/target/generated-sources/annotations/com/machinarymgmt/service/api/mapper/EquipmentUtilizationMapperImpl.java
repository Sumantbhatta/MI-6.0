package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Equipment;
import com.machinarymgmt.service.api.data.model.EquipmentUtilization;
import com.machinarymgmt.service.api.data.model.Project;
import com.machinarymgmt.service.dto.EquipmentSummaryDto;
import com.machinarymgmt.service.dto.EquipmentUtilizationDto;
import com.machinarymgmt.service.dto.EquipmentUtilizationListResponse;
import com.machinarymgmt.service.dto.EquipmentUtilizationRequestDto;
import com.machinarymgmt.service.dto.EquipmentUtilizationResponse;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
import com.machinarymgmt.service.dto.ProjectSummaryDto;
import java.math.BigDecimal;
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
public class EquipmentUtilizationMapperImpl implements EquipmentUtilizationMapper {

    @Override
    public EquipmentUtilizationDto toDto(EquipmentUtilization utilization) {
        if ( utilization == null ) {
            return null;
        }

        EquipmentUtilizationDto equipmentUtilizationDto = new EquipmentUtilizationDto();

        equipmentUtilizationDto.setId( utilization.getId() );
        if ( utilization.getStartingHoursKms() != null ) {
            equipmentUtilizationDto.setStartingHoursKms( utilization.getStartingHoursKms().doubleValue() );
        }
        if ( utilization.getTargetHoursKms() != null ) {
            equipmentUtilizationDto.setTargetHoursKms( utilization.getTargetHoursKms().doubleValue() );
        }
        if ( utilization.getClosingHoursKms() != null ) {
            equipmentUtilizationDto.setClosingHoursKms( utilization.getClosingHoursKms().doubleValue() );
        }
        if ( utilization.getBreakdownHoursKms() != null ) {
            equipmentUtilizationDto.setBreakdownHoursKms( utilization.getBreakdownHoursKms().doubleValue() );
        }
        if ( utilization.getAvailabilityHours() != null ) {
            equipmentUtilizationDto.setAvailabilityHours( utilization.getAvailabilityHours().doubleValue() );
        }
        if ( utilization.getDieselConsumedLtrs() != null ) {
            equipmentUtilizationDto.setDieselConsumedLtrs( utilization.getDieselConsumedLtrs().doubleValue() );
        }
        if ( utilization.getAvgFuelConsumption() != null ) {
            equipmentUtilizationDto.setAvgFuelConsumption( utilization.getAvgFuelConsumption().doubleValue() );
        }
        if ( utilization.getUtilizationPercentage() != null ) {
            equipmentUtilizationDto.setUtilizationPercentage( utilization.getUtilizationPercentage().doubleValue() );
        }
        if ( utilization.getMonth() != null ) {
            equipmentUtilizationDto.setMonth( utilization.getMonth().longValue() );
        }
        if ( utilization.getYear() != null ) {
            equipmentUtilizationDto.setYear( utilization.getYear().longValue() );
        }
        equipmentUtilizationDto.setRemarks( utilization.getRemarks() );
        equipmentUtilizationDto.setEquipment( equipmentToEquipmentSummaryDto( utilization.getEquipment() ) );
        equipmentUtilizationDto.setProject( projectToProjectSummaryDto( utilization.getProject() ) );

        return equipmentUtilizationDto;
    }

    @Override
    public List<EquipmentUtilizationDto> toDtoList(List<EquipmentUtilization> utilizations) {
        if ( utilizations == null ) {
            return null;
        }

        List<EquipmentUtilizationDto> list = new ArrayList<EquipmentUtilizationDto>( utilizations.size() );
        for ( EquipmentUtilization equipmentUtilization : utilizations ) {
            list.add( toDto( equipmentUtilization ) );
        }

        return list;
    }

    @Override
    public EquipmentUtilization toEntity(EquipmentUtilizationDto dto) {
        if ( dto == null ) {
            return null;
        }

        EquipmentUtilization.EquipmentUtilizationBuilder equipmentUtilization = EquipmentUtilization.builder();

        equipmentUtilization.id( dto.getId() );
        equipmentUtilization.equipment( equipmentSummaryDtoToEquipment( dto.getEquipment() ) );
        equipmentUtilization.project( projectSummaryDtoToProject( dto.getProject() ) );
        if ( dto.getMonth() != null ) {
            equipmentUtilization.month( dto.getMonth().intValue() );
        }
        if ( dto.getYear() != null ) {
            equipmentUtilization.year( dto.getYear().intValue() );
        }
        if ( dto.getTargetHoursKms() != null ) {
            equipmentUtilization.targetHoursKms( BigDecimal.valueOf( dto.getTargetHoursKms() ) );
        }
        if ( dto.getStartingHoursKms() != null ) {
            equipmentUtilization.startingHoursKms( BigDecimal.valueOf( dto.getStartingHoursKms() ) );
        }
        if ( dto.getClosingHoursKms() != null ) {
            equipmentUtilization.closingHoursKms( BigDecimal.valueOf( dto.getClosingHoursKms() ) );
        }
        if ( dto.getBreakdownHoursKms() != null ) {
            equipmentUtilization.breakdownHoursKms( BigDecimal.valueOf( dto.getBreakdownHoursKms() ) );
        }
        if ( dto.getDieselConsumedLtrs() != null ) {
            equipmentUtilization.dieselConsumedLtrs( BigDecimal.valueOf( dto.getDieselConsumedLtrs() ) );
        }
        if ( dto.getAvgFuelConsumption() != null ) {
            equipmentUtilization.avgFuelConsumption( BigDecimal.valueOf( dto.getAvgFuelConsumption() ) );
        }
        if ( dto.getAvailabilityHours() != null ) {
            equipmentUtilization.availabilityHours( BigDecimal.valueOf( dto.getAvailabilityHours() ) );
        }
        if ( dto.getUtilizationPercentage() != null ) {
            equipmentUtilization.utilizationPercentage( BigDecimal.valueOf( dto.getUtilizationPercentage() ) );
        }
        equipmentUtilization.remarks( dto.getRemarks() );

        return equipmentUtilization.build();
    }

    @Override
    public EquipmentUtilization toEntity(EquipmentUtilizationRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        EquipmentUtilization.EquipmentUtilizationBuilder equipmentUtilization = EquipmentUtilization.builder();

        if ( dto.getMonth() != null ) {
            equipmentUtilization.month( dto.getMonth().intValue() );
        }
        if ( dto.getYear() != null ) {
            equipmentUtilization.year( dto.getYear().intValue() );
        }
        if ( dto.getTargetHoursKms() != null ) {
            equipmentUtilization.targetHoursKms( BigDecimal.valueOf( dto.getTargetHoursKms() ) );
        }
        if ( dto.getStartingHoursKms() != null ) {
            equipmentUtilization.startingHoursKms( BigDecimal.valueOf( dto.getStartingHoursKms() ) );
        }
        if ( dto.getClosingHoursKms() != null ) {
            equipmentUtilization.closingHoursKms( BigDecimal.valueOf( dto.getClosingHoursKms() ) );
        }
        if ( dto.getBreakdownHoursKms() != null ) {
            equipmentUtilization.breakdownHoursKms( BigDecimal.valueOf( dto.getBreakdownHoursKms() ) );
        }
        if ( dto.getDieselConsumedLtrs() != null ) {
            equipmentUtilization.dieselConsumedLtrs( BigDecimal.valueOf( dto.getDieselConsumedLtrs() ) );
        }
        if ( dto.getAvgFuelConsumption() != null ) {
            equipmentUtilization.avgFuelConsumption( BigDecimal.valueOf( dto.getAvgFuelConsumption() ) );
        }
        if ( dto.getAvailabilityHours() != null ) {
            equipmentUtilization.availabilityHours( BigDecimal.valueOf( dto.getAvailabilityHours() ) );
        }
        if ( dto.getUtilizationPercentage() != null ) {
            equipmentUtilization.utilizationPercentage( BigDecimal.valueOf( dto.getUtilizationPercentage() ) );
        }
        equipmentUtilization.remarks( dto.getRemarks() );

        return equipmentUtilization.build();
    }

    @Override
    public void updateEntityFromDto(EquipmentUtilizationRequestDto dto, EquipmentUtilization utilization) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getMonth() != null ) {
            utilization.setMonth( dto.getMonth().intValue() );
        }
        else {
            utilization.setMonth( null );
        }
        if ( dto.getYear() != null ) {
            utilization.setYear( dto.getYear().intValue() );
        }
        else {
            utilization.setYear( null );
        }
        if ( dto.getTargetHoursKms() != null ) {
            utilization.setTargetHoursKms( BigDecimal.valueOf( dto.getTargetHoursKms() ) );
        }
        else {
            utilization.setTargetHoursKms( null );
        }
        if ( dto.getStartingHoursKms() != null ) {
            utilization.setStartingHoursKms( BigDecimal.valueOf( dto.getStartingHoursKms() ) );
        }
        else {
            utilization.setStartingHoursKms( null );
        }
        if ( dto.getClosingHoursKms() != null ) {
            utilization.setClosingHoursKms( BigDecimal.valueOf( dto.getClosingHoursKms() ) );
        }
        else {
            utilization.setClosingHoursKms( null );
        }
        if ( dto.getBreakdownHoursKms() != null ) {
            utilization.setBreakdownHoursKms( BigDecimal.valueOf( dto.getBreakdownHoursKms() ) );
        }
        else {
            utilization.setBreakdownHoursKms( null );
        }
        if ( dto.getDieselConsumedLtrs() != null ) {
            utilization.setDieselConsumedLtrs( BigDecimal.valueOf( dto.getDieselConsumedLtrs() ) );
        }
        else {
            utilization.setDieselConsumedLtrs( null );
        }
        if ( dto.getAvgFuelConsumption() != null ) {
            utilization.setAvgFuelConsumption( BigDecimal.valueOf( dto.getAvgFuelConsumption() ) );
        }
        else {
            utilization.setAvgFuelConsumption( null );
        }
        if ( dto.getAvailabilityHours() != null ) {
            utilization.setAvailabilityHours( BigDecimal.valueOf( dto.getAvailabilityHours() ) );
        }
        else {
            utilization.setAvailabilityHours( null );
        }
        if ( dto.getUtilizationPercentage() != null ) {
            utilization.setUtilizationPercentage( BigDecimal.valueOf( dto.getUtilizationPercentage() ) );
        }
        else {
            utilization.setUtilizationPercentage( null );
        }
        utilization.setRemarks( dto.getRemarks() );
    }

    @Override
    public EquipmentUtilizationListResponse toEquipmentUtilizationListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        EquipmentUtilizationListResponse equipmentUtilizationListResponse = new EquipmentUtilizationListResponse();

        equipmentUtilizationListResponse.setRespType( baseApiResponse.getRespType() );
        equipmentUtilizationListResponse.setMetadata( baseApiResponse.getMetadata() );
        equipmentUtilizationListResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            equipmentUtilizationListResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return equipmentUtilizationListResponse;
    }

    @Override
    public EquipmentUtilizationResponse toEquipmentUtilizationResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        EquipmentUtilizationResponse equipmentUtilizationResponse = new EquipmentUtilizationResponse();

        equipmentUtilizationResponse.setRespType( baseApiResponse.getRespType() );
        equipmentUtilizationResponse.setMetadata( baseApiResponse.getMetadata() );
        equipmentUtilizationResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            equipmentUtilizationResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return equipmentUtilizationResponse;
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

    protected EquipmentSummaryDto equipmentToEquipmentSummaryDto(Equipment equipment) {
        if ( equipment == null ) {
            return null;
        }

        EquipmentSummaryDto equipmentSummaryDto = new EquipmentSummaryDto();

        equipmentSummaryDto.setId( equipment.getId() );
        equipmentSummaryDto.setName( equipment.getName() );

        return equipmentSummaryDto;
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
