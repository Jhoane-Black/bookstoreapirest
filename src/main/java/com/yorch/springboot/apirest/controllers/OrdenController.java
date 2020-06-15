package com.yorch.springboot.apirest.controllers;

import com.yorch.springboot.apirest.models.entity.Orden;
import com.yorch.springboot.apirest.models.entity.Respuesta;
import com.yorch.springboot.apirest.models.service.IOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.yorch.springboot.apirest.models.entity.Respuesta.ERROR;
import static com.yorch.springboot.apirest.models.entity.Respuesta.SUCCESS;

@CrossOrigin(origins = { "*" },allowedHeaders="*")
@RestController
@RequestMapping("/orden")
public class OrdenController {

    @Autowired
    private IOrdenService iOrdenService;

    @PostMapping("/create")
    private Respuesta createOrden(@RequestBody Orden orden) {
        if (orden == null) {
            ERROR.setCodigo(400);
            ERROR.setMensaje("data not found");
            return ERROR;
        }

        SUCCESS.setData(iOrdenService.save(orden));
        SUCCESS.setCodigo(201);
        SUCCESS.setMensaje("data saved");
        return SUCCESS;
    }
}
