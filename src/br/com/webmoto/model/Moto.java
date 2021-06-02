package br.com.webmoto.model;

import java.util.Objects;

//JavaBean >> Serializable, Geters Seters, default contructor, [toString, equals, hash]
//POJO - Plain Old Java Objects

//https://www.devmedia.com.br/use-a-serializacao-em-java-com-seguranca/29012
//https://sites.google.com/site/sureshdevang/java-bean-v-s-pojo
//https://pt.wikipedia.org/wiki/Plain_Old_Java_Objects
//https://pt.wikipedia.org/wiki/JavaBeans


public class Moto {

	private long id;
	public Moto(long id, String name, String brand, String color) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.color = color;
	}

	private String name,
	    brand,
	    color;
	
	public Moto(String name, String brand, String color) {
		super();
		this.name = name;
		this.brand = brand;
		this.color = color;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public Moto() {
		
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", brand=" + brand + ", color=" + color + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, brand, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Moto)) {
			return false;
		}
		Moto other = (Moto) obj;
		return Objects.equals(color, other.color) && Objects.equals(brand, other.brand) && id == other.id
				&& Objects.equals(name, other.name);
	}
	
	
	
	
}
