package service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.PermissaoDAO;
import model.Permissao;

@Stateless
public class PermissaoService {
	@Inject
	private PermissaoDAO PermissaoDAO;

	public void cadastrarPermissao(Permissao permissao) {
		PermissaoDAO.salvar(permissao);
	}
}