package org.zzw.testEAN;

import java.util.List;
import java.util.concurrent.FutureTask;

import org.json.JSONArray;

public interface EanLookUp {	
	/**
	 * This method read the file txt and start restful service.
	 * @param filePath: the path of the 
	 * @param threadNum: the num of thread we want to create.
	 * @param futureTasks: the thread pool we created.
	 * @param url: the url we use for our restful service.
	 */
	public void readFile(String filePath, int threadNum, List<FutureTask<EanTask>> futureTasks,String url);
	
	/**
	 * This method get the result from thread pool.
	 */
	public JSONArray getResult(List<FutureTask<EanTask>> futureTasks);
	
}
