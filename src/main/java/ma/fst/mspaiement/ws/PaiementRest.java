package ma.fst.mspaiement.ws;


import ma.fst.mspaiement.bean.Paiement;
import ma.fst.mspaiement.requiered.CommandeRequiered;
import ma.fst.mspaiement.service.PaiementService;
import ma.fst.mspaiement.vo.CommandeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paiement")
public class PaiementRest {
    @Autowired
    CommandeRequiered commandeRequiered;

    @GetMapping("/commande-requiered/reference/{reference}")
    public CommandeVo findCommandeByReference(@PathVariable String reference) {
        return commandeRequiered.findByReference(reference);
    }

    @GetMapping("/reference/{reference}")
    public Paiement findByReference(@PathVariable String reference) {
        return paiementService.findByReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return paiementService.deleteByReference(reference);
    }

    @GetMapping("/")
    public List<Paiement> findAll() {
        return paiementService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Paiement entity) {
        return paiementService.save(entity);
    }


    @Autowired
    private PaiementService paiementService;
}
