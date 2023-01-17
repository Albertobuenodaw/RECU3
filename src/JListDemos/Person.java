package events.lists;

import java.io.Serializable;

public class Person implements Serializable {
	
	private static final long serialVersionUID = -4068917205321307233L;
	
	private String name;
	private String lastname;

	public Person(String name, String lastname) {
		this.lastname = lastname;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name + " " + lastname;
	}
}
