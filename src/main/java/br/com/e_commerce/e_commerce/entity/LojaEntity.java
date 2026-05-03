package br.com.e_commerce.e_commerce.entity;

import br.com.e_commerce.e_commerce.enums.LojaSegmentos;
import br.com.e_commerce.e_commerce.enums.StatusLoja;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_LOJA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LojaEntity implements Serializable {

    private static final Long SerialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LojaEntity.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cnpj;

    @Enumerated
    private StatusLoja statusLoja;

    @Enumerated
    private LojaSegmentos lojaSegmentos;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "loja", fetch = FetchType.LAZY)
    private ProdutoEntity produto;

    @CreationTimestamp
    private LocalDateTime criadoEm;

    @UpdateTimestamp
    private LocalDateTime atualizadoEm;
}