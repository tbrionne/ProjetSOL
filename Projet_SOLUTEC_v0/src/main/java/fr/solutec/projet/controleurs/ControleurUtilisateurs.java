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

import fr.solutec.projet.modeles.CategorieRepository;
import fr.solutec.projet.modeles.ClasseEnergetiqueRepository;
import fr.solutec.projet.modeles.Produit;
import fr.solutec.projet.modeles.ProduitRepository;

@Controller
@RequestMapping(path="/")
public class ControleurUtilisateurs {
	@Autowired 
	private ProduitRepository produitRepository;
	@Autowired
	private ClasseEnergetiqueRepository classeEnergetiqueRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	
	@GetMapping
	public String getIndex() {
		return "accueilUtilisateur";
	}
	
	@GetMapping(path="/catalog")
	  public String getCatalogProduits(Map<String, Object> model, HttpServletRequest request) {
		if(request.getParameter("critere")!=null) {
	    	 if( request.getParameter("critere").equals("frigo"))
	    		 model.put("categorie", categorieRepository.selectCategorie1()); 
	    	 if( request.getParameter("critere").equals("lave-vaisselle"))
	    		 model.put("categorie", categorieRepository.selectCategorie2());
	    	 if( request.getParameter("critere").equals("four"))
	    		 model.put("categorie", categorieRepository.selectCategorie3());
	    	 if( request.getParameter("critere").equals("plaques"))
	    		 model.put("categorie", categorieRepository.selectCategorie4());
	     }
	     else {
	    	 model.put("categorie", produitRepository.findAll()); 
	     }
		model.put("marques", produitRepository.selectMarque());
		model.put("classesEnergetiques", produitRepository.selectClasseEnergetique());
		  return "catalogueProduits";
	  }
	@PostMapping(path="/catalog")
	  public String setUtilisateur(@ModelAttribute("produit")Produit produit,HttpServletRequest request, Map<String, Object> model) {
		  produit.setProduit_name(request.getParameter("name"));
//		  produit.setCategorie_id(request.getParameter("idCategorie"));
		  produit.setMarque(request.getParameter("marque"));
		  produit.setPrix(request.getParameter("prix"));
		  produit.setPhoto(request.getParameter("photo"));
		  produit.setClasse_Energetique_Id(request.getParameter("classeEnergetique"));
		  produitRepository.save(produit);
		  model.put("catalogueProduits", produitRepository.findAll()); 
		  return "catalogueProduits";
	}
}
