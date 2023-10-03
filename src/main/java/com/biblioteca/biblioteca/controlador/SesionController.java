package com.biblioteca.biblioteca.controlador;

import com.biblioteca.biblioteca.modelo.DTO.estudianteUNAS.CredencialUsuario;
import com.biblioteca.biblioteca.modelo.DTO.estudianteUNAS.Estudiante;
import com.biblioteca.biblioteca.modelo.DTO.estudianteUNAS.RegistroEstudiante;
import com.biblioteca.biblioteca.modelo.usuario.Usuario;
import com.biblioteca.biblioteca.modelo.usuario.UsuarioBiblioteca;
import com.biblioteca.biblioteca.servicio.SesionServicio;
import com.biblioteca.biblioteca.utilidades.ConeccionAPIXML;
import com.biblioteca.biblioteca.utilidades.ProblemaDetalle;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genius/api/usuario/")
@Tag(name="Sesion", description = "API para la sesion en el sistema")
public class SesionController {

    @Autowired
    private SesionServicio sesionServicio;

    //@GetMapping("/all")
    private List<Usuario> getAllUserAlum(){
        return  sesionServicio.getALlUsuario();
    }

    @Operation(summary = "Obtener",description = "Retorna detalles del usuario", responses = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa", content = @Content( schema = @Schema(implementation = Usuario.class)))
    })
    @CrossOrigin(origins = {"http://127.0.0.1:5500","http://127.0.0.1:5501","http://localhost:4200","http://127.0.0.1:5502","https://biblioteca-unas.netlify.app"})
    @GetMapping("/login/{correo}")
    public ResponseEntity<?> loginUsuario(@PathVariable String correo){
        System.out.println(correo);
        Usuario usuario = sesionServicio.loginUsuario(correo);
        if(usuario != null){
            return ResponseEntity.ok(usuario);
        }else{
            int statusCode = HttpStatus.NOT_FOUND.value();
            String mensajeTitulo = "El correo no fue encontrado";
            String  mensajeDetalle = "El correo de '" + correo + "' no fue encontrado";
            ProblemaDetalle problemaDetalle =  new ProblemaDetalle(statusCode,mensajeTitulo,mensajeDetalle);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemaDetalle);
        }
    }


    @Operation(summary = "Obtener usuario",description = "Obtienes un usuario que se encuentra en el sistema", responses = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa", content = @Content( schema = @Schema(implementation = RegistroEstudiante.class)))
    })
    @CrossOrigin(origins = {"http://127.0.0.1:5500","http://127.0.0.1:5501","http://localhost:4200","http://127.0.0.1:5502","https://biblioteca-unas.netlify.app"})
    @GetMapping("/valida/{codigo}")
    public ResponseEntity<?> validarEstudiante(@PathVariable String codigo){
        System.out.println("codgo : " + codigo);
        if(!sesionServicio.validaUsuarioBiblioteca(codigo)){
            ConeccionAPIXML coneccionAPIXML = new ConeccionAPIXML();
            if(coneccionAPIXML.existEstudianteUnas(codigo)){
                Estudiante estudiante = coneccionAPIXML.obtenerAlumno(codigo);
                RegistroEstudiante registroEstudiante = new RegistroEstudiante(
                        estudiante.getCodigo(),
                        estudiante.getNombre(),
                        estudiante.getApellidoPaterno(),
                        estudiante.getApellidoMaterno(),
                        "",
                        estudiante.getEmail()
                );
                return ResponseEntity.ok(registroEstudiante);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ProblemaDetalle(
                                HttpStatus.NOT_FOUND.value(),
                                "El usuario no encontrado",
                                "El usuario no forma parte de la organizacion"
                        )
                );
            }
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ProblemaDetalle(
                            HttpStatus.NOT_FOUND.value(),
                            "Usuario ya existe",
                            "El usuario ya se encuentra resitrado en la base de datos de la biblioteca"
                    )
            );
        }
    }

    @Operation(summary = "Registra",description = "Agregar al nuevo usuario", responses = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa", content = @Content( schema = @Schema(implementation = RegistroEstudiante.class)))
    })
    @CrossOrigin(origins = {"http://127.0.0.1:5500","http://127.0.0.1:5501","http://localhost:4200","http://127.0.0.1:5502","https://biblioteca-unas.netlify.app"})
    @PostMapping("/registra")
    public ResponseEntity<?> guardarEstudiante(@RequestBody RegistroEstudiante registroEstudiante){
        try {
            ConeccionAPIXML coneccionAPIXML = new ConeccionAPIXML();
            Estudiante estudiante = coneccionAPIXML.obtenerAlumno(registroEstudiante.getCodigo());
            UsuarioBiblioteca usuarioBiblioteca = sesionServicio.guardarDetallesUsuario(
                    new UsuarioBiblioteca(
                            estudiante.getNombre(),
                            estudiante.getApellidoPaterno(),
                            estudiante.getApellidoMaterno(),
                            "",
                            estudiante.getCodigo(),
                            "",
                            estudiante.getUrlFoto(),
                            ""
                    ));

            sesionServicio.guardarUsuario(
                    new Usuario(
                            estudiante.getNombre() + estudiante.getCodigo(),
                            registroEstudiante.getPassword(),
                            estudiante.getEmail(),
                            "estudiante",
                            usuarioBiblioteca.getIdUsuarioBiblioteca().intValue()
                    ));

            return ResponseEntity.ok("Registro completado exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ProblemaDetalle(
                            HttpStatus.NOT_FOUND.value(),
                            "Error con los datos ingresados",
                            "Verifica que los tados esten correctamente"
                    )
            );
        }
    }

}
