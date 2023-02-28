package com.example.Imobiliaria.Controller;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Imobiliaria.Service.CrudService;

import javax.swing.text.html.Option;

public abstract class CrudController<T,ID> {
    //rota
    protected abstract CrudService<T,ID> getService();

    @GetMapping
    public ResponseEntity<List<T>> listar(){
        return new ResponseEntity<>(getService().listAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<T> listarId(@PathVariable ID id){
        Optional<T> entity = getService().findByID(id);
        return entity.map(e-> new ResponseEntity<>(e,HttpStatus.OK)).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping()
    public ResponseEntity<T> cadastrar(@RequestBody @Valid T entity){
        return new ResponseEntity<>(getService().create(entity),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<T> editar(@PathVariable ID id, @RequestBody @Valid T entidade){
        Optional<T> updatedEntity = getService().update(id,entidade);
        if (updatedEntity.isPresent()){
            return new ResponseEntity<>(updatedEntity.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable ID id){
        return new ResponseEntity<>(getService().deleteById(id),HttpStatus.OK);
    }

}
