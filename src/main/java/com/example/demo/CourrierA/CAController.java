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
        List<CAModel> c = caService.getCA();
        model.addAttribute("allca", c);
        return "tableca";
    }

    @PutMapping
    public void registerNewCA(@RequestBody CAModel ca){
        caService.addNewCA(ca);
    }

    @DeleteMapping(path = "{caId}")
    public void deleteCA(@PathVariable("caId") Long caId){
        caService.deleteCA(caId);
    }

    @PutMapping(path = "{caId}")
    public void updateCA(@PathVariable("caId") Long userId,
                         @RequestParam(required = false) String type,
                         @RequestParam(required = false) Long num){
        caService.updateCA(userId, type, num);
    }
}
