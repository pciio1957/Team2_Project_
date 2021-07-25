package JiEun.Picmagine;

public class AUT01_main {
	static AUT01_controller controller = new AUT01_controller();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// 총 기능 : 작가 정보 출력, 팔로우, 작가의 작품리스트 출력(조회), 시리즈 출력(조회) 
		
		// 작가 정보 출력 - 홈이나 상세페이지에서 작가를 클릭하면 나오는 작가홈 
		// 그러니까 작가번호를 받아와서 해당 작가의 정보를 출력 
		// 작가명(영문이름) 팔로워 팔로잉 / 활동분야 작가소개 
		controller.WriterInfo("w001", new AUT01_Model());

		
		// 작가의 팔로우 정보 확인 - 작가의 팔로우 정보 출력
		// 클릭한 작가의 작가번호와 로그인한 회원의 번호를 가지고 있다고 가정한 후
		// 1) 팔로우가 되어있는지 확인  2) 작가의 팔로우한 사람의 수를 출력
		controller.followCheck("m002", "w001",new AUT01_Model());

		// 팔로우 수 확인했으니까 이제 누른거 처리해야함 
		// isFollow로 확인 -> true는 되어있는거, false 안되어있는거 -> 삭제, 추가

		// 작가의 작품리스트 출력
		// 클릭했을 때 작가번호를 가지고 와서 작품 리스트 출력
		controller.WorkList("w002", new AUT01_Model());
		
		// 작가 시리즈 출력
		// 클릭했을 때 작가번호르 가지고 와서 작품의 시리즈 출력 
		//controller.SeriesList();
	}

}
