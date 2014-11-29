package domain;

import java.util.Date;

public class Service extends Entity{

	private boolean tiresChange;
	private boolean oilChange;
	private boolean wash;
	private boolean painting;
	private boolean mechanicReapair;
	private boolean electricReapair;
	private Date date;
	
	private Car car;
	
	/* */
	
	public boolean isTiresChange() {
		return tiresChange;
	}
	public void setTiresChange(boolean tiresChange) {
		this.tiresChange = tiresChange;
	}
	
	public boolean isOilChange() {
		return oilChange;
	}
	public void setOilChange(boolean oilChange) {
		this.oilChange = oilChange;
	}
	
	public boolean isWash() {
		return wash;
	}
	public void setWash(boolean wash) {
		this.wash = wash;
	}
	
	public boolean isPainting() {
		return painting;
	}
	public void setPainting(boolean painting) {
		this.painting = painting;
	}
	
	public boolean isMechanicReapair() {
		return mechanicReapair;
	}
	public void setMechanicReapair(boolean mechanicReapair) {
		this.mechanicReapair = mechanicReapair;
	}
	
	public boolean isElectricReapair() {
		return electricReapair;
	}
	public void setElectricReapair(boolean electricReapair) {
		this.electricReapair = electricReapair;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	/* */
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
}
	
