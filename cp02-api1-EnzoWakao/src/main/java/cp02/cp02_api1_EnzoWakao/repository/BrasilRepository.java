package cp02.cp02_api1_EnzoWakao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cp02.cp02_api1_EnzoWakao.model.Brasil;

@Repository
public interface BrasilRepository extends JpaRepository<Brasil, Long>{
    

    
}