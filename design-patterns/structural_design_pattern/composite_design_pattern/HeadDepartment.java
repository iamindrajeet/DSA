package composite_design_pattern;

import java.util.ArrayList;
import java.util.List;

/*
 *  The Composite Element
As a composite class, let’s create a HeadDepartment class:
 */
public class HeadDepartment implements Department {

	private Integer id;
	private String name;

	private List<Department> childDepartments;

	public HeadDepartment(Integer id, String name) {
		this.id = id;
		this.name = name;
		this.childDepartments = new ArrayList<>();
	}

	@Override
	public void printDepartmentName() {
		for (Department d : childDepartments) {
			d.printDepartmentName();
		}

	}

    public void addDepartment(Department department) {
        childDepartments.add(department);
    }

    public void removeDepartment(Department department) {
        childDepartments.remove(department);
    }

}
