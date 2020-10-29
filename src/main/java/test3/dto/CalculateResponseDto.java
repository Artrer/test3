package test3.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CalculateResponseDto {

    private List<Integer> result;
}