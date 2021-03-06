use triar;

insert into permissao (idpermissao, nome) values (1, "administrador"), (2, "coordenador"), (3, "graduado");

insert into usuario (idusuario, nome, cpf, data_nascimento, email, receber_email, senha, telefone, idpermissao) values (1, "Rodrigo Castro", "1", "1994-12-27", "rodrigondec@gmail.com", 1, "rodrigo123", "(84) 9 9818-4097", 1), (2, "Esther", "2", "1994-12-27", "esther@gmail.com", 1, "esther123", "(84) 9 9818-4097", 2), (3, "Everton", "3", "1994-12-27", "everton@gmail.com", 1, "everton123", "(84) 9 9818-4097", 3);

insert into administrador (idadministrador, idusuario) values (1, 1);

insert into coordenador (idcoordenador, idusuario, inicio_alocacao, fim_alocacao) values (1, 2, "2016-10-20", "2017-10-20");

insert into graduado (idgraduado, idusuario) values (1, 3);

insert into situacao (idsituacao, nome) values (1, "aprovado"), (2, "em supl�ncia"), (3, "n�o aprovado"), (4, "inscrito");

insert into processo_seletivo (idprocesso, curso, data_inicio, data_fim, idcoordenador, finalizado) values (1, "TI", "2016-10-20", "2016-12-31", 1, 0);

insert into vaga (idvaga, sub_area, quantidade, idprocesso) values (1, "Redes", 2, 1), (2, "Web", 3, 1);

insert into inscricao (idinscricao, idvaga, idgraduado, nota, idsituacao) values (1, 1, 1, 0, 4);

insert into noticia (idnoticia, titulo, corpo) values (1, "ALERTA URGENTE", "Sistema criado!");

insert into mensagem (idmensagem, titulo, corpo, ativa, idusuario) values (1, "Uma mensagem", "Essa � uma mensagem", 1, 1), (2, "Uma outra mensagem", "Essa � uma segunda mensagem", 1, 1);
