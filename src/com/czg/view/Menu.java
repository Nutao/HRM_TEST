/**
 * 
 */
package com.czg.view;

import com.czg.hrm.PersonOperate;

/**
 * @author nutao
 * @category 设计程序的前台界面的菜单
 */
public class Menu {

	public Menu() {
		while(true){
			this.show();
		}
	}

//	显示菜单
	public void show() {
		System.out.println("===========HRM===========");
		System.out.println("1,增加信息");
		System.out.println("2,修改信息");
		System.out.println("3,删除信息");
		System.out.println("4,查看所有员工信息");
		System.out.println("5,按关键字检索信息");
		System.out.println("[0],退出系统\n\n");
		
		int ch = new InputData().getInt("请选择：", "选项必须是数字");
		switch (ch) {
		case 0:
			System.out.println("系统退出!!!!");System.out.println("==============================");
			System.exit(1);
			break;
		case 1:
			PersonOperate.insert();
			break;
		case 2:
			PersonOperate.update();
			break;
		case 3:
			PersonOperate.delete();
			break;
		case 4:
			PersonOperate.findall();
			break;
		case 5:
			PersonOperate.search();
			break;
		default:
			System.out.println("\n\n请输入正确的选项");
			break;
		}
	}
	
}
