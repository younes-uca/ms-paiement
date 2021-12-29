package ma.fst.mspaiement.service;

import ma.fst.mspaiement.bean.Paiement;
import ma.fst.mspaiement.dao.PaiementDao;
import ma.fst.mspaiement.requiered.CommandeRequiered;
import ma.fst.mspaiement.vo.CommandeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementService {
    Logger logger= LoggerFactory.getLogger(PaiementService.class);

    public int save(Paiement paiement) {
        logger.info("save Paiement ==> findByReference called "+paiement.getReference());

        CommandeVo commandeVo = commandeRequiered.findByReference(paiement.getReferenceCommande());
        if (findByReference(paiement.getReference()) != null) {
            return -1;
        } else if (commandeVo == null || commandeVo.getId() == null) {
            return -2;
        } else {
            paiement.setId(new Long(paiementDao.findAll().size()+10));
            paiementDao.save(paiement);
            double nvTotalPaye = commandeVo.getTotalPaye()+paiement.getMontant();
            commandeVo.setTotalPaye(nvTotalPaye);
            commandeRequiered.update(commandeVo);
            return 1;
        }
    }

    public Paiement findByReference(String reference) {
        return paiementDao.findByReference(reference);
    }

    public int deleteByReference(String reference) {
        return paiementDao.deleteByReference(reference);
    }

    public List<Paiement> findAll() {
        return paiementDao.findAll();
    }

    @Autowired
    private PaiementDao paiementDao;
    @Autowired
    private CommandeRequiered commandeRequiered;
}
