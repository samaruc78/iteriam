package es.iteriam.calculadora.controllers;

import es.iteriam.calculadora.servicio.CalculoService;
import es.iteriam.calculadora.models.MiModeloOperacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculadoraController {

    MiModeloOperacion miOperacion = new MiModeloOperacion();

    @Autowired
    private CalculoService calculoServicio;

    @RequestMapping(value = "/calcula", params = "suma", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> add(@ModelAttribute("miOperacion") MiModeloOperacion miOperacion, Model model) {
        model.addAttribute("result", calculoServicio.add(miOperacion));
        return new ResponseEntity<>(model.getAttribute("result"), HttpStatus.OK);
    }

    @RequestMapping(value = "/calcula", params = "resta", method = RequestMethod.POST)
    public ResponseEntity<Object> subtract(@ModelAttribute("miOperacion") MiModeloOperacion miOperacion, Model model) {
        model.addAttribute("result", calculoServicio.subtract(miOperacion));
        return new ResponseEntity<>(model.getAttribute("result"), HttpStatus.OK);
    }

    @RequestMapping(value = "/calcula", params = "multiplica", method = RequestMethod.POST)
    public ResponseEntity<Object> multiply(@ModelAttribute("miOperacion") MiModeloOperacion miOperacion, Model model) {
        model.addAttribute("result", calculoServicio.multiply(miOperacion));
        return new ResponseEntity<>(model.getAttribute("result"), HttpStatus.OK);
    }

    @RequestMapping(value = "/calcula", params = "divide", method = RequestMethod.POST)
    public ResponseEntity<Object> divide(@ModelAttribute("miOperacion") MiModeloOperacion miOperacion, Model model) {
        model.addAttribute("result", calculoServicio.divide(miOperacion));
        return new ResponseEntity<>(model.getAttribute("result"), HttpStatus.OK);
    }

    //TO-DO function modulo. (a mod b)

    
}