package ficheros;

import java.io.Serializable;
import java.util.Objects;

public class Mensaje implements Serializable {

	private static final long serialVersionUID = 378393508666255153L;

	private int id = 0;
	private String emisor = null;
	private String receptor = null;
	private String mensaje = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getReceptor() {
		return receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emisor, id, mensaje, receptor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensaje other = (Mensaje) obj;
		return Objects.equals(emisor, other.emisor) && id == other.id && Objects.equals(mensaje, other.mensaje)
				&& Objects.equals(receptor, other.receptor);
	}

	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", emisor=" + emisor + ", receptor=" + receptor + ", mensaje=" + mensaje
				+ ", getId()=" + getId() + ", getEmisor()=" + getEmisor() + ", getReceptor()=" + getReceptor()
				+ ", getMensaje()=" + getMensaje() + "]";
	}
}