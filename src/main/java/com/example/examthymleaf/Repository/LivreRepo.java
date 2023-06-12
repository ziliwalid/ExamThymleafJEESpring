
package com.example.examthymleaf.Repository;

import com.example.examthymleaf.Models.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepo extends JpaRepository<Livre, Long> {

}
