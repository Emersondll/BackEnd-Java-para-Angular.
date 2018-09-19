package com.meuprincipe.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Marca {

	private Integer marcaID;
	private String marcaNome;

	public Integer getMarcaID() {
		return marcaID;
	}

	public void setMarcaID(Integer marcaID) {
		this.marcaID = marcaID;
	}

	public String getMarcaNome() {
		return marcaNome;
	}

	public void setMarcaNome(String marcaNome) {
		this.marcaNome = marcaNome;
	}

	@Override
	public String toString() {
		return "Marca [marcaID=" + marcaID + ", marcaNome=" + marcaNome + ", getMarcaID()=" + getMarcaID()
				+ ", getMarcaNome()=" + getMarcaNome() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marcaID == null) ? 0 : marcaID.hashCode());
		result = prime * result + ((marcaNome == null) ? 0 : marcaNome.hashCode());
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
		Marca other = (Marca) obj;
		if (marcaID == null) {
			if (other.marcaID != null)
				return false;
		} else if (!marcaID.equals(other.marcaID))
			return false;
		if (marcaNome == null) {
			if (other.marcaNome != null)
				return false;
		} else if (!marcaNome.equals(other.marcaNome))
			return false;
		return true;
	}

}
