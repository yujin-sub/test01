package kr.kosta.bus.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kosta.bus.model.RouteDAO;
import kr.kosta.bus.model.RouteDTO;

@Service
public class RouteServiceImpl implements RouteService {
	
	@Autowired
	private RouteService service;
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<RouteDTO> routeList(HashMap map) {
		RouteDAO dao = sqlSession.getMapper(RouteDAO.class);
		return dao.routeList(map);
	}


	@Override
	public void routeInsert(RouteDTO dto) {
		RouteDAO dao = sqlSession.getMapper(RouteDAO.class);
		dao.routeInsert(dto);
	}

	@Override
	public void routeUpdate(RouteDTO dto) {
		RouteDAO dao = sqlSession.getMapper(RouteDAO.class);
		dao.routeUpdate(dto);
	}

	@Override
	public void routeDelete(String r_no) {
		RouteDAO dao = sqlSession.getMapper(RouteDAO.class);
		dao.routeDelete(r_no);
	}


	@Override
	public int getRouteCount() {
		RouteDAO dao = sqlSession.getMapper(RouteDAO.class);
		return dao.getRouteCount();
	}

	
}
