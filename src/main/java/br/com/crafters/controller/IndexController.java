package br.com.crafters.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class IndexController {

	public IndexController(Result result) {
	}

	@Path("/")
	public void index() {
	}

}
