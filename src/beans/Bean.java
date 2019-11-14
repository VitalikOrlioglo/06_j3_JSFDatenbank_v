package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import dao.DesignpatternDAO;
import model.Designpattern;

@ManagedBean
public class Bean {
	private List<Designpattern> list = new ArrayList<Designpattern>();
	private DesignpatternDAO dao = new DesignpatternDAO();
	
	@PostConstruct
	public void init() {
		setList(dao.findAll());
	}

	public List<Designpattern> getList() {
		return list;
	}

	public void setList(List<Designpattern> list) {
		this.list = list;
	}
}
