package com.example.Imobiliaria.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class CrudService<T, ID> {
    //logica
    @Autowired
    private JpaRepository<T, ID> jpaRepository;

    public List<T> listAll() {
        return jpaRepository.findAll();
    }

    public Optional<T> listId(ID id){
        return jpaRepository.findById(id);
    }
    
    public Optional<T> update(ID id, T entity) {
        if (jpaRepository.findById(id).isPresent()) {
            return Optional.of(jpaRepository.save(entity));
        }
        return Optional.empty();
    }

    public T create(T entity) {
        return jpaRepository.save(entity);
    }

    public Optional<Boolean> deleteById(ID id){
        if (jpaRepository.findById(id).isPresent()) {
            jpaRepository.deleteById(id);
            return Optional.of(true);
        }
        return Optional.of(false);
    }

    public Optional<T> findByID(ID id){
        return jpaRepository.findById(id);
    }



}
