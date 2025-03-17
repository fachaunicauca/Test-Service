package com.unicauca.sga.testService.Infrastructure.Persistence.Mappers;

import com.unicauca.sga.testService.Domain.Model.Answer;
import com.unicauca.sga.testService.Infrastructure.Persistence.Tables.AnswerTable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer toModel(AnswerTable answerTable);
    AnswerTable toInfra(Answer answer);
}
