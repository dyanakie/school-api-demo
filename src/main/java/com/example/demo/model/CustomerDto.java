package com.example.demo.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
public class CustomerDto {
    private final String name;
    private final List<BankAccountDto> accounts;
}
