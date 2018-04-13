package scudder.automaint.controllers;

import scudder.automaint.domain.Vehicle;
import scudder.automaint.services.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VehicleController {
	
	private VehicleService vehicleService;
	
	@Autowired
	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	
	@RequestMapping(value = "/garage", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("vehicles", vehicleService.listAllVehicles());
		return "garage";
	}

	@RequestMapping("vehicle/{id}")
    public String showVehicle(@PathVariable Integer id, Model model) {
        model.addAttribute("vehicle", vehicleService.getVehicleById(id));
        return "vehicleshow";
    }

    @RequestMapping("vehicle/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("vehicle", vehicleService.getVehicleById(id));
        return "vehicleform";
    }

    @RequestMapping("vehicle/new")
    public String newVehicle(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicleform";
    }

    @RequestMapping(value = "vehicle", method = RequestMethod.POST)
    public String saveVehicle(Vehicle vehicle){
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicle/" + vehicle.getId();
    }

    @RequestMapping("vehicle/delete/{id}")
    public String delete(@PathVariable Integer id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/garage";
    }
}
