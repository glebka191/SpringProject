package com.innotech.controllers.adminControllers;

import com.innotech.entity.Menu;
import com.innotech.entity.TypeFood;
import com.innotech.service.MenuService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/menu")
public class AdminMenuController {

    private final MenuService menuService;

    public AdminMenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/add")
    public String addMenu(Menu menu, String name,
                          TypeFood typeFood, Integer price){
        menu.setName(name);
        menu.setTypeFoods(Collections.singleton(typeFood));
        menu.setPrice(price);
        if (!menuService.addMenu(menu)) {
            return "/admin";
        }
        return "/admin";
    }

    @DeleteMapping("/{menu_id}/delete")
    public String deleteSideTable(@PathVariable("menu_id") Integer id,
                                  Menu menu, Map<String, Object> model){
        menuService.deleteMenu(menu);
        model.put("Message", "menu delete!");
        return "/menu";
    }

    @PutMapping("/update")
    public String updateSideTable(Menu menu){
        if (menuService.changeMenu(menu)){
            return "/admin/update";
        } else {
            return "/admin/update";
        }
    }
}