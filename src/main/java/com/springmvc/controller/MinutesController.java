package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.model.Activity;
import com.springmvc.model.Exercise;
import com.springmvc.service.ExerciseService;

@Controller
public class MinutesController {

	@Autowired
	private ExerciseService exerciseService;

	@RequestMapping("/addMinutes")
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {
		System.out.println("Exercise: " + exercise.getMinutes());
		System.out.println("Activity: " + exercise.getActivity());
		return "addMinutes";
	}

	/*
	@RequestMapping("/addMinutes")
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {
		System.out.println("Exercise: " + exercise.getMinutes());
		return "forward: addMoreMinutes.html";
	}*/

	/*@RequestMapping("/addMinutes")
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {
		System.out.println("Exercise: " + exercise.getMinutes());
		return "redirect: addMoreMinutes.html";
	}*/

	/*@RequestMapping("/addMoreMinutes")
	public String addMoreMinutes(@ModelAttribute("exercise") Exercise exercise) {
		System.out.println("Exercising: " + exercise.getMinutes());
		return "addMinutes";
	}*/

	@RequestMapping(value ="/activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities() {

		return exerciseService.findAllActivities();
	}
}
