package test3.dto;


import lombok.Data;

import java.util.List;

@Data
public class CalculateRequestDto {

    private List<Integer> numbers;

    private Operation operation;
}