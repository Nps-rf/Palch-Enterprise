package com.example.t_24;

import com.example.t_24.Entity.Cargo;
import com.example.t_24.Service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private CargoService service;

    @GetMapping("/")
    public String displayHomePage(Model model,
                                  @RequestParam(name = "keyword", required = false) String keyword,
                                  @RequestParam(name = "departureDate", required = false) String departureDate) {
        List<Cargo> cargos = service.listAll(keyword, departureDate);
        model.addAttribute("listCargos", cargos);
        model.addAttribute("keyword", keyword);
        model.addAttribute("departureDate", departureDate);
        return "index";
    }

    @GetMapping("/new")
    public String displayNewCargoForm(Model model) {
        Cargo cargo = new Cargo();
        model.addAttribute("Cargo", cargo);
        return "new_cargo";
    }

    @PostMapping("/new")
    public ResponseEntity<String> saveNewCargo(@ModelAttribute("Cargo") Cargo cargo) {
        service.save(cargo);
        return ResponseEntity.ok("Cargo saved");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView displayEditCargoForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("edit_cargo");
        Cargo cargo = service.get(id);
        mav.addObject("Cargo", cargo);
        return mav;
    }

    @PostMapping("/edit")
    public String saveEditedCargo(@ModelAttribute("Cargo") Cargo cargo) {
        service.save(cargo);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCargo(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
