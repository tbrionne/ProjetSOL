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

import fr.solutec.projet.modeles.Admin;
import fr.solutec.projet.modeles.Produit;
import fr.solutec.projet.modeles.ProduitRepository;

@Controller
@RequestMapping(path = "/")
public class ControleursAdmin {

	@Autowired
	private ProduitRepository produitRepository;

	// Appel de la page d'accueil admin via l'URL :
	@GetMapping(path = "/admin")
	public String getAdmin(@ModelAttribute("admin") Admin admin) {
		return "accueilAdmin";
	}

	// Connexion à la page gestionAdmin (login : admin et mdp : SOLUTEC) :
		@PostMapping(path="/admin")
		public String getGestionAdmin(HttpServletRequest request, @ModelAttribute("produit") Produit produit, 
				@ModelAttribute("admin") Admin admin, Map<String, Object> model) {
			if (request.getParameter("login").equals("admin") &&
					request.getParameter("password").equals("SOLUTEC")) {
//				Admin administrateur = new Admin(Integer.parseInt(request.getParameter("idAdmin")), 
//						request.getParameter("login").trim(), 
//						request.getParameter("password").trim());
//				HttpSession session = request.getSession();
//			    session.setAttribute("admin", administrateur);
//			    out.println("Vous êtes connecté avec le nom de compte admin");
				model.put("produits", produitRepository.findAll());
				return "gestionAdmin";
			} else
				return "accueilAdmin";
		} 
		
		
//	// Vérifier les paramètres de connexion :
//    // Si les identifiants sont bons :
//    if(request.getParameter("username").trim().contains("user") && 
//            request.getParameter("password").trim().contains("user")) {
//                User user = new User(
//                request.getParameter("username").trim(),
//                request.getParameter("password").trim()
//            );
//            HttpSession session = request.getSession();
//            session.setAttribute("user", user);
//            out.println("<div class = 'succes'>Vous êtes connecté avec le nom de compte "
//                    + request.getParameter("username") + ".</div>");
//    }
//    // Si les identifiants sont mauvais :
//    else {
//            out.println("<div class = 'echec'>Paramètres de connexions incorrects !<br><br></div>");
//            request.getRequestDispatcher("/WEB-INF/Include/login_form.html").include(request, response);
//    }


	// Tri des données :
//		@GetMapping(path="/adminTri")
//		public String sortProduit(HttpServletRequest request, Map<String, Object> model) {
//			if(request.getParameter("critere").equals("produit_idAsc"))
//				model.put("produits", produitRepository.selectProduitParIdAsc());
//			if(request.getParameter("critere").equals("produit_idDesc"))
//				model.put("produits", produitRepository.selectProduitParIdDesc());
//			if(request.getParameter("critere").equals("produit_nameAsc"))
//				model.put("produits", produitRepository.selectProduitParNomAsc());
//			if(request.getParameter("critere").equals("produit_nameDesc"))
//				model.put("produits", produitRepository.selectProduitParNomDesc());
//			return "gestionAdmin";
//		}


		// Ajout d'un produit dans la base de données :
		@PostMapping(path="/adminAjouter")
		public String addProduitAdmin (@ModelAttribute("produit") Produit produit,
				BindingResult result, Map<String, Object> model) {
			if(produit.getCategorie_id()!=null &&
					produit.getMarque()!=null &&
					produit.getPrix()!=null &&
					produit.getPhoto()!=null &&
					produit.getProduit_name()!=null) {
				produitRepository.save(produit);
				model.put("produits", produitRepository.findAll());
				return "gestionAdmin";
			} else {
				System.out.println("echec ajout");
				return "gestionAdmin";
			}	
		}


	
	
	
	// Modification d'un produit dans la base de données :

	@PostMapping(path="/adminModifier")
	public String setProduitAdmin (@ModelAttribute("produit") Produit produit, HttpServletRequest request,
			BindingResult result, Map<String, Object> model) {
		
		produit.setProduit_id(Integer.parseInt(request.getParameter("id")));
		produit.setProduit_name(request.getParameter("produit_name"));
		//produit.setCategorie_id(Integer.parseInt(request.getParameter("categorie_id")));
		System.out.println("entre dans le post modifier");
		
		produit.setMarque(request.getParameter("marque"));
		produit.setPrix(Integer.parseInt(request.getParameter("prix")));
		produit.setPhoto(request.getParameter("photo")); 
		
//		produit.setClasse_Energetique_Id(request.getParameter("classe_energetique_id"));
		produitRepository.save(produit);
		model.put("produits", produitRepository.findAll());
		return "gestionAdmin";
	}
	
	
	
	
	
	

//	@PostMapping(path="/adminModifier")
//	public String setProduitAdmin (@ModelAttribute("produit") Produit produit, HttpServletRequest request,
//			BindingResult result, Map<String, Object> model) {
//		produit.setProduit_name(request.getParameter("produit_name"));
//		produit.setCategorie_id(Integer.parseInt(request.getParameter("categorie_id")));
//		produit.setMarque(request.getParameter("marque"));
//		produit.setPrix(request.getParameter("prix"));
//		produit.setPhoto(request.getParameter("photo")); 
////			produit.setClasse_Energetique_Id(request.getParameter("classe_energetique_id"));
//		produitRepository.save(produit);
//		model.put("produits", produitRepository.findAll());
//		return "gestionAdmin";
//	}


	// Suppression d'un produit :
	@GetMapping(path = "/adminSupprimer")
	public String deleteProduitAdmin(HttpServletRequest request, Map<String, Object> model) {
		if (request.getParameter("produit_id") != null) {
			produitRepository.deleteById(Integer.parseInt(request.getParameter("produit_id")));
		}
		model.put("produits", produitRepository.findAll());
		return "gestionAdmin";
	}

}