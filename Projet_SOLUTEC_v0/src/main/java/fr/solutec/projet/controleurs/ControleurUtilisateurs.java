package fr.solutec.projet.controleurs;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.solutec.projet.modeles.Produit;

@Controller
@RequestMapping(path="/")
public class ControleurUtilisateurs {
	
	@GetMapping
	public String getIndex() {
		return "accueilUtilisateur";
	}
	
	@GetMapping(path="/catalog")
	  public String getCatalogProduits(@ModelAttribute("utilisateur")Produit produit, BindingResult result) {
		  return "catalogueProduits";
	  }
	

}
