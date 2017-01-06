package org.zzw.testEAN;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;
import org.json.JSONObject;


public class MainEanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		EanLookUpImpl test = new EanLookUpImpl();
		//String filePath = "./resource/grocery.txt";
		String filePath = "./resource/grocery_test.txt";
		//create task list.
		List<FutureTask<EanTask>> futureTasks = new ArrayList<FutureTask<EanTask>>();
		//we create 3 threads.
		String url ="https://world.openfoodfacts.org/cgi/search.pl?search_terms=productName&search_simple=1&action=process&xml=1";
		test.readFile(filePath,3,futureTasks,url);
		JSONObject jsonResult = new JSONObject();
		jsonResult.put("rows", test.getResult(futureTasks));
		System.out.println(jsonResult.toString());
	}

}
