package web;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.Commande;
import model.Detail;
import model.DetailId;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import service.CommandeInt;
import service.CommandeServ;


@ManagedBean(name="CommandeBean")
@Component
@Scope
public class CommandeBean {
	private CommandeInt commandeInt;
	public CommandeInt getCommandeInt() {
		return commandeInt;
	}

	public void setCommandeInt(CommandeInt commandeInt) {
		this.commandeInt = commandeInt;
	}

	private Commande commande;
	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	@PostConstruct
	public void init() {
	    commande = new Commande();
	}

	public void addCommande(ActionEvent actionEvent){
		commandeInt = new CommandeServ();
		commandeInt.add_commande(commande);
		
		  DetailId aid = new DetailId(1,commande.getIdcommande(),new Date());
			
	      Detail etdmat=new Detail(aid);
			commandeInt.Add_Detail(etdmat);
	
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Commande ajoutée"));
		commande = new Commande();
	}
}
