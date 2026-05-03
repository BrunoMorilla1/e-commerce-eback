package br.com.e_commerce.e_commerce.repository;

import br.com.e_commerce.e_commerce.entity.LojaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<LojaEntity, Long> {
}
