package studentReport;



public class Courses {
		private int id;
		private String name;
		private String teacher;
		
		private double finalGrade;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTeacher() {
			return teacher;
		}
		public void setTeacher(String teacher) {
			this.teacher = teacher;
		}
		
		public double getFinalGrade() {
			return finalGrade;
		}
		public void setFinalGrade(double finalGrade) {
			this.finalGrade = finalGrade;
		}
}
