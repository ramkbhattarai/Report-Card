package studentReport;



public class Student {
		private int id;
		private String name;
		private double totalAverage;
		private Courses course = new Courses();
		
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
		public double getTotalAverage() {
			return totalAverage;
		}
		public void setTotalAverage(double totalAverage) {
			this.totalAverage = totalAverage;
		}
		public Courses getCourse() {
			return course;
		}
		public void setCourse(Courses course) {
			this.course = course;
		}
		
		
		
		
		
}
