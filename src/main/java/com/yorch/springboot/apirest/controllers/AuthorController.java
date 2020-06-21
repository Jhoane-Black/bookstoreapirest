package com.yorch.springboot.apirest.controllers;

import com.yorch.springboot.apirest.models.entity.Author;
import com.yorch.springboot.apirest.models.entity.Respuesta;
import com.yorch.springboot.apirest.models.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.yorch.springboot.apirest.models.entity.Respuesta.ERROR;
import static com.yorch.springboot.apirest.models.entity.Respuesta.SUCCESS;

@CrossOrigin(origins = { "*" },allowedHeaders="*")
@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private IAuthorService iAuthorService;

    @PostMapping("/create")
    public Respuesta createAuthor(@RequestBody Author author) {

        if (author == null) {
            ERROR.setCodigo(400);
            ERROR.setMensaje("data not found");
            return ERROR;
        }

        iAuthorService.save(author);
        SUCCESS.setData(author);
        SUCCESS.setCodigo(201);
        return SUCCESS;
    }
        
    @PutMapping("/update/{id}")
    public @ResponseBody Respuesta updateAuthor (@RequestBody Author author, @PathVariable int id) {
        Author toEdit = iAuthorService.findById(id);
        if (toEdit == null) {
            ERROR.setCodigo(400);
            return ERROR;
        }

        SUCCESS.setData(iAuthorService.save(author));
        SUCCESS.setMensaje("data saved");
        SUCCESS.setCodigo(201);
        return SUCCESS;
    }

    @GetMapping("/list")
    public Respuesta listAuthor() {
        SUCCESS.setData(this.iAuthorService.findAll());
        return SUCCESS;
    }
}
