package JSTUDY.MEMBER;

public class JSM01Model {
	String modelKey = "";
	String modelValue = "";

	public JSM01Model() {
		super();
	}

	public void addAttribute(String key, Object value) {
		System.out.println("\n [Model] 데이터 입력 ");
		System.out.println("  key : " + key);
		System.out.println("  value : " + value + " \n");
		System.out.println("---------------------------------------------------\n");
		
		modelKey = key;
		modelValue = value.toString();
	}
}



