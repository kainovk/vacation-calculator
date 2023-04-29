package ru.neostudy.vacationcalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.neostudy.vacationcalculator.dto.VacationRequest;
import ru.neostudy.vacationcalculator.service.VacationService;

@RestController
public class VacationController {

    private final VacationService vacationService;

    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @GetMapping("/calculate")
    public Double calculateVacation(@RequestBody VacationRequest request) {
        return vacationService.calculateVacation(request);
    }
}
