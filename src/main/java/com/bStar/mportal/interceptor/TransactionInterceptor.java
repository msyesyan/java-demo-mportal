package com.bStar.mportal.interceptor;

import com.bStar.mportal.util.Dbutil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TransactionInterceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			// ������
			Dbutil.getConnection().setAutoCommit(false);
			System.out.println("--��ʼ����--");
			// ����Action��Result
			String resultCode = invocation.invoke();
			// �ύ�����ع�
			Dbutil.getConnection().commit();
			System.out.println("--�ύ����--");
			return resultCode;
		} catch (Exception e) {
			Dbutil.getConnection().rollback();
			System.out.println("--�ع�����--");
			e.printStackTrace();
			return "fail";
		} finally {
			Dbutil.closeConnection();
		}

	}

}
