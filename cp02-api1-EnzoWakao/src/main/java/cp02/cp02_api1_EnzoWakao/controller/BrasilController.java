package cp02.cp02_api1_EnzoWakao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cp02.cp02_api1_EnzoWakao.model.Brasil;
import cp02.cp02_api1_EnzoWakao.repository.BrasilRepository;

@RestController
@RequestMapping("api/${api.version}/jogadoresBrasil")
public class BrasilController {

    @Autowired
    private BrasilRepository repository;

     @PostMapping
    public ResponseEntity<Brasil> create(@RequestBody Brasil brasil) {         
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(brasil));
    }

    @GetMapping("/{id}")    
    public ResponseEntity<Brasil> findById(@PathVariable Long id) { 
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());        
    }

    @GetMapping    
    public ResponseEntity<List<Brasil>> findAll() {        
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brasil> update(@PathVariable Long id, 
                                @RequestBody Brasil brasil) {

        Optional<Brasil> optBrasil = repository.findById(id);

        if (optBrasil.isPresent()) {
            brasil.setId(id);
            Brasil brasilAlterado = repository.save(brasil);
            return ResponseEntity.ok(brasilAlterado);
        } else {
            return ResponseEntity.notFound().build();
        }     
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) { 
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
 
    }

}

