package JiEun.Picmagine;

public class AUT01_main {
	static AUT01_controller controller = new AUT01_controller();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// 총 기능 : 작가 정보 출력, 팔로우, 작가의 작품리스트 출력(조회), 시리즈 출력(조회) 
		
		// 1. 작가 정보 출력 - 홈이나 상세페이지에서 작가를 클릭하면 나오는 작가홈 
		// 그러니까 작가번호를 받아와서 해당 작가의 정보를 출력 
		// 작가명(영문이름) 팔로워 팔로잉 / 활동분야 작가소개 
		controller.WriterInfo("at3001", new AUT01_Model());

		// 2. 작가 팔로우 정보 확인 
		// 클릭한 작가의 작가번호를 이용해 작가의 팔로우 정보 확인
		// 1) 팔로워: 팔로우가 되어있는지 확인  2) 팔로잉: 작가의 팔로우한 사람의 수를 출력
		controller.followCheck("at3001", new AUT01_Model());
		
		// 3. 회원의 작가 팔로우 여부 확인
		// 회원/비회원 체크(??) 후 회원일 경우 로그인한 회원번호를 가지고 팔로우했는지 체크(boolean)
		// 회원일 경우 클릭한 사람의 회원번호를 확인 후 회원번호, 작가번호를 이용해 팔로우/팔로잉해야함
		controller.followerCheck("mb1002", "at3001", new AUT01_Model());
		
		// 팔로우 수 확인했으니까 이제 누른거 처리해야함 -> 자바스크립트로 처리 -> 바로 Dao로 연결
		// isFollow로 확인 -> true는 되어있는거, false 안되어있는거 -> 삭제, 추가
		// !!?? 팔로우/팔로잉 확인했으니까 이제 처리해야하는데 어떻게 해야할지~!!?!?!?
		
		// 작가의 작품리스트 출력
		// 클릭했을 때 작가번호를 가지고 와서 작품 리스트 출력
		controller.WorkList("at3001", new AUT01_Model());
		
		// 작가 시리즈 출력
		// 클릭했을 때 작가번호르 가지고 와서 작품의 시리즈 출력 
		//controller.SeriesList();
	}

}
