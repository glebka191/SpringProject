package com.innotech.Controllers.AdminControllers;

import com.innotech.Entity.SideTable;
import com.innotech.Service.AdminService;
import com.innotech.repo.SideTableRepo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminSideTableController {
    private final AdminService adminService;
    private final SideTableRepo sideTableRepo;

    public AdminSideTableController(AdminService adminService, SideTableRepo sideTableRepo) {
        this.adminService = adminService;
        this.sideTableRepo = sideTableRepo;
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @PostMapping("/admin")
    public String addSideTable(Integer size, SideTable sideTable){
        if (!adminService.addSideTable(size, sideTable)) {
            return "admin";
        }
        sideTable.setSize(size);
        return "admin";
    }

    @DeleteMapping("/admin/delete")
    public String deleteSideTable(Integer sideTableId, Map<String, Object> model){
        adminService.deleteSideTable(sideTableId);
        model.put("Message", "SideTable delete!");
        return "/admin/delete";
    }

    @PutMapping("/admin/update")
    public String updateSideTable(SideTable sideTable, Integer sideTableId){
        SideTable updateSideTable = adminService.updateSideTable(sideTable, sideTableId);
        if (updateSideTable == null){
            return "/admin/update";
        } else {
            return "/admin/update";
        }
    }
}