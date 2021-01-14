package logic.bean;

public class RegistrationBean {

		private String firstname;
		private String lastname;
		private String email;
		private String username;
		private String password;
		private String orgUsername;
		private String orgFirstname;
		private String orgLastname;
		private String orgPassword;
		private String orgEmail;
		private String orgOwnRoom;
		
			
		public RegistrationBean() {
			this.firstname = "";
			this.lastname = "";
			this.email = "";
			this.username = "";
			this.password = "";
			this.orgUsername = "";
			this.orgFirstname = "";
			this.orgLastname = "";
			this.orgPassword = "";
			this.orgEmail = "";
			this.orgOwnRoom = "";
		}
		
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getOrgUsername() {
			return orgUsername;
		}
		public void setOrgUsername(String orgUsername) {
			this.orgUsername = orgUsername;
		}
		public String getOrgFirstname() {
			return orgFirstname;
		}
		public void setOrgFirstname(String orgFirstname) {
			this.orgFirstname = orgFirstname;
		}
		public String getOrgLastname() {
			return orgLastname;
		}
		public void setOrgLastname(String orgLastname) {
			this.orgLastname = orgLastname;
		}
		public String getOrgPassword() {
			return orgPassword;
		}
		public void setOrgPassword(String orgPassword) {
			this.orgPassword = orgPassword;
		}
		public String getOrgEmail() {
			return orgEmail;
		}
		public void setOrgEmail(String orgEmail) {
			this.orgEmail = orgEmail;
		}
		public String getOrgOwnRoom() {
			return orgOwnRoom;
		}
		public void setOrgOwnRoom(String orgOwnRoom) {
			this.orgOwnRoom = orgOwnRoom;
		}
		

}