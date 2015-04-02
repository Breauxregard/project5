/*
 * Brandon Izor
 * CS350
 * Project3
 * A record class containing the information of a test driver
 * 
 */
public class CDriver {
	private int customerNumber;
	private String customerName;
	private int drivingYears;
	private boolean isJeepOwner;
	private boolean[] models;
	private int transmission;
	
	CDriver() {}
	
	CDriver(int cusNum, String cusName, int years, boolean isOwner, boolean[] mods, int trans) {
		customerNumber = cusNum;
		customerName = cusName;
		drivingYears = years;
		isJeepOwner = isOwner;
		models = mods;
		transmission = trans;
		
	}
	/**
	 * @return a raw string that can be saved to a file and read with the open method
	 */
	public String GenerateSaveOutput() {
		String s = new String(); // raw output for saving purposes
		s += this.getCustomerNumber() + ":";
		s += this.getCustomerName() + ":";
		s += this.getDrivingYears() + ":";
		
		if (this.isJeepOwner() == true) {
			s += "1:";
		} else {
			s += "0:";
		}
		for (boolean model : models) {
			if (model == true) {
				s += "1";
			} else {
				s += "0";
			} 
		}
		s += ":";
		s += this.getTransmission();
		
		return s; 
		
	}
	
	public String stringify() {
		String s = "";
		s += (String.format("%05d",customerNumber));
		s += ("\t                    ");
		s += customerName;
		s += "\t\t                    ";
		s += (drivingYears);
		s+="\t                 ";
		if (isJeepOwner == true) {s+= "Yes \t               ";}
		if (isJeepOwner == false) {s+= "No \t                ";}
		
		System.out.print("CDriver at bool 0 "+models[0]);
		if (models[0] == true) {s+="C";}
		else {s+="-";}
		if (models[1] == true) {s+="G";}
		else {s+="-";}
		if (models[2] == true) {s+="P";}
		else {s+="-";}
		if (models[3] == true) {s+="R";}
		else {s+="-";}
		if (models[4] == true) {s+="O";}
		else {s+="-";}
		
		s+= "\t                    ";
		if (transmission == 0) {s += "5-Speed";}
		if (transmission == 1) {s += "6-Speed";}
		if (transmission == 2) {s += "8-Speed";}
		if (transmission == 3) {s += "Don\'t Care";}

		return s;
		
	}

	/**
	 * @return the customerNumber
	 */
	public int getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the drivingYears
	 */
	public int getDrivingYears() {
		return drivingYears;
	}

	/**
	 * @param drivingYears the drivingYears to set
	 */
	public void setDrivingYears(int drivingYears) {
		this.drivingYears = drivingYears;
	}

	/**
	 * @return the isJeepOwner
	 */
	public boolean isJeepOwner() {
		return isJeepOwner;
	}

	/**
	 * @param isJeepOwner the isJeepOwner to set
	 */
	public void setJeepOwner(boolean isJeepOwner) {
		this.isJeepOwner = isJeepOwner;
	}

	/**
	 * @return the models
	 */
	public boolean[] getModels() {
		return models;
	}

	/**
	 * @param models the models to set
	 */
	public void setModels(boolean[] models) {
		this.models = models;
	}

	/**
	 * @return the transmission
	 */
	public int getTransmission() {
		return transmission;
	}

	/**
	 * @param transmission the transmission to set
	 */
	public void setTransmission(int transmission) {
		this.transmission = transmission;
	}
	
}
