package dev.wakandaacademy.produdoro.usuario.domain;

import lombok.*;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

@Builder(access = AccessLevel.PACKAGE)
@Getter
public class ConfiguracaoUsuario {
    private Integer tempoMinutosFoco;
    private Integer tempoMinutosPausaCurta;
    private Integer tempoMinutosPausaLonga;
    private Integer repeticoesParaPausaLonga;
}
