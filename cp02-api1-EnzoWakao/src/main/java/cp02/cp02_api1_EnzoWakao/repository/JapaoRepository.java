package cp02.cp02_api1_EnzoWakao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cp02.cp02_api1_EnzoWakao.model.Japao;

@Repository
public interface JapaoRepository extends JpaRepository<Japao, Long>{
    
    

}
