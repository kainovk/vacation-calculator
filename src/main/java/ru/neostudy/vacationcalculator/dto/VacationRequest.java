package ru.neostudy.vacationcalculator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class VacationRequest {
    @JsonProperty("salary")
    private final Long avgYearSalary;
    @JsonProperty("start_date")
    private final LocalDate vacationStartDate;
    @JsonProperty("end_date")
    private final LocalDate vacationEndDate;

    public VacationRequest(Long avgYearSalary, LocalDate vacationStartDate, LocalDate vacationEndDate) {
        this.avgYearSalary = avgYearSalary;
        this.vacationStartDate = vacationStartDate;
        this.vacationEndDate = vacationEndDate;
    }

    public Long getAvgYearSalary() {
        return avgYearSalary;
    }

    public LocalDate getVacationStartDate() {
        return vacationStartDate;
    }

    public LocalDate getVacationEndDate() {
        return vacationEndDate;
    }
}
