/**
 * @author: Anvar Szulczyk
 * @date: Feb 5, 2024
 */
package com.cogent.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cogent.model.Candidate;
import com.cogent.model.CandidateDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Controller
public class MyController {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	
	public MyController() {
		factory = Persistence.createEntityManagerFactory("springMVC");
		manager = factory.createEntityManager();
	}
	
	@GetMapping("/")
	public ModelAndView getHome(){
		List<Candidate> candidates = getAllCandidates();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("candidates", candidates);
		
		return mv;
	}
	
	/*
	@PostMapping("/send")
	public String get(@RequestBody String name) {
		System.out.println(name);
		return "home";
	}
	*/
	
	@PostMapping("/new")
	public ModelAndView get(Candidate newCan) {
		//System.out.println(newCan);
		
		insertCandidate(newCan);
		List<Candidate> candidates = getAllCandidates();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("candidates", candidates);
		
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView getUpdate(@PathVariable int id){
		Candidate can = manager.find(Candidate.class, id);
		List<Candidate> candidates = getAllCandidates();
		ModelAndView mv = new ModelAndView("update");
		mv.addObject("can", can);
		
		return mv;
	}
	
	@PostMapping("/update")
	public ModelAndView updateCandidate(Candidate updatedCan) {
		//System.out.println(updatedCan);
		
		updateCandidateJPA(updatedCan);
		List<Candidate> candidates = getAllCandidates();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("candidates", candidates);
		
		return mv;
	}
	
	@PostMapping("/delete")
	public ModelAndView deleteCandidate(int id) {
		System.out.println("Candidate id: " + id);
		
		deleteCandidateJPA(id);
		List<Candidate> candidates = getAllCandidates();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("candidates", candidates);
		
		return mv;
	}
	
	private void deleteCandidateJPA(int id) {
    	manager.getTransaction().begin();
    	manager.remove(manager.find(Candidate.class, id));
    	manager.getTransaction().commit();
	}
	
	private void updateCandidateJPA(Candidate updatedCan) {
    	manager.getTransaction().begin();
    	manager.merge(updatedCan);
    	manager.getTransaction().commit();
	}
	
	private void insertCandidate(Candidate can) {
    	manager.getTransaction().begin();
    	manager.persist(can);
    	manager.getTransaction().commit();
	}
	
	private List<Candidate> getAllCandidates() {
		List<Candidate> candidates  = manager.createQuery("Select a From Candidate a", Candidate.class).getResultList();
		//candidates.stream().forEach(System.out::println);
		return candidates;
	}
	

}
