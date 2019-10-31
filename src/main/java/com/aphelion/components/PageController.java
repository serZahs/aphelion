package com.aphelion.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private RestService service;

    @GetMapping(value = "/sol/{solNumber}")
    public String sol(Model model, @PathVariable String solNumber) {
        List<String> sols = service.getSolData().getSolKeys();
        model.addAttribute("listOfSols", sols);

        try {
            model.addAttribute("solNum", solNumber);
            model.addAttribute("season", service.getSolData().getSol(solNumber).getSeason());
            model.addAttribute("firstUTC", service.getSolData().getSol(solNumber).getFirstUTC());

            model.addAttribute("maxTemp", service.getSolData().getSol(solNumber).getTemp().getMax());
            model.addAttribute("minTemp", service.getSolData().getSol(solNumber).getTemp().getMin());
            model.addAttribute("avgTemp", service.getSolData().getSol(solNumber).getTemp().getAvg());

            model.addAttribute("maxWind", service.getSolData().getSol(solNumber).getWindSpeed().getMax());
            model.addAttribute("minWind", service.getSolData().getSol(solNumber).getWindSpeed().getMin());
            model.addAttribute("avgWind", service.getSolData().getSol(solNumber).getWindSpeed().getAvg());

            model.addAttribute("maxPress", service.getSolData().getSol(solNumber).getPressure().getMax());
            model.addAttribute("minPress", service.getSolData().getSol(solNumber).getPressure().getMin());
            model.addAttribute("avgPress", service.getSolData().getSol(solNumber).getPressure().getAvg());
        } catch (NullPointerException e) {

        }
        return "sol";
    }

    @GetMapping(value = "/")
    public String home(Model model) {
        List<String> sols = service.getSolData().getSolKeys();
        model.addAttribute("listOfSols", sols);
        return "index";
    }
}
