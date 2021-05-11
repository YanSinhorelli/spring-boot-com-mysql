package br.com.projetob2w.springbootcommysql.controller;

import br.com.projetob2w.springbootcommysql.controller.dto.TrilhaRq;
import org.springframework.web.bind.annotation.*;

import br.com.projetob2w.springbootcommysql.controller.dto.CargoRq;
import br.com.projetob2w.springbootcommysql.controller.dto.CargoRs;
import br.com.projetob2w.springbootcommysql.controller.dto.TrilhaRs;
import br.com.projetob2w.springbootcommysql.model.Cargo;
import br.com.projetob2w.springbootcommysql.model.Trilha;
import br.com.projetob2w.springbootcommysql.repository.CargoCustomRepository;
import br.com.projetob2w.springbootcommysql.repository.CargoRepository;
import br.com.projetob2w.springbootcommysql.repository.TrilhaCustomRepository;
import br.com.projetob2w.springbootcommysql.repository.TrilhaRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    private final CargoRepository cargoRepository;
    private final CargoCustomRepository cargoCustomRepository;
    private final TrilhaRepository trilhaRepository;
    private final TrilhaCustomRepository trilhaCustomRepository;
    private final TrilhaController trilhaController;

    public CargoController(CargoRepository cargoRepository, CargoCustomRepository cargoCustomRepository,
                           TrilhaRepository trilhaRepository, TrilhaCustomRepository trilhaCustomRepository,
                           TrilhaController trilhaController) {
        this.cargoRepository = cargoRepository;
        this.cargoCustomRepository = cargoCustomRepository;
        this.trilhaRepository = trilhaRepository;
        this.trilhaCustomRepository = trilhaCustomRepository;
        this.trilhaController = trilhaController;
    }

    @GetMapping("/")
    public List<CargoRs> findAll() {
        var cargos = cargoRepository.findAll();
        return cargos
                .stream()
                .map(CargoRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CargoRs findById(@PathVariable("id") Integer id) {
        var cargo = cargoRepository.getOne(id);
        return CargoRs.converter(cargo);
    }

    @PostMapping("/")
    public void saveCargo(@RequestBody CargoRq cargoRq) {
        TrilhaRs trilhaRs = trilhaController.findById(cargoRq.getTrilha().getId());
        Trilha trilha = TrilhaRs.converterToTrilha(trilhaRs);
        var cargoSave = new Cargo();
        cargoSave.setCargoNome(cargoRq.getCargoNome());
        cargoSave.setTrilha(trilha);
        cargoSave.setCargoMissao(cargoRq.getCargoMissao());
        if (cargoRq.getDataAtualizacao() == null) {
            cargoSave.setDataAtualizacao(cargoRq.getDataAtualizacaoNow());
        } else if (cargoRq.getDataAtualizacao() instanceof Timestamp) {
            cargoSave.setDataAtualizacao(cargoRq.getDataAtualizacao());
        }
        cargoRepository.save(cargoSave);
    }

    @PutMapping("/{id}")
    public void updateCargo(@PathVariable("id") Integer id, @RequestBody CargoRq cargo) throws Exception {
        var c = cargoRepository.findById(id);

        if (c.isPresent()) {
            var cargoSave = c.get();
            cargoSave.setCargoNome(cargo.getCargoNome());
            cargoSave.setTrilha(cargo.getTrilha());
            cargoSave.setCargoMissao(cargo.getCargoMissao());
            if (cargo.getDataAtualizacao() == null) {
                cargoSave.setDataAtualizacao(cargo.getDataAtualizacaoNow());
            } else if (cargo.getDataAtualizacao() instanceof Timestamp) {
                cargoSave.setDataAtualizacao(cargo.getDataAtualizacao());
            }
            cargoRepository.save(cargoSave);
        } else {
            throw new Exception("Cargo não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCargo(@PathVariable("id") Integer id,@RequestBody CargoRq cargoRq) throws Exception {
        var c = cargoRepository.findById(id);

        if (c.isPresent()) {
            var cargoDelete = c.get();
            cargoRepository.delete(cargoDelete);
        } else {
            throw new Exception("cargo não encontrada");
        }
    }

    @GetMapping("/filter")
    public List<CargoRs> findCargoByName(@RequestParam("nome") String nome) {
        return this.cargoRepository.findByCargoNomeContains(nome)
                .stream()
                .map(CargoRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/filter/custom")
    public List<CargoRs> findCargoByCustom(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "cargo_nome", required = false) String cargoNome,
            @RequestParam(value = "trilha_id", required = false) Trilha trilha
    ) {
        return this.cargoCustomRepository.find(id, cargoNome, trilha)
                .stream()
                .map(CargoRs::converter)
                .collect(Collectors.toList());
    }

}
