package com.woyo.intercepter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * @author Administrator
 *
 */
public class PersonLoginIntercepter extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {
        /*Map<String,Object> session = ActionContext.getContext().getSession(); //���session
        HttpServletRequest request = ServletActionContext.getRequest();//�õ�httpServletRequest����
        Person loginPerson = (Person)session.get("loginPerson");//���session�еĵ�¼�û���Ϣ
        if(loginPerson == null){//��¼�û���û����Ϣ��˵��û�е�¼
        ActionContext.getContext().put("message", "��û����ȷ��¼��ϵͳ���ڲ���֮ǰ������ȷ��¼��ϵͳ��");
        return "goLogin";//��ת���û���¼�Ľ���
        }
        */
        return invocation.invoke();
    }

}
