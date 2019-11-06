package com.cms.commons.genericEJB;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;


public class DistributionContextInterceptor 
{
	
	
	@AroundInvoke
	public Object configData(InvocationContext ctx) throws Exception
	{
		return ctx.proceed();
	}
	
	
	
	
	

}
