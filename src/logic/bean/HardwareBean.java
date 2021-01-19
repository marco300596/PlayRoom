package logic.bean;

public class HardwareBean {

		private String hardwareName;
		private int quantity;
		private int availability;
		private String description;


		
		public HardwareBean() {
			this.hardwareName = "";
		}

		public String getHardwareName() {
			return hardwareName;
		}
		
		public int getQuantity() {
			return quantity;
		}
		
		public int getAvailability() {
			return availability;
		}
		
		public String getDescription() {
			return description;
		}
		
		public void setHardwareName(String hardwareName) {
			this.hardwareName = hardwareName;
		}
		
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		public void setAvailability(int availability) {
			this.availability = availability;
		}
		
		public void setDescription(String description) {
			this.description = description;
		}

		
}
