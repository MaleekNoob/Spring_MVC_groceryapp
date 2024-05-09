package com.example.grocerymanagement.controller;

import com.example.grocerymanagement.bean.Grocery;
import com.example.grocerymanagement.dao.GroceryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GroceryController {
    @Autowired
    GroceryDao groceryDao;

    @RequestMapping("/groceryForm")
    public String showForm(Model model) {
        model.addAttribute("grocery", new Grocery());
        return "groceryForm";
    }

    @RequestMapping(value = "/saveGrocery", method = RequestMethod.POST)
    public String save(@ModelAttribute("grocery") Grocery grocery) {
        groceryDao.save(grocery);
        return "redirect:/viewGroceries";
    }

    @RequestMapping("/viewGroceries")
    public String viewGroceries(Model model) {
        List<Grocery> groceries = groceryDao.getGroceries();
        model.addAttribute("groceries", groceries);
        return "viewGroceries";
    }

    @RequestMapping(value = "/editGrocery/{id}")
    public String edit(@PathVariable int id, Model model) {
        Grocery grocery = groceryDao.getGroceryById(id);
        model.addAttribute("grocery", grocery);
        return "editGroceryForm";
    }

    @RequestMapping(value = "/editSave", method = RequestMethod.POST)
    public String editSave(@ModelAttribute("grocery") Grocery grocery) {
        groceryDao.update(grocery);
        return "redirect:/viewGroceries";
    }

    @RequestMapping(value = "/deleteGrocery/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        groceryDao.delete(id);
        return "redirect:/viewGroceries";
    }
}
