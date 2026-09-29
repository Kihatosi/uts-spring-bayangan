/**
*
*/
package com.uts.springuts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/travolta")
public class JohnTravoltaController {

    @GetMapping
    public Map<String, Object> getProfile() {
        Map<String, Object> data = new HashMap<>();
        data.put("nama", "John Joseph Travolta");
        data.put("profesi", "Aktor, Penyanyi, Pilot");
        data.put("peranIkonik", "Vincent Vega di film Pulp Fiction");
        data.put("filmTerkenal", List.of(
                "Saturday Night Fever (1977)",
                "Grease (1978)",
                "Pulp Fiction (1994)",
                "Face/Off (1997)"
        ));
        data.put("status", "Aktif");
        return data;
    }
}