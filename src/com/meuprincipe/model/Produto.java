package com.meuprincipe.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produto {

	private Integer produtoId;
	private String produtoNome;
	private Integer produtoQuantidade;
	private Float produtoValor;
	private String produtoLicenciado;
	private String produtoMarca;
	private String produtoCodigo;
	private String produtoGrade;

	public String getProdutoGrade() {
		return produtoGrade;
	}

	public void setProdutoGrade(String produtoGrade) {
		this.produtoGrade = produtoGrade;
	}

	public String getProdutoMarca() {
		return produtoMarca;
	}

	public void setProdutoMarca(String produtoMarca) {
		this.produtoMarca = produtoMarca;
	}

	public String getProdutoCodigo() {
		return produtoCodigo;
	}

	public void setProdutoCodigo(String produtoCodigo) {
		this.produtoCodigo = produtoCodigo;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	public Integer getProdutoQuantidade() {
		return produtoQuantidade;
	}

	public void setProdutoQuantidade(Integer produtoQuantidade) {
		this.produtoQuantidade = produtoQuantidade;
	}

	public Float getProdutoValor() {
		return produtoValor;
	}

	public void setProdutoValor(Float produtoValor) {
		this.produtoValor = produtoValor;
	}

	public String getProdutoLicenciado() {
		return produtoLicenciado;
	}

	public void setProdutoLicenciado(String produtoLicenciado) {
		this.produtoLicenciado = produtoLicenciado;
	}

	@Override
	public String toString() {
		return "Produto [produtoId=" + produtoId + ", produtoNome=" + produtoNome + ", produtoQuantidade="
				+ produtoQuantidade + ", produtoValor=" + produtoValor + ", produtoLicenciado=" + produtoLicenciado
				+ ", produtoMarca=" + produtoMarca + ", produtoCodigo=" + produtoCodigo + ", produtoGrade="
				+ produtoGrade + ", getProdutoGrade()=" + getProdutoGrade() + ", getProdutoMarca()=" + getProdutoMarca()
				+ ", getProdutoCodigo()=" + getProdutoCodigo() + ", getProdutoId()=" + getProdutoId()
				+ ", getProdutoNome()=" + getProdutoNome() + ", getProdutoQuantidade()=" + getProdutoQuantidade()
				+ ", getProdutoValor()=" + getProdutoValor() + ", getProdutoLicenciado()=" + getProdutoLicenciado()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produtoCodigo == null) ? 0 : produtoCodigo.hashCode());
		result = prime * result + ((produtoGrade == null) ? 0 : produtoGrade.hashCode());
		result = prime * result + ((produtoId == null) ? 0 : produtoId.hashCode());
		result = prime * result + ((produtoLicenciado == null) ? 0 : produtoLicenciado.hashCode());
		result = prime * result + ((produtoMarca == null) ? 0 : produtoMarca.hashCode());
		result = prime * result + ((produtoNome == null) ? 0 : produtoNome.hashCode());
		result = prime * result + ((produtoQuantidade == null) ? 0 : produtoQuantidade.hashCode());
		result = prime * result + ((produtoValor == null) ? 0 : produtoValor.hashCode());
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
		Produto other = (Produto) obj;
		if (produtoCodigo == null) {
			if (other.produtoCodigo != null)
				return false;
		} else if (!produtoCodigo.equals(other.produtoCodigo))
			return false;
		if (produtoGrade == null) {
			if (other.produtoGrade != null)
				return false;
		} else if (!produtoGrade.equals(other.produtoGrade))
			return false;
		if (produtoId == null) {
			if (other.produtoId != null)
				return false;
		} else if (!produtoId.equals(other.produtoId))
			return false;
		if (produtoLicenciado == null) {
			if (other.produtoLicenciado != null)
				return false;
		} else if (!produtoLicenciado.equals(other.produtoLicenciado))
			return false;
		if (produtoMarca == null) {
			if (other.produtoMarca != null)
				return false;
		} else if (!produtoMarca.equals(other.produtoMarca))
			return false;
		if (produtoNome == null) {
			if (other.produtoNome != null)
				return false;
		} else if (!produtoNome.equals(other.produtoNome))
			return false;
		if (produtoQuantidade == null) {
			if (other.produtoQuantidade != null)
				return false;
		} else if (!produtoQuantidade.equals(other.produtoQuantidade))
			return false;
		if (produtoValor == null) {
			if (other.produtoValor != null)
				return false;
		} else if (!produtoValor.equals(other.produtoValor))
			return false;
		return true;
	}



}
