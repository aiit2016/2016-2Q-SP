package report31;

import java.io.Serializable;

public class Object4Jcf implements Serializable {

	private static final long serialVersionUID = -4894642796931832189L;

	private int itemOne;

	private double itemTwo;

	private String itemThree;

	public int getItemOne() {
		return itemOne;
	}

	public void setItemOne(int itemOne) {
		this.itemOne = itemOne;
	}

	public double getItemTwo() {
		return itemTwo;
	}

	public void setItemTwo(double itemTwo) {
		this.itemTwo = itemTwo;
	}

	public String getItemThree() {
		return itemThree;
	}

	public void setItemThree(String itemThree) {
		this.itemThree = itemThree;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemThree == null) ? 0 : itemThree.hashCode());
		result = prime * result + itemOne;
		long temp;
		temp = Double.doubleToLongBits(itemTwo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Object4Jcf other = (Object4Jcf) obj;
		if (itemThree == null) {
			if (other.itemThree != null)
				return false;
		} else if (!itemThree.equals(other.itemThree))
			return false;
		if (itemOne != other.itemOne)
			return false;
		if (Double.doubleToLongBits(itemTwo) != Double
				.doubleToLongBits(other.itemTwo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Object4Jcf [itemOne=" + itemOne + ", itemTwo=" + itemTwo
				+ ", itemThree=" + itemThree + ", hashCode()=" + hashCode()
				+ "]";
	}

}
