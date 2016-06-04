package Chihane1002;
//這是"做蛋糕"的計時器~~
class TimerThread extends Thread { // 新的執行緒
	public void run() { // 新執行緒要執行的內容
//		while(true) { //倒數計時
			for(int i = 59; i>=0;i--){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Cooking.setLabel(i);
				Cooking.point = 1;
				}
			Cooking.point =0;
//		}//end of while
	}//end of run





}
