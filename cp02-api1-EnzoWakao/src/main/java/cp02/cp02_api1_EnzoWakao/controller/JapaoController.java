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

import cp02.cp02_api1_EnzoWakao.model.Japao;
import cp02.cp02_api1_EnzoWakao.repository.JapaoRepository;

@RestController
@RequestMapping("api/${api.version}/jogadoresJapao")
public class JapaoController {

    @Autowired
    private JapaoRepository repository;

     @PostMapping
    public ResponseEntity<Japao> create(@RequestBody Japao japao) {         
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(japao));
    }

    @GetMapping("/{id}")    
    public ResponseEntity<Japao> findById(@PathVariable Long id) { 
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());        
    }

    @GetMapping    
    public ResponseEntity<List<Japao>> findAll() {        
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Japao> update(@PathVariable Long id, 
                                @RequestBody Japao japao) {

        Optional<Japao> optJapao = repository.findById(id);

        if (optJapao.isPresent()) {
            japao.setId(id);
            Japao japaoAlterado = repository.save(japao);
            return ResponseEntity.ok(japaoAlterado);
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