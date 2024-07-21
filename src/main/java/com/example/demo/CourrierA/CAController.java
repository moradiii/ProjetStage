package com.example.demo.CourrierA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping(path = "ca")
public class CAController {

    private final CAService caService;

    @Autowired
    public CAController(CAService caService){
        this.caService = caService;
    }

    @GetMapping("/tablea")
    public String getCA(Model model){
        List<CAModel> ca = caService.getCA();
        model.addAttribute("all", ca);
        return "tableca";
    }

    @PostMapping("/insertca")
    public String registerNewCA(@ModelAttribute CAModel ca) {
        caService.addNewCA(ca);
        return "redirect:/ca/tablea";
    }


    @PostMapping("/deleteca")
    public String deleteCA(@RequestParam("caId") Long caId, Model model) {
        boolean isdeleted = false;
        try {
            caService.deleteCA(caId);
            model.addAttribute("isdeleted", isdeleted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/ca/tablea";
    }

    @PutMapping("/updateca")
    public String updateCA(@ModelAttribute CAModel ca, @RequestParam Long caid){
        caService.updateCA(ca.getId(), String.valueOf(ca), caid);
        return "redirect:/ca/tablea";
    }
}
