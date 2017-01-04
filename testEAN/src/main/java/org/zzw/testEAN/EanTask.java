package org.zzw.testEAN;

import java.util.concurrent.Callable;

class EanTask implements Callable {
    private String taskName;
    private String taskEanCode;
     
    public EanTask(String productName) {
        this.taskName = productName;
    }
    
	public String findInfo(String name){
		return name;
		
	};

	public String call() throws Exception {
		// TODO Auto-generated method stub
        System.out.println("Start look up task: "+taskName+".");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish task: "+taskName+".");
        return "aaa";
	}
}
