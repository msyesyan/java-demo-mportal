package com.bStar.mportal.interceptor;

import com.bStar.mportal.util.Dbutil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TransactionInterceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			// 打开事务
			Dbutil.getConnection().setAutoCommit(false);
			System.out.println("--开始事务--");
			// 调用Action和Result
			String resultCode = invocation.invoke();
			// 提交事务或回滚
			Dbutil.getConnection().commit();
			System.out.println("--提交事务--");
			return resultCode;
		} catch (Exception e) {
			Dbutil.getConnection().rollback();
			System.out.println("--回滚事务--");
			e.printStackTrace();
			return "fail";
		} finally {
			Dbutil.closeConnection();
		}

	}

}
