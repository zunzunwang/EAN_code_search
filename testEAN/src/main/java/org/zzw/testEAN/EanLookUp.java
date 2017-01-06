package org.zzw.testEAN;

import java.util.List;
import java.util.concurrent.FutureTask;

import org.json.JSONArray;

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
	public JSONArray getResult(List<FutureTask<EanTask>> futureTasks);
	
}
