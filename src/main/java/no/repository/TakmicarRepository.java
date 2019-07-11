package no.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import no.model.Takmicar;

@Repository
public interface TakmicarRepository extends JpaRepository <Takmicar, Long>{
	
	@Query("SELECT t FROM Takmicar t WHERE"
			+"(:skakaonicaId IS NULL OR t.skakaonica.id = :skakaonicaId) AND "
			+"(:imeIPrezime IS NULL OR t.imeIPrezime LIKE :imeIPrezime) AND "
			+"(:drzava IS NULL OR t.drzava LIKE :drzava)"
			)
	Page<Takmicar> search(
			@Param("skakaonicaId") Long skakaonicaId,
			@Param("imeIPrezime") String imeIPrezime,
			@Param("drzava") String drzava,
			Pageable pageRequest);

}
