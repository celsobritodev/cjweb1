package br.com.hightechcursos.controller;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet Filter implementation class FiltroAutentica
 */
public class FiltroAutentica extends HttpFilter implements Filter {
       
   
    public FiltroAutentica() {
        super();
      }


	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
	   HttpServletRequest httpServletRequest = (HttpServletRequest) request;

	   String url = httpServletRequest.getRequestURI();
	   
	   Boolean notTelaLogin = url.lastIndexOf("login.html")<0;
	   
	   Boolean notAutController = url.lastIndexOf("autcontroller.do")<0;
	   
	   // capturando sessao
	   HttpSession sessao =  httpServletRequest .getSession();

	   
	   // esta logado?	
	   if (sessao.getAttribute("usuLogado")!=null || notTelaLogin || notAutController ) {
		chain.doFilter(request, response);
	   } else {
		((HttpServletResponse) response). sendRedirect("login.html");   
		   
	   }
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
