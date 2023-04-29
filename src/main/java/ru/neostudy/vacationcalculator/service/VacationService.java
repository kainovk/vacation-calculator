package ru.neostudy.vacationcalculator.service;

import org.springframework.stereotype.Service;
import ru.neostudy.vacationcalculator.dto.VacationRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class VacationService {

    private final double AVERAGE_CALENDAR_DAYS = 29.3;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Double calculateVacation(VacationRequest request) {
        LocalDate start = request.getVacationStartDate();
        LocalDate end = request.getVacationEndDate();

        if (start.isAfter(end)) {
            throw new RuntimeException("Vacation start date is greater than end date");
        }

        long days = DAYS.between(start, end);
        double paidMonths = days / AVERAGE_CALENDAR_DAYS;
        Long salary = request.getAvgYearSalary();

        double result = salary * paidMonths;
        BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
