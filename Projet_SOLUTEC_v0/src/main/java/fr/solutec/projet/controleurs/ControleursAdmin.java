package fr.solutec.projet.controleurs;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


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
				@ModelAttribute("admin") Admin admin, Map<String, Object> model, HttpSession session) {
			if (request.getParameter("login").equals("admin") &&
					request.getParameter("password").equals("SOLUTEC")) {
				session.setAttribute("connecte", true);
				model.put("produits", produitRepository.findAll());
				return "gestionAdmin";
			} else {
				session.setAttribute("connecte", false);
				return "accueilAdmin";
			}
		} 
		
		
	// Tri des données :
		@GetMapping(path="/adminTri")
		public String sortProduit(HttpServletRequest request, Map<String, Object> model) {
			// Tri produits par ID
			if(request.getParameter("critere").equals("produit_idAsc"))
				model.put("produits", produitRepository.selectProduitParIdAsc());
			if(request.getParameter("critere").equals("produit_idDesc"))
				model.put("produits", produitRepository.selectProduitParIdDesc());
			// Tri produits par NOM
			if(request.getParameter("critere").equals("produit_nameAsc"))
				model.put("produits", produitRepository.selectProduitParNomAsc());
			if(request.getParameter("critere").equals("produit_nameDesc"))
				model.put("produits", produitRepository.selectProduitParNomDesc());
			// Tri produits par CATEGORIE
			if(request.getParameter("critere").equals("categorie_idAsc"))
				model.put("produits", produitRepository.selectProduitParCategorieAsc());
			if(request.getParameter("critere").equals("categorie_idDesc"))
				model.put("produits", produitRepository.selectProduitParCategorieDesc());
			// Tri produits par MARQUE
			if(request.getParameter("critere").equals("marqueAsc"))
				model.put("produits", produitRepository.selectProduitParMarqueAsc());
			if(request.getParameter("critere").equals("marqueDesc"))
				model.put("produits", produitRepository.selectProduitParMarqueDesc());
			// Tri produits par PRIX
			if(request.getParameter("critere").equals("prixAsc"))
				model.put("produits", produitRepository.selectProduitParPrixAsc());
			if(request.getParameter("critere").equals("prixDesc"))
				model.put("produits", produitRepository.selectProduitParPrixDesc());
			// Tri produits par CATEGORIE ENERGETIQUE
			if(request.getParameter("critere").equals("classe_energetique_idAsc"))
				model.put("produits", produitRepository.selectProduitParClasseEnergetiqueAsc());
			if(request.getParameter("critere").equals("classe_energetique_idDesc"))
				model.put("produits", produitRepository.selectProduitParClasseEnergetiqueDesc());
			// Tri produits par PHOTO
			if(request.getParameter("critere").equals("photoAsc"))
				model.put("produits", produitRepository.selectProduitParPhotoAsc());
			if(request.getParameter("critere").equals("photoDesc"))
				model.put("produits", produitRepository.selectProduitParPhotoDesc());
			return "gestionAdmin";
		}


		// Ajout d'un produit dans la base de données :
		@PostMapping(path="/adminAjouter")
		public String addProduitAdmin (@ModelAttribute("produit") Produit produit,
				@RequestParam("fichierUpload") MultipartFile fichier, HttpServletRequest request,
				BindingResult result, Map<String, Object> model) throws IOException {
			
			System.out.println((!fichier.isEmpty()));
			
			if(produit.getCategorie_id()!=null &&
					produit.getMarque()!=null &&
					produit.getPrix()!=null &&
					produit.getPhoto()!=null &&
					produit.getProduit_name()!=null &&
					(!fichier.isEmpty())) {
				
				String cheminApplication = request.getSession().getServletContext().getRealPath("/");
				String nomFichier = fichier.getOriginalFilename();
				System.out.println(nomFichier); 
				//String nomFichierSansChemin = nomFichier.substring(nomFichier.lastIndexOf(File.separator), 0);
				String nomFichierSansChemin = nomFichier;
				String nomDestination = cheminApplication + "img" + File.separator + nomFichierSansChemin;
				
				File fichierServeur = new File(nomDestination);
				
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fichierServeur));
				
				stream.write(fichier.getBytes());
				stream.close();
				
				produit.setPhoto(nomFichierSansChemin);
				
				produitRepository.save(produit);
				model.put("produits", produitRepository.findAll());
				model.put("ajout", "ok");
				return "gestionAdmin";
			} else {
				System.out.println("echec ajout");
				return "gestionAdmin";
			}	
		}

		
	// Modification d'un produit dans la base de données :

	@PostMapping(path="/adminModifier")
	public String setProduitAdmin (@ModelAttribute("produit") Produit produit, HttpServletRequest request,
			Map<String, Object> model) {
		
		produit.setProduit_id(Integer.parseInt(request.getParameter("id")));
		produit.setProduit_name(request.getParameter("produit_name"));
		produit.setCategorie_id(Integer.parseInt(request.getParameter("categorie_id")));	
		produit.setMarque(request.getParameter("marque"));
		produit.setPrix(Integer.parseInt(request.getParameter("prix")));
		produit.setPhoto(request.getParameter("photo"));
		produit.setClasse_energetique_id(Integer.parseInt(request.getParameter("classe_energetique_id")));
		produitRepository.save(produit);
		model.put("produits", produitRepository.findAll());
		model.put("modification", "ok");
		return "gestionAdmin";
	}
	

	// Suppression d'un produit :
	@GetMapping(path = "/adminSupprimer")
	public String deleteProduitAdmin(HttpServletRequest request, Map<String, Object> model) {
		if (request.getParameter("produit_id") != null) {
			produitRepository.deleteById(Integer.parseInt(request.getParameter("produit_id")));
		}
		model.put("produits", produitRepository.findAll());
		model.put("suppression", "ok");
		return "gestionAdmin";
	}

}