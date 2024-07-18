package com.example.demo.CourrierD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cd")
public class CDController {

    private final CDService cdService;

    @Autowired
    public CDController(CDService cdService){
        this.cdService = cdService;
    }

    @GetMapping
    public List<CDModel> getCD(){
        return cdService.getCD();
    }

    @PutMapping
    public void registerNewCD(@RequestBody CDModel cd){
        cdService.addNewCD(cd);
    }

    @DeleteMapping(path = "{cdId}")
    public void deleteCD(@PathVariable("cdId") Long cdId){
        cdService.deleteCD(cdId);
    }

    @PutMapping(path = "{cdId}")
    public void updateCD(@PathVariable("cdId") Long userId,
                           @RequestParam(required = false) String type,
                           @RequestParam(required = false) Long num){
        cdService.updateCD(userId, type, num);
    }
}
