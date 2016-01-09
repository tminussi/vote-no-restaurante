package br.com.bluesoft.restaurante.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurante")
public class Restaurante {

	@Id
	@Column(name = "restaurante_id", nullable = false)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "comida_tipica", nullable = false)
	private String comidaTipica;

	@Column(name = "imagem", nullable = false)
	private String imagem;

	@Column(name = "votos", nullable = false)
	private int votos;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getComidaTipica() {
		return this.comidaTipica;
	}

	public void setComidaTipica(String comidaTipica) {
		this.comidaTipica = comidaTipica;
	}

	public String getImagem() {
		return this.imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public int getVotos() {
		return this.votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurante other = (Restaurante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}