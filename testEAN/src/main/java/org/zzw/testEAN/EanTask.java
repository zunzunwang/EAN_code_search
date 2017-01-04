package org.zzw.testEAN;

class EanTask implements Runnable {
    private String taskName;
    private String taskEanCode;
     
    public EanTask(String productName) {
        this.taskName = productName;
    }
    
	public String findInfo(String name){
		return name;
		
	};
     
    public void run() {
        System.out.println("Start look up task: "+taskName+".");
        try {
            Thread.currentThread().sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish task: "+taskName+".");
    }
}
