package br.com.e_commerce.e_commerce.entity;

import br.com.e_commerce.e_commerce.enums.StatusProduto;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoEntity implements Serializable {

    private static final Long SerialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProdutoEntity.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto")
    private LojaEntity loja;

    @Enumerated
    private StatusProduto statusProduto;

    @CreationTimestamp
    private LocalDateTime criadoEm;

    @UpdateTimestamp
    private LocalDateTime atualizadoEm;

}
