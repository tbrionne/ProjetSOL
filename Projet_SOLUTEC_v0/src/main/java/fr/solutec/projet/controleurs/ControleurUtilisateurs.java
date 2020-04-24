package fr.solutec.projet.controleurs;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.solutec.projet.modeles.CategorieRepository;
import fr.solutec.projet.modeles.ClasseEnergetiqueRepository;
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

	@GetMapping
	public String getIndex() {
		return "accueilUtilisateur";
	}

	@GetMapping(path = "/catalog")
	public String getCatalogProduits(Map<String, Object> model, HttpServletRequest request) {
		if (request.getParameter("critere") != null) {
			model.put("categorie",
					categorieRepository.selectCategorie(Integer.parseInt(request.getParameter("critere"))));
		} else {
			model.put("categorie", produitRepository.findAll());

		}

		model.put("marques", produitRepository.selectMarque());
		model.put("classesEnergetiques", produitRepository.selectClasseEnergetique());
		model.put("nomCat", categorieRepository.selectCategorieName());
		model.put("nomClasseEnergetique", classeEnergetiqueRepository.selectClasseEnergetiqueName());

		return "catalogueProduits";
	}

	@PostMapping(path = "/filtre")
	public String setRecherche(HttpServletRequest request, Map<String, Object> model) {
		
		model.put("marques", produitRepository.selectMarque());
		model.put("classesEnergetiques", produitRepository.selectClasseEnergetique());
		model.put("nomCat", categorieRepository.selectCategorieName());
		model.put("nomClasseEnergetique", classeEnergetiqueRepository.selectClasseEnergetiqueName());
		
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
					model.put("categorie", produitRepository.selectParFiltres(request.getParameter("marque"), Integer.parseInt(request.getParameter("ce")), Integer.parseInt(request.getParameter("prix"))));
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

		return "catalogueProduits";

	}

}
