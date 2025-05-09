/**
* 模仿天猫整站j2ee 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.xq.tmall.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xq.tmall.bean.Category;
import com.xq.tmall.bean.Property;
import com.xq.tmall.util.Page;

public class PropertyServlet extends BaseBackServlet {

	
	public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		Category c = categoryDAO.get(cid);
		
		String name= request.getParameter("name");
		Property p = new Property();
		p.setCategory(c);
		p.setName(name);
		propertyDAO.add(p);
		return "@admin_property_list?cid="+cid;
	}

	
	public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
		int id = Integer.parseInt(request.getParameter("id"));
		Property p = propertyDAO.get(id);
		propertyDAO.delete(id);
		return "@admin_property_list?cid="+p.getCategory().getId();
	}

	
	public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
		int id = Integer.parseInt(request.getParameter("id"));
		Property p = propertyDAO.get(id);
		request.setAttribute("p", p);
		return "admin/editProperty.jsp";		
	}

	
	public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		Category c = categoryDAO.get(cid);

		
		int id = Integer.parseInt(request.getParameter("id"));
		String name= request.getParameter("name");
		Property p = new Property();
		p.setCategory(c);
		p.setId(id);
		p.setName(name);
		propertyDAO.update(p);
		return "@admin_property_list?cid="+p.getCategory().getId();
	}

	
	public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		Category c = categoryDAO.get(cid);
		List<Property> ps = propertyDAO.list(cid, page.getStart(),page.getCount());
		int total = propertyDAO.getTotal(cid);
		page.setTotal(total);
		page.setParam("&cid="+c.getId());
		
		request.setAttribute("ps", ps);
		request.setAttribute("c", c);
		request.setAttribute("page", page);
		
		
		
		return "admin/listProperty.jsp";
	}
}

/**
* 模仿天猫整站j2ee 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
