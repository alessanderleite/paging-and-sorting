package br.com.alessanderleite.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.alessanderleite.app.dao.ClientRepository;
import br.com.alessanderleite.app.model.ClientModel;
import br.com.alessanderleite.app.model.PagerModel;

@Controller
public class ClientController {
	
	private static final int BUTTONS_TO_SHOW = 3;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = {5,10};
	
	@Autowired
	ClientRepository clientRepository;
	
	@GetMapping("/")
	public ModelAndView homepage(
			@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		
		if (clientRepository.count() !=0) {
			;
		} else {
			addToRepository();
		}
		
		ModelAndView modelAndView = new ModelAndView("index");
		
		int evaluatePageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		
		int evaluatePage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		
		System.out.println("here is client repo " + clientRepository.findAll());
		
		Page<ClientModel> clientList = clientRepository.findAll(PageRequest.of(evaluatePage, evaluatePageSize));
		System.out.println("client list get total pages" + clientList.getTotalPages() + "client list get number " + clientList.getNumber());
		
		PagerModel pager = new PagerModel(clientList.getTotalPages(),clientList.getNumber(),BUTTONS_TO_SHOW);

		modelAndView.addObject("clientlist",clientList);
		modelAndView.addObject("selectedPageSize", evaluatePageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);

		return modelAndView;
	}
	
	public void addToRepository() {
		
		ClientModel widget = new ClientModel();
		widget.setAddress("123 Fake Street");
		widget.setCurrentInvoice(10000);
		widget.setName("Widget Inc");
		clientRepository.save(widget);
		
		//next client
		ClientModel foo = new ClientModel();
		foo.setAddress("456 Attorney Drive");
		foo.setCurrentInvoice(20000);
		foo.setName("Foo LLP");
		clientRepository.save(widget);
		
		//next client
		ClientModel bar = new ClientModel();
		bar.setAddress("111 Bar Street");
		bar.setCurrentInvoice(30000);
		bar.setName("Bar and Food");
		clientRepository.save(widget);
		
		//next client
		ClientModel dog = new ClientModel();
		dog.setAddress("222 Dog Drive");
		dog.setCurrentInvoice(40000);
		dog.setName("Dog Food and Accessories");
		clientRepository.save(widget);
		
		//next client
		ClientModel cat = new ClientModel();
		cat.setAddress("333 Cat Court");
		cat.setCurrentInvoice(50000);
		cat.setName("Cat Food");
		clientRepository.save(widget);
		
		//next client
		ClientModel hat = new ClientModel();
		hat.setAddress("444 Hat Drive");
		hat.setCurrentInvoice(60000);
		hat.setName("The Hat Shop");
		clientRepository.save(widget);
		
		//next client
		ClientModel hatB = new ClientModel();
		hatB.setAddress("445 Hat Drive");
		hatB.setCurrentInvoice(60000);
		hatB.setName("The Hat Shop B");
		clientRepository.save(widget);
		
		//next client
		ClientModel hatC = new ClientModel();
		hatC.setAddress("446 Hat Drive");
		hatC.setCurrentInvoice(60000);
		hatC.setName("The Hat Shop C");
		clientRepository.save(widget);
		
		//next client
		ClientModel hatD = new ClientModel();
		hatD.setAddress("446 Hat Drive");
		hatD.setCurrentInvoice(60000);
		hatD.setName("The Hat Shop D");
		clientRepository.save(widget);
		
		//next client
		ClientModel hatE = new ClientModel();
		hatE.setAddress("447 Hat Drive");
		hatE.setCurrentInvoice(60000);
		hatE.setName("The Hat Shop E");
		clientRepository.save(widget);
		
		//next client
		ClientModel hatF = new ClientModel();
		hatF.setAddress("448 Hat Drive");
		hatF.setCurrentInvoice(60000);
		hatF.setName("The Hat Shop F");
		clientRepository.save(widget);
	}
}
