package fr.solutec.projet.controleurs;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.solutec.projet.modeles.Admin;
import fr.solutec.projet.modeles.Categorie;
import fr.solutec.projet.modeles.Produit;
import fr.solutec.projet.modeles.ProduitRepository;

@Controller
@RequestMapping(path="/admin")
public class ControleursAdmin {

	@Autowired 
	  private ProduitRepository produitRepository;
	
			
	// Appel de la page d'accueil admin :
	@GetMapping
	public String getAdmin(@ModelAttribute("admin") Admin admin) {
		return "accueilAdmin";
	}
	
	// Accès à la page gestionAdmin :
	@PostMapping
	public String getGestionAdmin(HttpServletRequest request, @ModelAttribute("admin") Admin admin, Map<String, Object> model) {
		if (request.getParameter("login").equals("admin") &&
				request.getParameter("password").equals("SOLUTEC")) {
			model.put("gestionAdmin", produitRepository.findAll());
			return "gestionAdmin";
	} else
			return "accueilAdmin";
	} 
	
//	// Ajout d'un produit :
//	@GetMapping(path="/gestionProduits")
//	public String getProduit(@ModelAttribute("produit") Produit produit) {
//		return "gestionAdmin";
//	}
	
	// Affichage des produits sans filtre:
	@GetMapping(path="/produits")
	public @ResponseBody Iterable<Produit> getAllUsers() {
		return produitRepository.findAll();  
	}
	
	
//	// Affichage de tous les produits :
//	@GetMapping(path="/")
//	public String getProduits(Map<String, Object> model) {
//		model.put("gestionAdmin", produitRepository.findAll());
//		return "gestionAdmin";
//		}
	
//	// Création des catégories d'electroménager :
//    @RequestMapping(value="/gestionAdmin")
//    private ModelAndView selectTag() {
//        ModelAndView mav = new ModelAndView("categorieForm");
//         
//        Map<Integer, String > categories = new HashMap<Integer, String>();
//        categories.put(1, "Réfrigérateur");
//        categories.put(2, "Lave-vaisselle");
//        categories.put(3, "Four");
//        categories.put(4, "Plaque de cuisson");
//         
//        mav.addObject("categoriesMap", categories);
//        mav.addObject("electromenager", new Categorie());
//         
//        return mav;
//    }
}