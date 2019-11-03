package space.srikanth.heyhere;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ColourController {

	@GetMapping("/here")
	public String setBackGround(@RequestParam(name = "colour", required = false, defaultValue = "ffffff") String backGroundColour, Model model) {
		model.addAttribute("backGroundColour", backGroundColour);
		return "here";
	}

}
