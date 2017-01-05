package org.zzw.testEAN;

import java.util.List;
import java.util.concurrent.FutureTask;

public interface EanLookUp {	
	/**
	 * This method read the file txt.
	 * @param filePath
	 * @param threadNum
	 * @param futureTasks
	 * @param url
	 */
	public String readFile(String filePath, int threadNum, List<FutureTask<EanTask>> futureTasks,String url);
	
	/**
	 * This method get the result.
	 */
	public String getResult(List<FutureTask<EanTask>> futureTasks);
	
}
