package com.unicauca.sga.testService.Infrastructure.Controllers;

import com.unicauca.sga.testService.Aplication.UseCases.TakeTestService;
import com.unicauca.sga.testService.Domain.Model.DTOs.QuestionListDTO;
import com.unicauca.sga.testService.Domain.Model.DTOs.StudentTestResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/takeTest")
@Tag(name="Controlador Presentar Test", description = "Funcionalidades necesarias para presentar el examen general del laboratorio.")
public class TakeTestController {

    private final TakeTestService takeTestService;

    public TakeTestController(TakeTestService takeTestService){
        this.takeTestService=takeTestService;
    }

    @Operation(summary = "Obtener las preguntas del Test",
            description = "Valida que el nombre del profesor, codigo de estudiante y materia esten "+
                            "registrados y retorna las preguntas del Test (20 preguntas). Si alguno de "+
                            "los datos no es valido retorna un IllegalArgumentException con el codigo de la excepcion." +
                            "(GTQ1: nombre del profesor no valido, GTQ2: codigo del estudiante no valido, GTQ3: materia no valida)")
    @GetMapping
    public QuestionListDTO getTestQuestions(@RequestParam("subject_name") String subject_name,
                                                            @RequestParam("student_code")Long student_code,
                                                            @RequestParam("teacher_name") String teacher_name){
        return takeTestService.getTestQuestions(subject_name,student_code,teacher_name);
    }

    @Operation(summary = "Guardar y calificar test",
                description = "Recibe las preguntas respondidas por el estudiante, " +
                                "calcula la calificacion y guarda los datos del test, sin almacenar las preguntas y respuestas. ")
    @PostMapping
    public float saveAndScoreTest(@RequestBody StudentTestResponseDTO studentTestResponseDTO){
        return takeTestService.saveTest(studentTestResponseDTO);
    }

}
