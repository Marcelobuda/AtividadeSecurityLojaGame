package org.generation.lojadegames.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	

	@NotBlank(message = "O atributo nome jogo é Obrigatório")
	@Size(min = 5, max = 100, message = "O atributo nome deve conter no minimo 05 e no máximo 500 caracteres")
	private String nomejogo;
	
	@NumberFormat(style = Style.CURRENCY)
	private float valor;

	private String classificacao;
	@NotBlank(message = "O atributo classificação é obrigatorio!")
	@Size(min = 5, max = 100, message = "O atributo fornecedor deve conter no minimo 05 caracteres")
	
	private String console;
	@NotBlank(message = "O atributo console é obrigatorio!")
	@Size(min = 2, max = 100, message = "O atributo lote deve conter no minimo 02 caracteres")
	
	@DateTimeFormat(pattern="DD-MM-YYYY")
	private LocalDateTime lancamento;
	
	@ManyToOne
	@JsonIgnoreProperties ("produto")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomejogo() {
		return nomejogo;
	}
	public void setNomejogo(String nomejogo) {
		this.nomejogo = nomejogo;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	public LocalDateTime getLancamento() {
		return lancamento;
	}
	public void setLancamento(LocalDateTime lancamento) {
		this.lancamento = lancamento;
	}
	
		

}
