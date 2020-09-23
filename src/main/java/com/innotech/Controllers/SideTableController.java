package com.innotech.Controllers;

import com.innotech.repo.SideTableRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class SideTableController {
    private final SideTableRepo sideTableRepo;

    public SideTableController(SideTableRepo sideTableRepo) {
        this.sideTableRepo = sideTableRepo;
    }

    @GetMapping("tables")
    ModelAndView list() {
        return new ModelAndView("/tables",
                Map.of("SideTable", sideTableRepo.findAll()),
                HttpStatus.OK);
    }
}