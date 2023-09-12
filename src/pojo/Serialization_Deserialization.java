package pojo;

public class Serialization_Deserialization {

	
		// serialization : Java object to request payload
		// Desearilazation : request payload JSON to Java Object
		//libraries : jackson databind , jackson annotations , jackson core , Gson
		// if u have nested json and array type  we need to create saperate class
		// If array of multile JSON's 
		
		private String  instructor ;
		private String url ;
		private String services;
		private String expertise;
		private courses courses; // in courses class we need to mention in List as it is comming as a array
		private String linkedIn;
		public String getInstructor() {
			return instructor;
		}
		public void setInstructor(String instructor) {
			this.instructor = instructor;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getServices() {
			return services;
		}
		public void setServices(String services) {
			this.services = services;
		}
		public String getExpertise() {
			return expertise;
		}
		public void setExpertise(String expertise) {
			this.expertise = expertise;
		}
		public pojo.courses getCourses() {
			return courses;
		}
		
		public void setCourses(pojo.courses courses) { 
			this.courses = courses;
		}
		public String getLinkedIn() {
			return linkedIn;
		}
		public void setLinkedIn(String linkedIn) {
			this.linkedIn = linkedIn;
		}
		
		
		

	

}
