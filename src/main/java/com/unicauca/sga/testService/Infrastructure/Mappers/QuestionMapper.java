package com.unicauca.sga.testService.Infrastructure.Mappers;

import com.unicauca.sga.testService.Domain.Model.Question;
import com.unicauca.sga.testService.Infrastructure.Persistence.Tables.QuestionTable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question toModel(QuestionTable questionTable);
    QuestionTable toInfra (Question question);
}
