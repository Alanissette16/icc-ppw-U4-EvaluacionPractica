package main.java.com.company.vehicles.unidad4.controllers;
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
    public  findAll() {

        // Programación tradicional iterativa para mapear cada Vehicle a VehicleResponseDto
        List<VehicleResponseDto> dtos = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            dtos.add(VehicleMapper.toResponse(user));
        }
        return dtos;
    }

    @PatchMapping("/delete/{model}")
    public Object partialUpdate(@PathVariable int id, @RequestBody PartialUpdateUserDto dto) {

      // Programacion tradicional iterativa
        for (User user : users) {
          // ESTE ES EL CAMBIO pero deberia estar en un metodo aparte para evitar duplicacion de codigo y mejorar mantenibilidad con separacion de responsabilidades.
            if (user.getId() == id) {
                if (dto.name != null) user.setName(dto.name);
                if (dto.email != null) user.setEmail(dto.email);
                return UserMapper.toResponse(user);
            }
        }
        return new Object() { 
            public String error = "User not found"; 
        };
    }
}