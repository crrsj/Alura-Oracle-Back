package br.com.oracle.service;

import br.com.oracle.entity.Participante;
import br.com.oracle.enums.Statusinscricao;
import br.com.oracle.exceptions.ParticipanteNaoEncontrado;
import br.com.oracle.repository.ParticipanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParticipanteService {

    private final ParticipanteRepository repository;

    public Participante cadastrarParticipante(Participante participante){
        participante.setStatus(Statusinscricao.INSCRITO);
        return repository.save(participante);
    }

    public Page<Participante>listarParticipantes(Pageable pageable){
        return repository.findAll(pageable);
    }

    public void excluirParticipante(Long id){
      if(!repository.existsById(id)){
          throw new ParticipanteNaoEncontrado("Participante não existe !");
      }
      repository.deleteById(id);
    }
}
