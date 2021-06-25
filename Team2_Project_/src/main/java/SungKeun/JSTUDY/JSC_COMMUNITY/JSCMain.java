package SungKeun.JSTUDY.JSC_COMMUNITY;

import SungKeun.JSTUDY.Model;

public class JSCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JSCDTO jcoo1 = new JSCDTO();
		// Controller만 호출.
		JSCController jscctrl = new JSCController();
		System.out.println("\n# 호출된 화면 #\n");
		System.out.println(jscctrl.JSCList2(jcoo1, new Model()));

	}

}
