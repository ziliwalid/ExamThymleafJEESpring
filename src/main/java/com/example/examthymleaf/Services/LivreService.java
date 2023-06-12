package com.example.examthymleaf.Services;



import com.example.examthymleaf.Models.Livre;
import com.example.examthymleaf.Repository.LivreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreService {
    @Autowired
    private LivreRepo repo;
    public List<Livre> GetAll(){
        return repo.findAll();
    }
    public Livre SaveBook(Livre livre){
        return repo.save(livre);
    }
    public Livre SearchBook(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
