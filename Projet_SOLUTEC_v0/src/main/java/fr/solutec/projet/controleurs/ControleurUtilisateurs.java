package fr.solutec.projet.controleurs;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import fr.solutec.projet.modeles.Produit;
import fr.solutec.projet.modeles.ProduitRepository;

@Controller
@RequestMapping(path="/")
public class ControleurUtilisateurs {
	@Autowired 
	  private ProduitRepository produitRepository;
	
	@GetMapping
	public String getIndex() {
		return "accueilUtilisateur";
	}
	
	@GetMapping(path="/catalog")
	  public String getCatalogProduits(@ModelAttribute("produit")Produit produit, BindingResult result, Map<String, Object> model) {
		model.put("catalogueProduits", produitRepository.findAll());
		  return "catalogueProduits";
	  }
	@PostMapping(path="/catalog")
	  public String setUtilisateur(@ModelAttribute("produit")Produit produit,HttpServletRequest request, Map<String, Object> model) {
		  produit.setProduit_name(request.getParameter("name"));
		  produit.setCategorie_id(request.getParameter("idCategorie"));
		  produit.setMarque(request.getParameter("marque"));
		  produit.setPrix(request.getParameter("prix"));
		  produit.setPhoto(request.getParameter("photo"));
		  produit.setClasse_Energetique_Id(request.getParameter("classeEnergetique"));
		  produitRepository.save(produit);
		  model.put("catalogueProduits", produitRepository.findAll()); 
		  return "catalogueProduits";
	}
}
