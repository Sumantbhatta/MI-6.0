package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Equipment;
import com.machinarymgmt.service.api.data.model.MastAnchorageDetails;
import com.machinarymgmt.service.api.data.model.Project;
import com.machinarymgmt.service.dto.EquipmentSummaryDto;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
import com.machinarymgmt.service.dto.MastAnchorageDetailsDto;
import com.machinarymgmt.service.dto.MastAnchorageDetailsListResponse;
import com.machinarymgmt.service.dto.MastAnchorageDetailsRequestDto;
import com.machinarymgmt.service.dto.MastAnchorageDetailsResponse;
import com.machinarymgmt.service.dto.ProjectSummaryDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-13T15:41:59+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class MastAnchorageDetailsMapperImpl implements MastAnchorageDetailsMapper {

    @Override
    public MastAnchorageDetailsDto toDto(MastAnchorageDetails details) {
        if ( details == null ) {
            return null;
        }

        MastAnchorageDetailsDto mastAnchorageDetailsDto = new MastAnchorageDetailsDto();

        mastAnchorageDetailsDto.setId( details.getId() );
        mastAnchorageDetailsDto.setAnchorageAtSite( details.getAnchorageAtSite() );
        mastAnchorageDetailsDto.setAnchorageFixedAtSite( details.getAnchorageFixedAtSite() );
        mastAnchorageDetailsDto.setAnchorageIdleAtSite( details.getAnchorageIdleAtSite() );
        mastAnchorageDetailsDto.setMastAvailableAtSite( details.getMastAvailableAtSite() );
        mastAnchorageDetailsDto.setMastFixedAtSite( details.getMastFixedAtSite() );
        mastAnchorageDetailsDto.setMastIdleAtSite( details.getMastIdleAtSite() );
        mastAnchorageDetailsDto.setTotalAnchorageRequirement( details.getTotalAnchorageRequirement() );
        mastAnchorageDetailsDto.setTotalMastRequirement( details.getTotalMastRequirement() );
        mastAnchorageDetailsDto.setLocation( details.getLocation() );
        mastAnchorageDetailsDto.setPresentBuildingHeight( details.getPresentBuildingHeight() );
        mastAnchorageDetailsDto.setPresentHeightOfHoist( details.getPresentHeightOfHoist() );
        mastAnchorageDetailsDto.setRemarks( details.getRemarks() );
        mastAnchorageDetailsDto.setTotalBuildingHeight( details.getTotalBuildingHeight() );
        mastAnchorageDetailsDto.setStatus( details.getStatus() );
        mastAnchorageDetailsDto.setProject( projectToProjectSummaryDto( details.getProject() ) );
        mastAnchorageDetailsDto.setEquipment( equipmentToEquipmentSummaryDto( details.getEquipment() ) );

        return mastAnchorageDetailsDto;
    }

    @Override
    public List<MastAnchorageDetailsDto> toDtoList(List<MastAnchorageDetails> details) {
        if ( details == null ) {
            return null;
        }

        List<MastAnchorageDetailsDto> list = new ArrayList<MastAnchorageDetailsDto>( details.size() );
        for ( MastAnchorageDetails mastAnchorageDetails : details ) {
            list.add( toDto( mastAnchorageDetails ) );
        }

        return list;
    }

    @Override
    public MastAnchorageDetails toEntity(MastAnchorageDetailsRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        MastAnchorageDetails.MastAnchorageDetailsBuilder mastAnchorageDetails = MastAnchorageDetails.builder();

        mastAnchorageDetails.status( dto.getStatus() );
        mastAnchorageDetails.location( dto.getLocation() );
        mastAnchorageDetails.mastAvailableAtSite( dto.getMastAvailableAtSite() );
        mastAnchorageDetails.mastFixedAtSite( dto.getMastFixedAtSite() );
        mastAnchorageDetails.mastIdleAtSite( dto.getMastIdleAtSite() );
        mastAnchorageDetails.totalMastRequirement( dto.getTotalMastRequirement() );
        mastAnchorageDetails.anchorageAtSite( dto.getAnchorageAtSite() );
        mastAnchorageDetails.anchorageFixedAtSite( dto.getAnchorageFixedAtSite() );
        mastAnchorageDetails.anchorageIdleAtSite( dto.getAnchorageIdleAtSite() );
        mastAnchorageDetails.totalAnchorageRequirement( dto.getTotalAnchorageRequirement() );
        mastAnchorageDetails.presentHeightOfHoist( dto.getPresentHeightOfHoist() );
        mastAnchorageDetails.presentBuildingHeight( dto.getPresentBuildingHeight() );
        mastAnchorageDetails.totalBuildingHeight( dto.getTotalBuildingHeight() );
        mastAnchorageDetails.remarks( dto.getRemarks() );

        return mastAnchorageDetails.build();
    }

    @Override
    public MastAnchorageDetailsListResponse toMastAnchorageDetailsListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MastAnchorageDetailsListResponse mastAnchorageDetailsListResponse = new MastAnchorageDetailsListResponse();

        mastAnchorageDetailsListResponse.setRespType( baseApiResponse.getRespType() );
        mastAnchorageDetailsListResponse.setMetadata( baseApiResponse.getMetadata() );
        mastAnchorageDetailsListResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            mastAnchorageDetailsListResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return mastAnchorageDetailsListResponse;
    }

    @Override
    public MastAnchorageDetailsResponse toMastAnchorageDetailsResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MastAnchorageDetailsResponse mastAnchorageDetailsResponse = new MastAnchorageDetailsResponse();

        mastAnchorageDetailsResponse.setRespType( baseApiResponse.getRespType() );
        mastAnchorageDetailsResponse.setMetadata( baseApiResponse.getMetadata() );
        mastAnchorageDetailsResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            mastAnchorageDetailsResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return mastAnchorageDetailsResponse;
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
    public void updateEntityFromDto(MastAnchorageDetailsRequestDto dto, MastAnchorageDetails details) {
        if ( dto == null ) {
            return;
        }

        details.setStatus( dto.getStatus() );
        details.setLocation( dto.getLocation() );
        details.setMastAvailableAtSite( dto.getMastAvailableAtSite() );
        details.setMastFixedAtSite( dto.getMastFixedAtSite() );
        details.setMastIdleAtSite( dto.getMastIdleAtSite() );
        details.setTotalMastRequirement( dto.getTotalMastRequirement() );
        details.setAnchorageAtSite( dto.getAnchorageAtSite() );
        details.setAnchorageFixedAtSite( dto.getAnchorageFixedAtSite() );
        details.setAnchorageIdleAtSite( dto.getAnchorageIdleAtSite() );
        details.setTotalAnchorageRequirement( dto.getTotalAnchorageRequirement() );
        details.setPresentHeightOfHoist( dto.getPresentHeightOfHoist() );
        details.setPresentBuildingHeight( dto.getPresentBuildingHeight() );
        details.setTotalBuildingHeight( dto.getTotalBuildingHeight() );
        details.setRemarks( dto.getRemarks() );
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
}
