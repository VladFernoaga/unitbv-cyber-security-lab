package ro.vladfernoaga;

public class User {

    private  long id;
    private  String name;
    private  Integer age;

    public User(){}
    

    public User(long id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}

    
}
