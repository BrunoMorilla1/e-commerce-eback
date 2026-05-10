package br.com.e_commerce.e_commerce.entity;


import br.com.e_commerce.e_commerce.enums.RoleUsuario;
import br.com.e_commerce.e_commerce.enums.StatusUsuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity implements Serializable {

    private final static long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    private String dataDeNascimento;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private StatusUsuario statusUsuario;

    @Enumerated(EnumType.STRING)
    private RoleUsuario roleUsuario;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<LojaEntity> lojas = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime criadoEm;

    @UpdateTimestamp
    private LocalDateTime atualizadoEm;
}
