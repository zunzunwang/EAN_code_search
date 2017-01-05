package org.zzw.testEAN;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;


public class EanLookUpImpl implements EanLookUp {

	public String readFile(String filePath, int threadNum, List<FutureTask<EanTask>> futureTasks,String url) {
	
		//create thread pool.
		ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
		
		//read txt file.
        try {
        	String encoding="GBK";
            File fileTemp = new File(filePath);
            //verify the file is existed.
            if(fileTemp.isFile() && fileTemp.exists()){
            	//consider the code format. 
                InputStreamReader read = new InputStreamReader(new FileInputStream(fileTemp),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	//System.out.println(lineTxt);
                	EanTask tempTask = new EanTask(lineTxt,url);
                	//create a task.
                	FutureTask<EanTask> futureTask = new FutureTask<EanTask>(tempTask);
                	//add task to thread pool.
                	futureTasks.add(futureTask);
                	executorService.submit(futureTask);
                }
                executorService.shutdown();
                read.close();
                }else{
                	System.out.println("We can't find the file.");
                }
            }catch (Exception e) {
            	System.out.println("Reading errors");
            	e.printStackTrace();
            }
		return null;
	}

	public String getResult(List<FutureTask<EanTask>> futureTasks) {
		// TODO Auto-generated method stub
		String result = "";
	    for (FutureTask<EanTask> futureTask : futureTasks){
		     try {				
                while (true) {
                    if (futureTask.isDone() && !futureTask.isCancelled()) {
                        //System.out.println("Future:" + future + ",Result:" + future.get());
        				result+= futureTask.get();
                        break;
                    } else {
                        Thread.sleep(1000);
                    }
                }
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
}
