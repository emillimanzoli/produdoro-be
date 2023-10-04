package dev.wakandaacademy.produdoro.credencial.application.service;

import dev.wakandaacademy.produdoro.usuario.application.api.UsuarioNovoRequest;

import javax.validation.Valid;

public interface CredencialApplicationService {
    void criaNovaCredencial (@Valid UsuarioNovoRequest usarioNovo);
}
