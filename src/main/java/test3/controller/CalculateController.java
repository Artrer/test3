package test3.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test3.dto.CalculateRequestDto;
import test3.dto.CalculateResponseDto;
import test3.service.CalculateService;

/**
 * Контроллер для работы с запросами на вычисление
 */
@RestController
@RequestMapping("/calculate")
@Slf4j
@RequiredArgsConstructor
public class CalculateController {

    private final CalculateService calculateService;

    @PostMapping("")
    public ResponseEntity<CalculateResponseDto> calculate(@RequestBody CalculateRequestDto calculateRequestDto) {
        log.trace(calculateRequestDto.toString());
        return ResponseEntity.ok(calculateService.calculate(calculateRequestDto));
    }
}