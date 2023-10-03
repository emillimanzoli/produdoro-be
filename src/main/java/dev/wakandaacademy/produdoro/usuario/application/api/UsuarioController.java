package dev.wakandaacademy.produdoro.usuario.application.api;
import dev.wakandaacademy.produdoro.usuario.application.service.UsuarioApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@Validated
@Log4j2
@RequiredArgsConstructor
public class UsuarioController implements UsuarioAPI {
    private final UsuarioApplicationService usuarioApplicationService;

    @Override
    public UsuarioCriadoResponse postNovoUsuario(@Valid UsuarioNovoRequest usuarioNovo) {
        log.info("[start] UsuarioController - postNovoUsuario");
        log.info("[finish] UsuarioController - postNovoUsuario");
        UsuarioCriadoResponse usuarioCriado = usuarioApplicationService.criaNovoUsuario(usuarioNovo);
        return usuarioCriado;
    }
}
