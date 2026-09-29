package com.uts.springuts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/kuadrat")
public class PersamaanKuadratController {

    @GetMapping("/hitung")
    public Map<String, Object> hitungKuadrat(
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam double c) {

        Map<String, Object> response = new HashMap<>();
        response.put("rumus", a + "x^2 + (" + b + "x) + (" + c + ") = 0");

        if (a == 0) {
            response.put("error", "Bukan persamaan kuadrat karena nilai a = 0");
            return response;
        }

        double determinan = (b * b) - (4 * a * c);
        response.put("determinan", determinan);

        if (determinan > 0) {
            double x1 = (-b + Math.sqrt(determinan)) / (2 * a);
            double x2 = (-b - Math.sqrt(determinan)) / (2 * a);
            response.put("tipeAkar", "Dua akar riil berbeda");
            response.put("x1", x1);
            response.put("x2", x2);
        } else if (determinan == 0) {
            double x = -b / (2 * a);
            response.put("tipeAkar", "Akar riil kembar");
            response.put("x1", x);
            response.put("x2", x);
        } else {
            response.put("tipeAkar", "Akar imajiner (tidak ada solusi riil)");
            double bagianRiil = -b / (2 * a);
            double bagianImajiner = Math.sqrt(-determinan) / (2 * a);
            response.put("x1", String.format("%.2f + %.2fi", bagianRiil, bagianImajiner));
            response.put("x2", String.format("%.2f - %.2fi", bagianRiil, bagianImajiner));
        }

        return response;
    }
}