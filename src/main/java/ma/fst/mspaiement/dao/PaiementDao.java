package ma.fst.mspaiement.dao;


import ma.fst.mspaiement.bean.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementDao extends JpaRepository<Paiement,Long> {
    Paiement findByReference(String reference);
    int deleteByReference(String reference);
}
