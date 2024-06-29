package adapter_design_pattern;

public class School {

	public static void main(String[] args) {
		AssignmentWork assignmentWork = new AssignmentWork();
		Pen p = new PenAdapter();
		assignmentWork.setPen(p);
		assignmentWork.writeAssignment("I am bit tried to write so many assigments!!!");

	}

}
