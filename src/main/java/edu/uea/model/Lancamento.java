package edu.uea.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "lancamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lancamento {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long codigo;

   @NotNull
   private String descricao;

   @NotNull
   private BigDecimal valor;

   @NotNull
   private LocalDate dataVencimento;

   private LocalDate dataPagamento;

   private String observacao;

   @NotNull
   @Enumerated(EnumType.STRING)
   private TiposLancamento tipo;

   @ManyToOne
   @JoinColumn(name = "categoria_codigo")
   private Categoria categoria;

   @ManyToOne
   @JoinColumn(name = "pessoa_codigo")
   private Pessoa pessoa;
}
