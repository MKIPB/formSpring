package com.ejemplo.controller;

import com.ejemplo.model.Colecciones;
import com.ejemplo.model.ContarParametrosRecibidos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class PrincipalController {

    private final Colecciones colecciones = new Colecciones();

    @GetMapping("/formulario/devuelve-formulario")
    public String devuelveFormulario(Model model) {
        cargarAtributosModelo(model, "Original", 1, null, null);
        return "formulario";
    }

    @PostMapping("/formulario/recibe-parametros")
    public String recibeParametrosYRepinta(
            @RequestParam(value = "usuario", required = false) String usuario,
            @RequestParam(value = "clave", required = false) String clave,
            @RequestParam(value = "iteraciones", required = false) String iteraciones,
            @RequestParam(value = "generoSeleccionado", required = false) String generoSeleccionado,
            @RequestParam(value = "aficionesSeleccionadas", required = false) ArrayList<String> aficionesSeleccionadas,
            @RequestParam(value = "paisSeleccionado", required = false) String paisSeleccionado,
            @RequestParam(value = "musicasSeleccionadas", required = false) ArrayList<String> musicasSeleccionadas,
            @RequestParam(value = "comentarios", required = false) String comentarios,
            @RequestParam(value = "imagen.x", required = false) String imagenX,
            @RequestParam(value = "imagen.y", required = false) String imagenY,
            Model model
    ) {
        int iteracionesActualizadas = iteraciones == null ? 1 : Integer.parseInt(iteraciones) + 1;

        ContarParametrosRecibidos contar = new ContarParametrosRecibidos();
        int totalParametros = contar.calcularParametros(usuario, clave, generoSeleccionado, 
                                                        aficionesSeleccionadas, paisSeleccionado, 
                                                        musicasSeleccionadas, comentarios);

        cargarAtributosModelo(model, "Repintado", iteracionesActualizadas, imagenX, imagenY);
        model.addAttribute("totalParametros", totalParametros);
        return "formulario";
    }

    private void cargarAtributosModelo(Model model, String titulo, int iteraciones, String imagenX, String imagenY) {
        model.addAttribute("titulo", titulo);
        model.addAttribute("iteraciones", iteraciones);
        model.addAttribute("coleccionGeneros", colecciones.getGeneros());
        model.addAttribute("coleccionAficiones", colecciones.getAficiones());
        model.addAttribute("coleccionPaises", colecciones.getPaises());
        model.addAttribute("coleccionMusicas", colecciones.getMusicas());
        model.addAttribute("imagenX", imagenX);
        model.addAttribute("imagenY", imagenY);
    }
}
