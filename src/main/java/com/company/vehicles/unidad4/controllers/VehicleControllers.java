package main.java.com.company.vehicles.unidad4.controllers;
import org.springframework.web.bind.annotation.RequestControllers;
import org.springframework.web.bind.annotation.RequestMapping;          
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import main.java.com.company.vehicles.unidad4.dto.VehicleResponseDto;
import main.java.com.company.vehicles.unidad4.mappers.VehicleMapper;
import main.java.com.company.vehicles.unidad4.services.VehicleService;
import main.java.com.company.vehicles.unidad4.entity.Vehicle;
import java.util.ArrayList;
import java.util.List;

@RequestControllers
@ResquestMapping("vehicles")
public class VehicleControllers {

    private final ProductService service;

    public ProductsController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<VehicleResponseDto> getAll() {
        List<Vehicle> vehicles = service.getAllVehicles();
        List<VehicleResponseDto> response = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            response.add(VehicleMapper.toResponse(vehicle));
        }
        return response;
    }

    @PatchMapping("/delete/{model}")
    public void deleteVehicle(@PathVariable String model) {
        service.deleteVehicleByModel(model);
    }
}