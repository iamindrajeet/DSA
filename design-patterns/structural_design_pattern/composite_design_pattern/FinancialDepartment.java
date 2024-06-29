package composite_design_pattern;

/*
 * 
 * 
 * Leafs
For the leaf components, let’s define classes for financial and sales departments:
 */
public class FinancialDepartment implements Department {

    private Integer id;
    private String name;

    
    public FinancialDepartment(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    // standard constructor, getters, setters
    
}