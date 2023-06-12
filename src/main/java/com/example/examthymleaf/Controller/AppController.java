
package com.example.examthymleaf.Controller;


import com.example.examthymleaf.Models.Livre;
import com.example.examthymleaf.Services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class AppController {
  @Autowired
  private LivreService service;

  @RequestMapping("/")
   public String viewHomePage(Model model){
       List<Livre> listlivre=service.GetAll();
       model.addAttribute("listlivre",listlivre);
   return "index";
   }  
   
   @RequestMapping("/new")
   public String ShowNewBooksForm(Model model){
   Livre book=new Livre();
       model.addAttribute("book",book);
     return "addForm";
   }
    @RequestMapping(value="/save",method=RequestMethod.POST)
   public String saveLivre(@ModelAttribute("book") Livre livre){
   service.SaveBook(livre);
   return "redirect:/";
   }
   @RequestMapping("/edit/{id}")
    public ModelAndView ShowEditLivreForm(@PathVariable(name="id") Long id ){
    ModelAndView mav =new ModelAndView("editForm");
    Livre book=service.SearchBook(id);
    mav.addObject("book",book);
     return mav;
   }
     @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable(name="id") Long id ){
    service.delete(id);
       return "redirect:/";
    
    }
}
