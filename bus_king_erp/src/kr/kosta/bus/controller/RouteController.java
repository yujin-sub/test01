package kr.kosta.bus.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kosta.bus.model.RouteDTO;
import kr.kosta.bus.service.RouteService;

@Controller
@RequestMapping("/rc/*")
public class RouteController {
	
	@Autowired
	RouteService service;
	
	
	@RequestMapping("home.do")
	public String home(HttpServletRequest request, Model model) {
		int pg = 1;
		String strPg = request.getParameter("pg");
		
		if(strPg != null) {
			pg = Integer.parseInt(strPg);
		}
		
		int rowSize = 10;
		int start = (pg*rowSize) - (rowSize-1);
		int end = pg*rowSize;
		
		int total = service.getRouteCount();
		System.out.println("start : " + start + " end : " + end);
		System.out.println("wtire count : " + total);
		
		int allPage = (int)Math.ceil(total/(double)rowSize);
//		int totalPage = total / rowSize + (total % rowSiez == 0 ? 0 : 1);
		System.out.println("page count : " + allPage);
		
		int block = 10;
		int fromPage = ((pg-1) / block*block) + 1;
		int toPage = ((pg-1) / block*block) + block;
		
		if(toPage > allPage) {
			toPage = allPage;
		}
		
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<RouteDTO> dto = service.routeList(map);
		model.addAttribute("routelist", dto);
		model.addAttribute("pg", pg);
		model.addAttribute("allPage", allPage);
		model.addAttribute("block", block);
		model.addAttribute("fromPage", fromPage);
		model.addAttribute("toPage", toPage);
		
		return "/bc/home";
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insertform() {
		return "insert";
	}
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public  String insert(HttpServletRequest request, RouteDTO dto) {
		  dto.setR_no(request.getParameter("r_no"));
		  dto.setR_start(request.getParameter("r_start"));
		  dto.setR_end(request.getParameter("r_end"));
		  dto.setR_s_time(request.getParameter("r_s_time"));
		  dto.setR_e_time(request.getParameter("r_e_time"));
		  dto.setR_interval(Integer.parseInt(request.getParameter("r_interval")));	  
		
		  dto.setR_map(request.getParameter("r_map"));
		  dto.setR_pay_adult(Integer.parseInt(request.getParameter("r_pay_adult")));
		  dto.setR_pay_adult2(Integer.parseInt(request.getParameter("r_pay_adult2")));
		  dto.setR_pay_teen(Integer.parseInt(request.getParameter("r_pay_teen")));
		  dto.setR_pay_teen2(Integer.parseInt(request.getParameter("r_pay_teen2")));
		  dto.setR_pay_kid(Integer.parseInt(request.getParameter("r_pay_kid")));
		  dto.setR_pay_kid2(Integer.parseInt(request.getParameter("r_pay_kid2")));
		service.routeInsert(dto);
		return "redirect:home.do";
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.GET)
	public String routeupdateform(RouteDTO dto,Model model) {
		model.addAttribute("dto",dto);
		return "updateform";
	}

	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String routeupdate(RouteDTO dto,Model model) {
		service.routeUpdate(dto);
		return "redirect:home.do";
	}
	
    @RequestMapping("/delete.do")
    public String delete(String r_no) {
      service.routeDelete(r_no);
      return "redirect:home.do";
    }
	 
	
}
