package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
/*
	Handles request at path/hello
	@GetMapping("hello")
	@ResponseBody

	public String hello() {
		return "Hello, Spring!";
	}
*/
	//handles request of the form/hello/goodbye
//	@GetMapping("goodbye")
//	public String goodbye() {
//		return "Goodbye, Spring!";
//	}

	//Create handler that handles request of the form/hello?name=LaunchCode
	@RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
	public String helloWithQueryParam(@RequestParam String name, Model model ){
		String greeting = "Hello, " + name + "!";
		model.addAttribute("greeting", greeting);
		return "hello";

	}

	//handles requests of the form/hello/LaunchCode
	@GetMapping("{name}")
	public String helloWithPathParam(@PathVariable String name){
		return "Hello " + name + "!";

	}
	//handler request /hello/form
	@GetMapping("form")
	public String helloForm(){
		return "form";
	}
}
