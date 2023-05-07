package com.lc.myAspect;


import lombok.Data;

/**
 * 系统日志 BO
 * <p>
 * BO（Business Object）业务对象
 */
@Data
public class SysLogBO {

    /**
     * 类名
     */
    private String className;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 请求参数
     */
    private Object params;

    /**
     * 执行时间 单位 毫秒
     */
    private Long exeuTime;

    /**
     * 描述
     */
    private String remark;

    /**
     * 请求时间
     */
    private String createDate;

//	public String getClassName() {
//		return className;
//	}
//
//	public void setClassName(String className) {
//		this.className = className;
//	}
//
//	public String getMethodName() {
//		return methodName;
//	}
//
//	public void setMethodName(String methodName) {
//		this.methodName = methodName;
//	}
//
//	public Object getParams() {
//		return params;
//	}
//
//	public void setParams(Object params) {
//		this.params = params;
//	}
//
//	public Long getExeuTime() {
//		return exeuTime;
//	}
//
//	public void setExeuTime(Long exeuTime) {
//		this.exeuTime = exeuTime;
//	}
//
//	public String getRemark() {
//		return remark;
//	}
//
//	public void setRemark(String remark) {
//		this.remark = remark;
//	}
//
//	public String getCreateDate() {
//		return createDate;
//	}
//
//	public void setCreateDate(String createDate) {
//		this.createDate = createDate;
//	}

}
