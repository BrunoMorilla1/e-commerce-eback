package br.com.e_commerce.e_commerce.entity;


import br.com.e_commerce.e_commerce.enums.RoleUsuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity implements Serializable {

    private final static long SerialVersionUID = 1L;
    private final static Logger log = LoggerFactory.getLogger(UsuarioEntity.class);

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

    @Enumerated
    private RoleUsuario roleUsuario;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<LojaEntity> lojas;

    @CreationTimestamp
    private LocalDateTime criadoEm;

    @UpdateTimestamp
    private LocalDateTime atualizadoEm;
}
