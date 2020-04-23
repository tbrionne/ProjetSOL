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
		for (String s : produitRepository.selectMarque()) {
			if (request.getParameter(s) != null) {
				model.put("categorie", (produitRepository.selectParMarque(s)));
			}
		}
		if (request.getParameter("prix1") != null) {
			model.put("categorie", categorieRepository.selectPrix1());
		}
		if (request.getParameter("prix2") != null) {
			model.put("categorie", categorieRepository.selectPrix2());
		}
		if (request.getParameter("prix3") != null) {
			model.put("categorie", categorieRepository.selectPrix3());
		}
		model.put("marques", produitRepository.selectMarque());
		model.put("classesEnergetiques", produitRepository.selectClasseEnergetique());
		model.put("nomCat", categorieRepository.selectCategorieName());
		model.put("nomClasseEnergetique", classeEnergetiqueRepository.selectClasseEnergetiqueName());

		return "catalogueProduits";

	}

}
