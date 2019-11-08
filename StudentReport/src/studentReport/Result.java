package studentReport;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Scanner;




public class Result {
	
	
	public static ArrayList<Student> prepareListOfStudents() {
		String students = "src/studentReport/students.csv";
	       
        File file = new File(students);
        
        ArrayList<Student> std = new ArrayList<Student>();
        	ArrayList<String> ex = new ArrayList<String>();
        try{
        	
           
            Scanner inputStream = new Scanner(file);
           
            while(inputStream.hasNext()){
                
                String data = inputStream.next();
                	
                
                	ex.add(data);

            }
          
            inputStream.close();


        }catch (FileNotFoundException e){
        	
            e.printStackTrace();
        }
        
        
        
       for(int i = 1; i < ex.size(); i++) {
    	   String s = ex.get(i);
    	   Student stds = new Student();
    	   String id = s.split(",")[0];
    	   int idstds = Integer.parseInt(id);
    	   stds.setId(idstds);
    	   String name = s.split(",")[1];
    	   stds.setName(name);
    	   std.add(stds);
    	   
       }
       return std;
	}
	
	public static ArrayList<Courses> prepareListOfCourses() {
		String course = "src/studentReport/courses.csv";
	       
        File file = new File(course);
        
        ArrayList<Courses> courses = new ArrayList<Courses>();
        	ArrayList<String> ex = new ArrayList<String>();
        try{
        	
           
            Scanner inputStream = new Scanner(file);
           
            while(inputStream.hasNextLine()){
                
                String data = inputStream.nextLine();
                	
                
                	ex.add(data);

            }
          
            inputStream.close();


        }catch (FileNotFoundException e){
        	
            e.printStackTrace();
        }
        
        
        
       for(int i = 1; i < ex.size(); i++) {
    	   String s = ex.get(i);
    	   //System.out.println(s);
    	  // String[] check = s.split(",");
    	   //System.out.println(Arrays.toString(check));
    	   Courses crs = new Courses();
    	   String id = s.split(",")[0];
    	  // System.out.println(id);
    	   int idstds = Integer.parseInt(id);
    	   crs.setId(idstds);
    	   String name = s.split(",")[1];
    	   crs.setName(name);
    	   String teacher = s.split(",")[2];
    	   //System.out.println(teacher);
    	   crs.setTeacher(teacher);
    	   courses.add(crs);
    	   
       }
       return courses;
	}
	
	public static ArrayList<Tests> prepareListOfTests() {
		String test = "src/studentReport/tests.csv";
	       
        File file = new File(test);
        
        ArrayList<Tests> tests = new ArrayList<Tests>();
        	ArrayList<String> ex = new ArrayList<String>();
        try{
        	
           
            Scanner inputStream = new Scanner(file);
           
            while(inputStream.hasNext()){
                
                String data = inputStream.next();
                	
                
                	ex.add(data);

            }
          
            inputStream.close();


        }catch (FileNotFoundException e){
        	
            e.printStackTrace();
        }
        
        
        
       for(int i = 1; i < ex.size(); i++) {
    	   String s = ex.get(i);
    	   Tests tst = new Tests();
    	   String id = s.split(",")[0];
    	   int idstds = Integer.parseInt(id);
    	   tst.setId(idstds);
    	   String courseId = s.split(",")[1];
    	   int crsId = Integer.parseInt(courseId);
    	   tst.setCourseId(crsId);
    	   String weight = s.split(",")[2];
    	   int tstweight = Integer.parseInt(weight);
    	   tst.setWeight(tstweight);
    	   tests.add(tst);
    	   
       }

       return tests;
	}
	
	
	public static ArrayList<Marks> prepareListOfMarks() {
		String test = "src/studentReport/marks.csv";
	       
        File file = new File(test);
        
        ArrayList<Marks> marks = new ArrayList<Marks>();
        	ArrayList<String> ex = new ArrayList<String>();
        try{
        	
           
            Scanner inputStream = new Scanner(file);
           
            while(inputStream.hasNext()){
                
                String data = inputStream.next();
                	
                
                	ex.add(data);

            }
          
            inputStream.close();


        }catch (FileNotFoundException e){
        	
            e.printStackTrace();
        }
        
        
        
       for(int i = 1; i < ex.size(); i++) {
    	   String s = ex.get(i);
    	   Marks mark = new Marks();
    	   String id = s.split(",")[0];
    	   int idstds = Integer.parseInt(id);
    	   mark.setTestId(idstds);
    	   String courseId = s.split(",")[1];
    	   int crsId = Integer.parseInt(courseId);
    	   mark.setStudentId(crsId);
    	   String weight = s.split(",")[2];
    	   int tstweight = Integer.parseInt(weight);
    	   mark.setMark(tstweight);
    	   marks.add(mark);
    	   
       }

       return marks;
	}
	

	public static void main(String[] args) {
		ArrayList<Student> students = prepareListOfStudents();
        ArrayList<Courses> courses = prepareListOfCourses();
		ArrayList<Tests> tests = prepareListOfTests();
       ArrayList<Marks> marks = prepareListOfMarks();

       
       // changed marks according to test weight and give them course id
       for(int i = 0; i < tests.size(); i++) {
    	   Tests t = tests.get(i);
    	   for(int j = 0; j < marks.size(); j++) {
    		   Marks m = marks.get(j);
    		   if(m.getTestId() == t.getId()) { 
    			   double changeMarks = m.getMark() * t.getWeight()/100.00;
				   m.setMark(changeMarks);
				   m.setCourseId(t.getCourseId());
    		   }
    		  
    	   }
       }
       

       
       
       
       
       HashMap<Student, HashMap<Courses, ArrayList<Marks>> > newStudents = new HashMap<Student, HashMap<Courses, ArrayList<Marks>>>();
       // collecting the marks for each student in hashmap according to the course
       for(int i  = 0; i < students.size(); i++) {
      	 Student s = students.get(i);
      	 
      	 HashMap<Courses, ArrayList<Marks>>  newCourses = new HashMap<Courses, ArrayList <Marks> >();
      	 
      	 for(int k = 0; k < courses.size(); k++) {
      		 Courses c = courses.get(k);
      		 
      		 ArrayList<Marks> marksAccCourse = new ArrayList<Marks>();
      		
      		 for(int j = 0; j < marks.size(); j++) {
      			 Marks m = marks.get(j);
      			 
      			 if((s.getId() == m.getStudentId()) && (m.getCourseId() == c.getId()) ){
      				marksAccCourse.add(m);
      			 }
      			
      			 
      		 }
      		 newCourses.put(c, marksAccCourse);
      	 }
      	 newStudents.put(s, newCourses);
      	 
       }
       
       
       
       
       
       
       
       
 newStudents.entrySet().forEach(std->{
           
           ArrayList<Double> scores = new ArrayList<Double>();
         
           
           HashMap<Courses, ArrayList<Marks>>  newCourses =  std.getValue(); 
           
           
               newCourses.entrySet().forEach(crs -> {
                   
                 
                   ArrayList<Marks> marksAccCourse = crs.getValue();
                   double sum = 0.0;
                 
                   for(int i = 0; i < marksAccCourse.size(); i++) {
                     
                           
                           sum += marksAccCourse.get(i).getMark();
                     
                   }
                  
                           scores.add(sum);                           
                   
               });
               double final_grade=0;
                   for (int i = 0; i < scores.size(); i++) {
                            final_grade+=scores.get(i);
                          }
                   std.getKey().setTotalAverage(final_grade/scores.size());
                  
         });
       
       
       
       

 newStudents.entrySet().forEach(std ->{
    	   
     	   HashMap<Courses, ArrayList<Marks>>  newCourses =  std.getValue(); 
    		   
     	  System.out.println("Student Id: " + std.getKey().getId() + " , " + "name: " + std.getKey().getName()); 
			System.out.print("Total Average:      ");
			System.out.printf("%.2f", std.getKey().getTotalAverage());
			System.out.println();
			System.out.println();
     		   newCourses.entrySet().forEach(crs -> {
     			   
     			   
     				
     				System.out.println("Course: " + crs.getKey().getName() + " , " + "Teacher: " + crs.getKey().getTeacher());
     				ArrayList<Marks> marksAccCourse = crs.getValue();
                    double sum = 0.0;
                   
                    for(int i = 0; i < marksAccCourse.size(); i++) {
                       
                            
                            sum += marksAccCourse.get(i).getMark();
                       
                    }
     				
     				System.out.print("Final Grade:       ");
     				System.out.printf("%.2f", sum);
     				System.out.println();
     				System.out.println();
     				
     		
     		   });
     		  System.out.println();
     		  System.out.println();
     	 });
       
       
     
	}
	

}







