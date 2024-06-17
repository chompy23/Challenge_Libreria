package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DatosListadoMedicos;
import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoReporitory medicoReporitory;


    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico){
        System.out.println("El request llego correctamente");
        medicoReporitory.save(new Medico(datosRegistroMedico));
     }
     @GetMapping
     public Page<DatosListadoMedicos> listadoMedicos(@PageableDefault(size = 2)  Pageable paginacion){
        return medicoReporitory.findAll(paginacion).map(DatosListadoMedicos::new);
     }
}
