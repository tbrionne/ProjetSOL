package fr.solutec.projet.controleurs;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.solutec.projet.modeles.Admin;
import fr.solutec.projet.modeles.Categorie;
import fr.solutec.projet.modeles.Produit;

@Controller
@RequestMapping(path="/admin")
public class ControleursAdmin {

	
			
	// Appel de la page d'accueil admin :
	@GetMapping
	public String getAdmin(@ModelAttribute("admin") Admin admin) {
		return "accueilAdmin";
	}
	
	// Accès à la page gestionAdmin :
	@PostMapping
	public String getGestionAdmin(HttpServletRequest request, @ModelAttribute("admin") Admin admin) {
		if (request.getParameter("login").equals("admin") &&
				request.getParameter("password").equals("SOLUTEC"))
			return "gestionAdmin";
		else
			return "accueilAdmin";
	}
	
	// Ajout d'un produit :
	@GetMapping(path="/adminGestion")
//	@RequestMapping("adminGestion")
	public String getProduit(@ModelAttribute("produit") Produit produit) {
		return "gestionAdmin";
	}
	
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