package com.example.demo.CourrierA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "CA")
public class CAController {

    private final CAService caService;

    @Autowired
    public CAController(CAService caService){
        this.caService = caService;
    }

    @GetMapping
    public List<CAModel> getCA(){
        return caService.getCA();
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
