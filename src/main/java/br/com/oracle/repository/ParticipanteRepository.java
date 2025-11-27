package br.com.oracle.repository;

import br.com.oracle.entity.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participante,Long> {
}
