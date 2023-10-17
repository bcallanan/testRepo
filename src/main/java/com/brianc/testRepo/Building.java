/**
 * 
 */
package com.brianc.testRepo;

/**
 * @author home
 *
 */
public class Building {

	/**
	 * 
	 */
	public Building() {
		// TODO Auto-generated constructor stub
	}

	int numberOfRoms = 7;

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberOfRoms;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Building other = (Building) obj;
		if (numberOfRoms != other.numberOfRoms)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Building [numberOfRoms=" + numberOfRoms + "]";
	}

	/**
	 * @return the numberOfRoms
	 */
	public int getNumberOfRoms() {
		return numberOfRoms;
	}

	/**
	 * @param numberOfRoms the numberOfRoms to set
	 */
	public void setNumberOfRoms(int numberOfRoms) {
		this.numberOfRoms = numberOfRoms;
	}
}
