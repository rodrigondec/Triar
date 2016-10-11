package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class HelloMB {
	public String getHello(){
		return "HHellppp1";
	}
}
