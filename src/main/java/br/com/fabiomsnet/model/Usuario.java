package br.com.fabiomsnet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column (name="firstName", nullable=false, unique=true)
	private String primeiroNome;
	
	@Column (name="lastName", nullable=false, unique=true)
	private String ultimoNome;
	
	@Column (name="email", nullable=false, unique=true)
	private String email;
	
	@Column (name="state", nullable=false, unique=true)
	private String estado;
	
	@Column (name="city", nullable=false, unique=true)
	private String cidade;
	
	@Column (name="active", nullable=false, unique=true)
	private boolean ativo;
	
	@Column (name="status", nullable=false, unique=true)
	private boolean status;
	
	@Column (name="registrationDate", unique=true)
	private Date dataCadastro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
