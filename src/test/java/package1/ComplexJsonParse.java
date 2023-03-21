package package1;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	public static void main(String[] args) {
		
		
		JsonPath js=new JsonPath(payload.CoursePrice());
		//get courses size
		int count=js.getInt("courses.size()");
		System.out.println(count);
		
		//get purchase amount
		int totalAmount=js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		
		//title of the first course
		String titleFirstCourse=js.getString("courses[2].title");
		System.out.println(titleFirstCourse);
		
		
		//print all course titles and their respective prices
		
		for(int i=0;i<count;i++)
		{
			String coursetitles=js.get("courses["+i+"].title");
			int courseprice=js.getInt("courses["+i+"].price");
			System.out.println(courseprice);
			System.out.println(coursetitles);
		}
		
		//print no of copies sold by RPA course
		System.out.println("print no of copies sold by RPA course");
		for(int i=0;i<count;i++)
		{
			String coursetitles=js.get("courses["+i+"].title");
			if(coursetitles.equals("RPA")) 
			{
				int copiescount=js.get("courses["+i+"].copies");
				System.out.println(copiescount);
				break;
			}
		}
		
		
		
		
		
		
	}

}
