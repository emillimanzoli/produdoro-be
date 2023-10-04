package dev.wakandaacademy.produdoro.usuario.application.service;
import dev.wakandaacademy.produdoro.credencial.application.service.CredencialApplicationService;
import dev.wakandaacademy.produdoro.pomodoro.application.service.PomodoroApplicationService;
import dev.wakandaacademy.produdoro.pomodoro.domain.ConfiguracaoPadrao;
import dev.wakandaacademy.produdoro.usuario.application.api.UsuarioCriadoResponse;
import dev.wakandaacademy.produdoro.usuario.application.api.UsuarioNovoRequest;
import dev.wakandaacademy.produdoro.usuario.domain.ConfiguracaoUsuario;
import dev.wakandaacademy.produdoro.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioService implements UsuarioApplicationService {

    private final PomodoroApplicationService pomodoroService;
    private final CredencialApplicationService credencialService;
    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioCriadoResponse criaNovoUsuario(@Valid UsuarioNovoRequest usuarioNovo) {
        log.info("[start] UsuarioService - criaNovoUsuario");
        ConfiguracaoPadrao configuracaoPadrao = pomodoroService.getConfiguracaoPadrao();
        credencialService.criaNovaCredencial(usuarioNovo);
        Usuario usuario = new Usuario(usuarioNovo, configuracaoPadrao);
        usuarioRepository.salva(usuario);
        log.info("[finish] UsuarioService - criaNovoUsuario");
        return new UsuarioCriadoResponse(usuario);
    }
}
