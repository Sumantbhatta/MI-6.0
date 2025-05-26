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
    date = "2025-05-26T16:53:17+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
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

        mastAnchorageDetails.anchorageAtSite( dto.getAnchorageAtSite() );
        mastAnchorageDetails.anchorageFixedAtSite( dto.getAnchorageFixedAtSite() );
        mastAnchorageDetails.anchorageIdleAtSite( dto.getAnchorageIdleAtSite() );
        mastAnchorageDetails.location( dto.getLocation() );
        mastAnchorageDetails.mastAvailableAtSite( dto.getMastAvailableAtSite() );
        mastAnchorageDetails.mastFixedAtSite( dto.getMastFixedAtSite() );
        mastAnchorageDetails.mastIdleAtSite( dto.getMastIdleAtSite() );
        mastAnchorageDetails.presentBuildingHeight( dto.getPresentBuildingHeight() );
        mastAnchorageDetails.presentHeightOfHoist( dto.getPresentHeightOfHoist() );
        mastAnchorageDetails.remarks( dto.getRemarks() );
        mastAnchorageDetails.status( dto.getStatus() );
        mastAnchorageDetails.totalAnchorageRequirement( dto.getTotalAnchorageRequirement() );
        mastAnchorageDetails.totalBuildingHeight( dto.getTotalBuildingHeight() );
        mastAnchorageDetails.totalMastRequirement( dto.getTotalMastRequirement() );

        return mastAnchorageDetails.build();
    }

    @Override
    public MastAnchorageDetailsListResponse toMastAnchorageDetailsListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MastAnchorageDetailsListResponse mastAnchorageDetailsListResponse = new MastAnchorageDetailsListResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            mastAnchorageDetailsListResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        mastAnchorageDetailsListResponse.metadata( baseApiResponse.getMetadata() );
        mastAnchorageDetailsListResponse.respType( baseApiResponse.getRespType() );
        mastAnchorageDetailsListResponse.status( baseApiResponse.getStatus() );

        return mastAnchorageDetailsListResponse;
    }

    @Override
    public MastAnchorageDetailsResponse toMastAnchorageDetailsResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MastAnchorageDetailsResponse mastAnchorageDetailsResponse = new MastAnchorageDetailsResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            mastAnchorageDetailsResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        mastAnchorageDetailsResponse.metadata( baseApiResponse.getMetadata() );
        mastAnchorageDetailsResponse.respType( baseApiResponse.getRespType() );
        mastAnchorageDetailsResponse.status( baseApiResponse.getStatus() );

        return mastAnchorageDetailsResponse;
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

    @Override
    public void updateEntityFromDto(MastAnchorageDetailsRequestDto dto, MastAnchorageDetails details) {
        if ( dto == null ) {
            return;
        }

        details.setAnchorageAtSite( dto.getAnchorageAtSite() );
        details.setAnchorageFixedAtSite( dto.getAnchorageFixedAtSite() );
        details.setAnchorageIdleAtSite( dto.getAnchorageIdleAtSite() );
        details.setLocation( dto.getLocation() );
        details.setMastAvailableAtSite( dto.getMastAvailableAtSite() );
        details.setMastFixedAtSite( dto.getMastFixedAtSite() );
        details.setMastIdleAtSite( dto.getMastIdleAtSite() );
        details.setPresentBuildingHeight( dto.getPresentBuildingHeight() );
        details.setPresentHeightOfHoist( dto.getPresentHeightOfHoist() );
        details.setRemarks( dto.getRemarks() );
        details.setStatus( dto.getStatus() );
        details.setTotalAnchorageRequirement( dto.getTotalAnchorageRequirement() );
        details.setTotalBuildingHeight( dto.getTotalBuildingHeight() );
        details.setTotalMastRequirement( dto.getTotalMastRequirement() );
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
