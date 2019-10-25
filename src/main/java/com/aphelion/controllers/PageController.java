package com.aphelion.controllers;

import com.aphelion.Main;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PageController {

    private long vistorCount = 0;

    @GetMapping(value = "/sol/{solNumber}")
    public String sol(Model model, @PathVariable String solNumber) {
        List<String> sols = Main.getWrapper().getSol_keys();
        for (int i = 0; i < sols.size(); i++) {
            model.addAttribute("sol"+i, sols.get(i));
        }

        try {
            model.addAttribute("solNum", solNumber);
            model.addAttribute("season", Main.getWrapper().getSol(solNumber).getSeason());
            model.addAttribute("firstUTC", Main.getWrapper().getSol(solNumber).getFirstUTC());

            model.addAttribute("maxTemp", Main.getWrapper().getSol(solNumber).getTemp().getMax());
            model.addAttribute("minTemp", Main.getWrapper().getSol(solNumber).getTemp().getMin());
            model.addAttribute("avgTemp", Main.getWrapper().getSol(solNumber).getTemp().getAvg());

            model.addAttribute("maxWind", Main.getWrapper().getSol(solNumber).getWindSpeed().getMax());
            model.addAttribute("minWind", Main.getWrapper().getSol(solNumber).getWindSpeed().getMin());
            model.addAttribute("avgWind", Main.getWrapper().getSol(solNumber).getWindSpeed().getAvg());

            model.addAttribute("maxPress", Main.getWrapper().getSol(solNumber).getPressure().getMax());
            model.addAttribute("minPress", Main.getWrapper().getSol(solNumber).getPressure().getMin());
            model.addAttribute("avgPress", Main.getWrapper().getSol(solNumber).getPressure().getAvg());
        } catch (NullPointerException e) {

        }
        return "sol";
    }

    @GetMapping(value = "/")
    public String home(Model model) {
        vistorCount++;
        model.addAttribute("vistorCount", vistorCount);
        List<String> sols = Main.getWrapper().getSol_keys();
        for (int i = 0; i < sols.size(); i++) {
            model.addAttribute("sol"+i, sols.get(i));
        }
        return "index";
    }
}
