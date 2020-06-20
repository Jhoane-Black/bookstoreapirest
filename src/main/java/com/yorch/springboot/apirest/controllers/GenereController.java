package com.yorch.springboot.apirest.controllers;

import com.yorch.springboot.apirest.models.entity.Genere;
import com.yorch.springboot.apirest.models.entity.Respuesta;
import com.yorch.springboot.apirest.models.service.IGenereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.yorch.springboot.apirest.models.entity.Respuesta.ERROR;
import static com.yorch.springboot.apirest.models.entity.Respuesta.SUCCESS;

@CrossOrigin(origins = { "*" },allowedHeaders="*")
@RestController
@RequestMapping("/gender")
public class GenereController {


    @Autowired
    private IGenereService iGenereService;

    @PostMapping("/create")
    public Respuesta createGenere(@RequestBody Genere g) {
        if (g == null) {
            ERROR.setCodigo(400);
            ERROR.setMensaje("data not found");
            return ERROR;
        }
        
    @PutMapping("/update/{id}")
    public @ResponseBody Respuesta updateGenere (@RequestBody Genere genere, @PathVariable int id) {
        Genere toEdit = iGenereService.findById(id);
        if (toEdit == null) {
            ERROR.setCodigo(400);
            return ERROR;
        }

        SUCCESS.setData(iGenereService.save(g));
        SUCCESS.setCodigo(201);
        SUCCESS.setMensaje("data saved");
        return SUCCESS;
    }
}
