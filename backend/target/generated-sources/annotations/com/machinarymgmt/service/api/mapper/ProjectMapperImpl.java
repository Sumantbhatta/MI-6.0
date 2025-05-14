package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Project;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
import com.machinarymgmt.service.dto.ProjectDto;
import com.machinarymgmt.service.dto.ProjectListResponse;
import com.machinarymgmt.service.dto.ProjectRequestDto;
import com.machinarymgmt.service.dto.ProjectResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectDto toDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        projectDto.setId( project.getId() );
        projectDto.setName( project.getName() );
        projectDto.setDescription( project.getDescription() );
        projectDto.setLocation( project.getLocation() );
        if ( project.getStartDate() != null ) {
            projectDto.setStartDate( LocalDate.parse( project.getStartDate() ) );
        }
        if ( project.getEndDate() != null ) {
            projectDto.setEndDate( LocalDate.parse( project.getEndDate() ) );
        }
        projectDto.setStatus( project.getStatus() );

        return projectDto;
    }

    @Override
    public ProjectRequestDto toRequestDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectRequestDto projectRequestDto = new ProjectRequestDto();

        projectRequestDto.setName( project.getName() );
        projectRequestDto.setDescription( project.getDescription() );
        projectRequestDto.setLocation( project.getLocation() );
        if ( project.getStartDate() != null ) {
            projectRequestDto.setStartDate( LocalDate.parse( project.getStartDate() ) );
        }
        if ( project.getEndDate() != null ) {
            projectRequestDto.setEndDate( LocalDate.parse( project.getEndDate() ) );
        }
        projectRequestDto.setStatus( project.getStatus() );

        return projectRequestDto;
    }

    @Override
    public List<ProjectDto> toDtoList(List<Project> projects) {
        if ( projects == null ) {
            return null;
        }

        List<ProjectDto> list = new ArrayList<ProjectDto>( projects.size() );
        for ( Project project : projects ) {
            list.add( toDto( project ) );
        }

        return list;
    }

    @Override
    public Project toEntity(ProjectRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.name( dto.getName() );
        project.location( dto.getLocation() );
        project.description( dto.getDescription() );
        if ( dto.getStartDate() != null ) {
            project.startDate( DateTimeFormatter.ISO_LOCAL_DATE.format( dto.getStartDate() ) );
        }
        if ( dto.getEndDate() != null ) {
            project.endDate( DateTimeFormatter.ISO_LOCAL_DATE.format( dto.getEndDate() ) );
        }
        project.status( dto.getStatus() );

        return project.build();
    }

    @Override
    public void updateEntityFromDto(ProjectRequestDto dto, Project project) {
        if ( dto == null ) {
            return;
        }

        project.setName( dto.getName() );
        project.setLocation( dto.getLocation() );
        project.setDescription( dto.getDescription() );
        if ( dto.getStartDate() != null ) {
            project.setStartDate( DateTimeFormatter.ISO_LOCAL_DATE.format( dto.getStartDate() ) );
        }
        else {
            project.setStartDate( null );
        }
        if ( dto.getEndDate() != null ) {
            project.setEndDate( DateTimeFormatter.ISO_LOCAL_DATE.format( dto.getEndDate() ) );
        }
        else {
            project.setEndDate( null );
        }
        project.setStatus( dto.getStatus() );
    }

    @Override
    public ProjectListResponse toProjectListResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        ProjectListResponse projectListResponse = new ProjectListResponse();

        projectListResponse.setRespType( baseApiResponse.getRespType() );
        projectListResponse.setMetadata( baseApiResponse.getMetadata() );
        projectListResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            projectListResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return projectListResponse;
    }

    @Override
    public ProjectResponse toProjectResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        ProjectResponse projectResponse = new ProjectResponse();

        projectResponse.setRespType( baseApiResponse.getRespType() );
        projectResponse.setMetadata( baseApiResponse.getMetadata() );
        projectResponse.setStatus( baseApiResponse.getStatus() );
        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            projectResponse.setMessages( new ArrayList<ApiMessage>( list ) );
        }

        return projectResponse;
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
