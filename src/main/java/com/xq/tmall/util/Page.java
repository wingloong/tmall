/**
* 模仿天猫整站j2ee 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.xq.tmall.util;

public class Page {
	int start;
	int count;
	int total;
	String param;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Page(int start, int count) {
		super();
		this.start = start;
		this.count = count;
	}
	
	public boolean isHasPreviouse(){
		if(start==0)
			return false;
		return true;
		
	}
	public boolean isHasNext(){
		if(start==getLast())
			return false;
		return true;
	}
	
	public int getTotalPage(){
		int totalPage;
        // 假设总数是50，是能够被5整除的，那么就有10页
        if (0 == total % count)
            totalPage = total /count;
        // 假设总数是51，不能够被5整除的，那么就有11页
        else
            totalPage = total / count + 1;
        
        if(0==totalPage)
        	totalPage = 1;
        return totalPage;
		
	}
	
	public int getLast(){
		int last;
        // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
        if (0 == total % count)
            last = total - count;
        // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
        else
            last = total - total % count;
        
        last = last<0?0:last;
        return last;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	
}

/**
* 模仿天猫整站j2ee 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
