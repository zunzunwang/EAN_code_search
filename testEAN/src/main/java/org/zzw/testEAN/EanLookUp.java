package org.zzw.testEAN;

public interface EanLookUp {	
	/**
	 * This method read the file txt.
	 * @param filePath
	 * @threadNum
	 */
	public String readFile(String filePath, int threadNum);
	
}
