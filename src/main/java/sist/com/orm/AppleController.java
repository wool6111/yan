package sist.com.orm;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sist.com.dao.BasicDao;
import sist.com.dto.RentCarBean;

@Controller
@SessionAttributes(value= {"carList","date1","date2","people","car","place"})
public class AppleController {
	@Autowired
	private BasicDao dao;
	/*@Resource
	private RentCarBean rentCarBean;*/
	
	@RequestMapping(value="carseach.do")
	public String carSeach(HashMap<String, String>map,HttpServletRequest request,Model model,HttpSession session) {
		map.put("car", request.getParameter("car"));
		map.put("place", request.getParameter("place"));
		model.addAttribute("carList", dao.selectRentCar(map));
		model.addAttribute("date1",request.getParameter("date1"));
		model.addAttribute("date2",request.getParameter("date2"));
		model.addAttribute("car",request.getParameter("car"));
		model.addAttribute("place",request.getParameter("place"));
		model.addAttribute("people",request.getParameter("people"));
		return "SIST/sub/reserve2";
	}
	@RequestMapping(value="statemod.do")
	public String carState(int no,Model model,HttpServletRequest request,HttpSession session) {
		model.addAttribute("no", request.getParameter("no"));
		dao.updateState(no);
		//model.addAttribute("car", request.getParameter("car"));
		//dao.insertrentlist
		return "redirect:carseach.do";
	}
	
	

}








