package br.com.e_commerce.e_commerce.entity;

import br.com.e_commerce.e_commerce.enums.LojaSegmentos;
import br.com.e_commerce.e_commerce.enums.StatusLoja;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_LOJA")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LojaEntity implements Serializable {

    private static final Long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cnpj;

    @Enumerated(EnumType.STRING)
    private StatusLoja statusLoja;

    @Enumerated(EnumType.STRING)
    private LojaSegmentos lojaSegmentos;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "loja", fetch = FetchType.LAZY)
    private List<ProdutoEntity> produto = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime criadoEm;

    @UpdateTimestamp
    private LocalDateTime atualizadoEm;
}