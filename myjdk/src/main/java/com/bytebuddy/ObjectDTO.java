package com.bytebuddy;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 对象定义数据模型
 * @author Administrator
 *
 */
public class ObjectDTO implements Serializable{

	private static final long serialVersionUID = 4462897360109996509L;
	
	//是物理表
	public static final int IS_TABLE_YES = 1;
	//不是物理表
	public static final int IS_TABLE_NO = 2;
	
   //对象id
   private long obj_id;
	
	//对象简称
	private String obj_code;
	
	//对象名
	private String obj_name;
	
	
	//是否为物理表，1：物理表，2：视图
	private int is_table;
	
	// 对象对应数据源
	private String obj_source;
	
	//所属模块
	private long sys_id;
	
	//分组ID
	private long group_id;
	
	
	//版本号O
	private long last_ver;
	
	//创建用户
	private long create_user;
	
	//创建日期
	private  Timestamp create_date;
	
	//对象类型
	private int obj_type;
	
	//要素对应的JAVA数据对象
	private String class_name;
	
	//基础要素扩展属性
	
	//最大级次
	private int max_level;
	
	//编码规则
	private String code_rule;
	
	//系统扩展类型
	private int ele_extend_type;
	
	//帐套扩展类型
	private int account_extend_type;

	public long getObj_id() {
		return obj_id;
	}
	public void setObj_id(long objId) {
		obj_id = objId;
	}
	public String getObj_code() {
		return obj_code;
	}
	public void setObj_code(String objCode) {
		obj_code = objCode;
	}
	public String getObj_name() {
		return obj_name;
	}
	public void setObj_name(String objName) {
		obj_name = objName;
	}
	
	public String getObj_source() {
		return "222";
	}
	public void setObj_source(String objSource) {
		obj_source = objSource+"rdl";
	}
	
	public long getSys_id() {
		return sys_id;
	}
	
	public void setSys_id(long sys_id) {
		this.sys_id = sys_id;
	}
	
	public long getGroup_id() {
		return group_id;
	}
	
	public void setGroup_id(long group_id) {
		this.group_id = group_id;
	}
	
	public long getLast_ver() {
		return last_ver;
	}
	
	public void setLast_ver(long lastVer) {
		last_ver = lastVer;
	}
	
	public long getCreate_user() {
		return create_user;
	}
	
	public void setCreate_user(long createUser) {
		create_user = createUser;
	}
	
	public Timestamp getCreate_date() {
		return create_date;
	}
	
	public void setCreate_date(Timestamp createDate) {
		create_date = createDate;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public int getIs_table() {
		return is_table;
	}
	public void setIs_table(int is_table) {
		this.is_table = is_table;
	}
	
	public int getObj_type() {
		return obj_type;
	}
	public void setObj_type(int obj_type) {
		this.obj_type = obj_type;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public int getMax_level() {
		return max_level;
	}

	public void setMax_level(int max_level) {
		this.max_level = max_level;
	}

	public String getCode_rule() {
		return code_rule;
	}

	public void setCode_rule(String code_rule) {
		this.code_rule = code_rule;
	}

	public int getEle_extend_type() {
		return ele_extend_type;
	}

	public void setEle_extend_type(int ele_extend_type) {
		this.ele_extend_type = ele_extend_type;
	}

	public int getAccount_extend_type() {
		return account_extend_type;
	}

	public void setAccount_extend_type(int account_extend_type) {
		this.account_extend_type = account_extend_type;
	}
	
}
