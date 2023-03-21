package com.drivas.springstatemachine.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class EventsDto {

    private Events event;

    private LocalDate date;

    private BigDecimal value;

    private States state;

}
