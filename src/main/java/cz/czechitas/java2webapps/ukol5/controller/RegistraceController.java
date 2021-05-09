package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Kontroler obsluhující registraci účastníků dětského tábora.
 */
@Controller
@RequestMapping("/")
public class RegistraceController {

  @GetMapping("")
  public ModelAndView index() {
    ModelAndView modelAndView = new ModelAndView("formular");
    modelAndView.addObject("formular", new RegistraceForm());
    return modelAndView;
  }

  @PostMapping("")
  public Object form(@ModelAttribute("formular") @Valid RegistraceForm form, BindingResult bindingResult) {
    if(form.getDatumNarodenia() != null) {
      if (form.getVek() < 9 || form.getVek() > 15) {
        bindingResult.rejectValue("datumNarodenia", "", "Dieťa musí byť staršie ako 9 rokov a mladšie ako 15 rokov.");
        return "formular";
      }
    }

    if(form.getSporty() != null) {
      if (form.getSporty().size() < 2) {
        bindingResult.rejectValue("sporty", "", "Je potrebné vybrať aspoň 2 športy.");
        return "formular";
      }
    }

    if (bindingResult.hasErrors()) {
      return "formular";
    }

    return new ModelAndView("rekapitulace")
            .addObject("formular", form);
  }

  @InitBinder    /* Converts empty strings into null when a form is submitted - used for email, telefon and web values */
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
  }
}
