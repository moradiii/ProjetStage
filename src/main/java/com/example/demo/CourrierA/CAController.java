package com.example.demo.CourrierA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping(path = "ca")
public class CAController {

    private final CAService caService;
    private static final Logger logger = LoggerFactory.getLogger(CAController.class);

    @Autowired
    public CAController(CAService caService) {
        this.caService = caService;
    }

    // Display all CA entries
    @GetMapping("/tablea")
    public String getCA(Model model) {
        List<CAModel> ca = caService.getCA();
        model.addAttribute("all", ca);
        return "tableca";
    }

    // Insert a new CA entry
    @PostMapping("/insertca")
    public String registerNewCA(@RequestParam String type, @RequestParam String date, @RequestParam String datebo, @RequestParam String objet,
                                @RequestParam String affet, @RequestParam String dest, @RequestParam long num, @RequestParam long numbo, @RequestParam String origin,
                                @RequestParam String obs, @RequestParam String pj, @RequestParam String created, @RequestParam String updated) {
        try {
            LocalDate dateParsed = LocalDate.parse(date);
            LocalDate dateboParsed = LocalDate.parse(datebo);
            LocalDateTime createdParsed = LocalDateTime.parse(created);
            LocalDateTime updatedParsed = LocalDateTime.parse(updated);

            CAModel ca = new CAModel(type, dateParsed, dateboParsed, objet, affet, dest, num, numbo, origin, obs, pj, createdParsed, updatedParsed);
            caService.addNewCA(ca);
        } catch (Exception e) {
            logger.error("Error registering new CA: ", e);
            return "redirect:/ca/error";
        }
        return "redirect:/ca/tablea";
    }


    // Delete a CA entry
    @PostMapping("/deleteca")
    public String deleteCA(@RequestParam("caId") long caId, Model model) {
        boolean isdeleted = false;
        try {
            caService.deleteCA(caId);
            isdeleted = true;
            model.addAttribute("isdeleted", isdeleted);
        } catch (Exception e) {
            logger.error("Error deleting CA: ", e);
            model.addAttribute("isdeleted", isdeleted);
        }
        return "redirect:/ca/tablea";
    }

    @PostMapping("/updateca")
    public String updateCA(@RequestParam String type, @RequestParam String date, @RequestParam String datebo, @RequestParam String objet,
                           @RequestParam String affet, @RequestParam String dest, @RequestParam long num, @RequestParam long numbo, @RequestParam String origin,
                           @RequestParam String obs, @RequestParam String pj, @RequestParam String created, @RequestParam String updated) {
        try {
            LocalDate dateParsed = LocalDate.parse(date);
            LocalDate dateboParsed = LocalDate.parse(datebo);
            LocalDateTime createdParsed = LocalDateTime.parse(created);
            LocalDateTime updatedParsed = LocalDateTime.parse(updated);

            CAModel ca = new CAModel(type, dateParsed, dateboParsed, objet, affet, dest, num, numbo, origin, obs, pj, createdParsed, updatedParsed);
            caService.updateCA(ca);
        } catch (Exception e) {
            logger.error("Error updating CA: ", e);
            return "redirect:/ca/error";
        }
        return "redirect:/ca/tablea";
    }

}
