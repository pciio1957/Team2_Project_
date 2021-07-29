package PICMAGIN_ART_SEARCH;


public class Controller_Art {
	
	private Service_Art ser = new Service_Art();

	//1. 댓글 전체조회 
	public String commentlist1(String sh, Model d) {
		d.addAttribute("기존댓글조회", ser.commentlist(sh));
	return "jsp경로";
	}
	//2. 댓글 작성 및 저장
	public String Comment(Comment com, Model d) {
		d.addAttribute("신규댓글저장", ser.Comment(com));
		return"jsp경로";
	}

	//3. 검색어 입력 및 호출
		public String searchlist(Art search, Model d) {
				d.addAttribute("작품검색", ser.Artlist(search));{
				// TODO Auto-generated method stub
				return "";
			}
		}
	  //4. 좋아요 클릭 
	    public String likeup (Like likecheck2, Model d) {
		d.addAttribute("작품검색", ser.likeup(likecheck2));
		return "jsp경로";
	    }
		//5. 좋아요 취소 
	
		public String likedown(Like likecheck2, Model d) {
			d.addAttribute("작품검색", ser.likedown(likecheck2));
			return "jsp경로";
	
		}
		//6. 좋아요 조회 
		public String likelist(String artwork, Model d) {
			d.addAttribute("좋아요조회",ser.likelist(artwork));
			return "jsp경로";
		}
	

}
