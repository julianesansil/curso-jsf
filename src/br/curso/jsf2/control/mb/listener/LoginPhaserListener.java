package br.curso.jsf2.control.mb.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.curso.jsf2.control.mb.LoginMB;
import antlr.debug.Event;

public class LoginPhaserListener implements PhaseListener {

	@Override
	public PhaseId getPhaseId() {
		//Interceptar requisi��es da view
		return PhaseId.RESTORE_VIEW;
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//M�todo em que ocorrer� a valida��o do usu�rio logado
	public void afterPhase(PhaseEvent event) {
		//Vari�vel com acesso � arvore de componentes
		FacesContext context = event.getFacesContext();
		
		//Verifica��o de acesso � p�gina login da aplica��o
		if (context.getViewRoot().getViewId().equals("/login.xhtml"))
			return;
		
		LoginMB loginMB = context.getApplication().evaluateExpressionGet(context, "#{loginMB}", LoginMB.class);
	
		if (!loginMB.isUsuarioLogado()) {
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "login");
			context.renderResponse();
		}
		
	}
	
}
