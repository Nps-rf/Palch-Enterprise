package com.example.t_24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private CargoService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Cargo> listCargos = service.listAll(keyword);
        model.addAttribute("listCargos", listCargos);
        model.addAttribute("keyword", keyword);
        return "index"; //index.html
    }

    @RequestMapping("/new")
    public String showNewCargoForm(Model model) {
        Cargo cargo = new Cargo();
        model.addAttribute("Cargo", cargo);
        return "new_cargo";
    }

    @PostMapping("/new")
    public String saveNewCargo(@ModelAttribute("Cargo") Cargo cargo) {
        service.save(cargo);
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String saveEditedCargo(@ModelAttribute("Cargo") Cargo cargo) {
        service.save(cargo);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCargoForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_cargo");
        Cargo cargo = service.get(id);
        mav.addObject("Cargo", cargo);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteCargo(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}