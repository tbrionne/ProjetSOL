package fr.solutec.projet.controleurs;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.solutec.projet.modeles.CategorieRepository;
import fr.solutec.projet.modeles.ClasseEnergetiqueRepository;
import fr.solutec.projet.modeles.Produit;
import fr.solutec.projet.modeles.ProduitRepository;

@Controller
@RequestMapping(path = "/")
public class ControleurUtilisateurs {
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private ClasseEnergetiqueRepository classeEnergetiqueRepository;
	@Autowired
	private CategorieRepository categorieRepository;

	@GetMapping(path="/")
	public String getIndex(@ModelAttribute("produit") Produit produit, Map<String, Object> model ,Integer[] tabId, HttpServletRequest request)
	    {
	        tabId=produitRepository.selectProduitId();
	        Integer NombreId= tabId.length;
//	        sort(tabId);
	        
	        Random rand = new Random();
	        Integer n = rand.nextInt(NombreId) ;
	        
	        model.put("IdAleatoire",tabId[n]);
	        model.put("NomAleatoire", produitRepository.selectNomParId(tabId[n]));
	        model.put("PrixAleatoire", produitRepository.selectPrixParId(tabId[n]));
	        model.put("PhotoAleatoire", produitRepository.selectPhotoParId(tabId[n]));
	        System.out.println("Le nom selectionné est"+ model.get("NomAleatoire"));
		return "accueilUtilisateur";
	}

	@GetMapping(path = { "/catalog","/filtre"})
	public String getCatalogProduits(Map<String, Object> model, HttpServletRequest request) {
		if (request.getParameter("critere") != null) {
			model.put("categorie",
					categorieRepository.selectCategorie(Integer.parseInt(request.getParameter("critere"))));
			model.put("nomCat", categorieRepository.selectCategorieNameTitre(Integer.parseInt(request.getParameter("critere"))));
			
		} else {
			model.put("categorie", produitRepository.findAll());

		}
		
		model.put("marques", produitRepository.selectMarque());
		model.put("classesEnergetiques", produitRepository.selectClasseEnergetique());
//		model.put("nomCat", categorieRepository.selectCategorieName());
		model.put("nomClasseEnergetique", classeEnergetiqueRepository.selectClasseEnergetiqueName());

		return "catalogueProduits";
	}

	@PostMapping(path = { "/catalog","/catalog?critere=1","/catalog?critere=2","/catalog?critere=3","/catalog?critere=4"})
	public String setRecherche(HttpServletRequest request, Map<String, Object> model) {
		
		model.put("marques", produitRepository.selectMarque());
		model.put("classesEnergetiques", produitRepository.selectClasseEnergetique());
		model.put("nomClasseEnergetique", classeEnergetiqueRepository.selectClasseEnergetiqueName());
		
		//Test paramètre critere non vide, cad une catégorie est sélectionné
		if (request.getParameter("critere")!=null) {
			model.put("nomCat", categorieRepository.selectCategorieNameTitre(Integer.parseInt(request.getParameter("critere"))));
		// Test paramètre marque non vide
		if (request.getParameter("marque") != null) {
			// Paramètre marque détecté
			// Test paramètre classe energetique non vide
			if (request.getParameter("ce") != null) {
				// Paramètre classe energetique détecté en plus du paramètre marque
				// Test paramètre prix non vide
				if (request.getParameter("prix") != null) {
					// Les trois paramètres sont détectés
					// Filtres sur trois paramètres
					{
					model.put("categorie", produitRepository.selectParFiltresEtCatégorie(Integer.parseInt(request.getParameter("critere")), request.getParameter("marque"), Integer.parseInt(request.getParameter("ce")), Integer.parseInt(request.getParameter("prix"))));
					}
					
				if (request.getParameter("prixMax") != null)
					{
					//Le prix selectionne est la borne superieure
					model.put("categorie", produitRepository.selectParFiltresMaxEtCatégorie(Integer.parseInt(request.getParameter("critere")), request.getParameter("marque"), Integer.parseInt(request.getParameter("ce")), Integer.parseInt(request.getParameter("prixMax"))));
					}
					 
					
				}
				// Pas de paramètre prix
				// Seulement marque et classe
				else {
					// Filtre sur marque et classe
					model.put("categorie", produitRepository.selectParMarqueEtClasseEtCatégorie(Integer.parseInt(request.getParameter("critere")), request.getParameter("marque"), Integer.parseInt(request.getParameter("ce"))));
				}
			}
			// Pas de paramètre classe energetique
			else {
				// Test paramètre prix non vide
				if (request.getParameter("prix") != null) {
					// Filtre sur marque et prix
					model.put("categorie", produitRepository.selectParMarqueEtPrixEtCatégorie(Integer.parseInt(request.getParameter("critere")), request.getParameter("marque"), Integer.parseInt(request.getParameter("prix"))));
				}
				// Pas de paramètre prix
				else {
					// Filtre sur marque
					model.put("categorie", produitRepository.selectParMarqueEtCatégorie(Integer.parseInt(request.getParameter("critere")), request.getParameter("marque")));
				}
			}
			return "catalogueProduits";
		}
		
		// Pas de paramètre marque
		// Test paramètre classe energetique non vide
		if (request.getParameter("ce") != null) {
			// Test paramètre prix non vide
			if (request.getParameter("prix") != null) {
				// Filtre sur classe et prix
				model.put("categorie", produitRepository.selectParClasseEtPrixEtCatégorie(Integer.parseInt(request.getParameter("critere")), Integer.parseInt(request.getParameter("ce")), Integer.parseInt(request.getParameter("prix"))));
			}
			// Pas de paramètre prix
			else {
				// Filtre sur classe
				model.put("categorie", produitRepository.selectParClassesEtCatégorie(Integer.parseInt(request.getParameter("critere")), Integer.parseInt(request.getParameter("ce"))));
			}
			return "catalogueProduits";
		}
		
		// Pas de paramètre classe energetique
		// Test paramètre prix
		if (request.getParameter("prix") != null) {
			// Filtre sur prix
			model.put("categorie", produitRepository.selectPrixEtCatégorie(Integer.parseInt(request.getParameter("critere")), Integer.parseInt(request.getParameter("prix"))));
			return "catalogueProduits";
		}
		if (request.getParameter("prixMax") != null) {
			// Filtre sur prix borne superieure
			model.put("categorie", produitRepository.selectPrixMaxEtCatégorie(Integer.parseInt(request.getParameter("critere")), Integer.parseInt(request.getParameter("prixMax"))));
			return "catalogueProduits";
		}
		
		}
		
		//Toutes les catégories sont sélectionnés, critere=null
		else {
			// Test paramètre marque non vide
			if (request.getParameter("marque") != null) {
				// Paramètre marque détecté
				// Test paramètre classe energetique non vide
				if (request.getParameter("ce") != null) {
					// Paramètre classe energetique détecté en plus du paramètre marque
					// Test paramètre prix non vide
					if (request.getParameter("prix") != null) {
						// Les trois paramètres sont détectés
						// Filtres sur trois paramètres
						{
						model.put("categorie", produitRepository.selectParFiltres(request.getParameter("marque"), Integer.parseInt(request.getParameter("ce")), Integer.parseInt(request.getParameter("prix"))));
						}
						
					if (request.getParameter("prixMax") != null)
						{
						//Le prix selectionne est la borne superieure
						model.put("categorie", produitRepository.selectParFiltresMax(request.getParameter("marque"), Integer.parseInt(request.getParameter("ce")), Integer.parseInt(request.getParameter("prixMax"))));
						}
						 
						
					}
					// Pas de paramètre prix
					// Seulement marque et classe
					else {
						// Filtre sur marque et classe
						model.put("categorie", produitRepository.selectParMarqueEtClasse(request.getParameter("marque"), Integer.parseInt(request.getParameter("ce"))));
					}
				}
				// Pas de paramètre classe energetique
				else {
					// Test paramètre prix non vide
					if (request.getParameter("prix") != null) {
						// Filtre sur marque et prix
						model.put("categorie", produitRepository.selectParMarqueEtPrix(request.getParameter("marque"), Integer.parseInt(request.getParameter("prix"))));
					}
					// Pas de paramètre prix
					else {
						// Filtre sur marque
						model.put("categorie", produitRepository.selectParMarque(request.getParameter("marque")));
					}
				}
				return "catalogueProduits";
			}
			
			// Pas de paramètre marque
			// Test paramètre classe energetique non vide
			if (request.getParameter("ce") != null) {
				// Test paramètre prix non vide
				if (request.getParameter("prix") != null) {
					// Filtre sur classe et prix
					model.put("categorie", produitRepository.selectParClasseEtPrix(Integer.parseInt(request.getParameter("ce")), Integer.parseInt(request.getParameter("prix"))));
				}
				// Pas de paramètre prix
				else {
					// Filtre sur classe
					model.put("categorie", produitRepository.selectParClasses(Integer.parseInt(request.getParameter("ce"))));
				}
				return "catalogueProduits";
			}
			
			// Pas de paramètre classe energetique
			// Test paramètre prix
			if (request.getParameter("prix") != null) {
				// Filtre sur prix
				model.put("categorie", produitRepository.selectPrix(Integer.parseInt(request.getParameter("prix"))));
				return "catalogueProduits";
			}
			if (request.getParameter("prixMax") != null) {
				// Filtre sur prix borne superieure
				model.put("categorie", produitRepository.selectPrixMax(Integer.parseInt(request.getParameter("prixMax"))));
				return "catalogueProduits";
			}
			
			}
		
		return "catalogueProduits";

	}

}

