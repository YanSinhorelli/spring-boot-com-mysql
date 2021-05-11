package br.com.projetob2w.springbootcommysql.controller;

import org.springframework.web.bind.annotation.*;

import br.com.projetob2w.springbootcommysql.controller.dto.TrilhaRq;
import br.com.projetob2w.springbootcommysql.controller.dto.TrilhaRs;
import br.com.projetob2w.springbootcommysql.model.Trilha;
import br.com.projetob2w.springbootcommysql.repository.TrilhaCustomRepository;
import br.com.projetob2w.springbootcommysql.repository.TrilhaRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trilha")
public class TrilhaController {

    private final TrilhaRepository trilhaRepository;
    private final TrilhaCustomRepository trilhaCustomRepository;

    public TrilhaController(TrilhaRepository trilhaRepository, TrilhaCustomRepository trilhaCustomRepository) {
        this.trilhaRepository = trilhaRepository;
        this.trilhaCustomRepository = trilhaCustomRepository;
    }

    @GetMapping("/")
    public List<TrilhaRs> findAll() {
        var trilhas = trilhaRepository.findAll();
        return trilhas
                .stream()
                .map(TrilhaRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TrilhaRs findById(@PathVariable("id") Integer id) {
        var trilha = trilhaRepository.getOne(id);
        return TrilhaRs.converter(trilha);
    }

    @PostMapping("/")
    public void saveTrilha(@RequestBody TrilhaRq trilhaRq) {
        var trilhaSave = new Trilha();
        trilhaSave.setTrilhaNome(trilhaRq.getTrilhaNome());
        trilhaSave.setDiretoria(trilhaRq.getDiretoria());
        trilhaSave.setMissaoFormal(trilhaRq.getMissaoFormal());
        trilhaSave.setMissaoAlternativa(trilhaRq.getMissaoAlternativa());
        trilhaSave.setDataAtualizacao(trilhaRq.getDataAtualizacao());
        trilhaRepository.save(trilhaSave);
    }

    @PutMapping("/{id}")
    public void updateTrilha(@PathVariable("id") Integer id, @RequestBody TrilhaRq trilha) throws Exception {
        var p = trilhaRepository.findById(id);

        if (p.isPresent()) {
            var trilhaSave = p.get();
            trilhaSave.setTrilhaNome(trilha.getTrilhaNome());
            trilhaSave.setDiretoria(trilha.getDiretoria());
            trilhaSave.setDataAtualizacao(trilha.getDataAtualizacao());
            trilhaSave.setMissaoAlternativa(trilha.getMissaoAlternativa());
            trilhaSave.setMissaoFormal(trilha.getMissaoFormal());
            trilhaRepository.save(trilhaSave);
        } else {
            throw new Exception("Trilha Não encontrada");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTrilha(@PathVariable("id") Integer id,@RequestBody TrilhaRq trilha) throws Exception {
        var t = trilhaRepository.findById(id);

        if (t.isPresent()) {
            var trilhadelete = t.get();
            trilhaRepository.delete(trilhadelete);
        } else {
            throw new Exception("Trilha não encontrada");
        }

    }

    @GetMapping("/filter")
    public List<TrilhaRs> findTrilhaByName(@RequestParam("name") String name) {
        return this.trilhaRepository.findByTrilhaNomeContains(name)
                .stream()
                .map(TrilhaRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/filter/custom")
    public List<TrilhaRs> findTrilhaByCustom(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "trilha_nome", required = false) String trilhaNome,
            @RequestParam(value = "diretoria", required = false) String diretoria
    ) {
        return this.trilhaCustomRepository.find(id, trilhaNome, diretoria)
                .stream()
                .map(TrilhaRs::converter)
                .collect(Collectors.toList());
    }

}
