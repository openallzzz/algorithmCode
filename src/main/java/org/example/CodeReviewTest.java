package org.example;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
public class CodeReviewTest {

    public static void main(String[] args) {
        // BigDecimal@toString
        BigDecimal decimal = new BigDecimal("0.00000000000009");
        log.info("new BigDecimal(\"0.10000000000009\") toString result = {}", decimal + "%");

        // 整数除法导致计算结果精度丢失
        double rec = 58 / 10;
        double rec1 = 58 / 10.0;
        log.info("58 / 10 结果 = {}", rec);
        log.info("58 / 10.0 结果 = {}", rec1);
    }

}
