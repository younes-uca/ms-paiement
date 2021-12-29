package ma.fst.mspaiement.requiered;


import ma.fst.mspaiement.vo.CommandeVo;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name="MS-COMMANDE", url = "http://localhost:8088")
@FeignClient(name="MS-COMMANDE")
@RibbonClient(name="MS-COMMANDE")
public interface CommandeRequiered {
    @GetMapping("/api/v1/commande/reference/{reference}")
    public CommandeVo findByReference(@PathVariable String reference) ;

    @PutMapping("/api/v1/commande/")
    CommandeVo update(@RequestBody CommandeVo commandeVo);
}
