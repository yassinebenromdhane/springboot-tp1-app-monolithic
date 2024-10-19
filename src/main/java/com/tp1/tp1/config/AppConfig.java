package com.tp1.tp1.config;

import com.tp1.tp1.dtos.ProjectDto;
import com.tp1.tp1.entities.Project;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(Project.class, ProjectDto.class).addMappings(mapper ->
                mapper.map(src -> src.getUser().getId(), ProjectDto::setUserId)
        );
        return modelMapper;
    }
}