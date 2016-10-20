use triar;

insert into permissao (idpermissao, nome) values (1, "administrador"), (2, "coordenador"), (3, "graduado");

insert into usuario (idusuario, nome, cpf, data_nascimento, email, receber_email, senha, telefone, idpermissao) values (1, "Rodrigo Castro", "1", "1994-12-27", "rodrigondec@gmail.com", 1, "rodrigo123", "(84) 9 9818-4097", 1), (2, "Esther", "2", "1994-12-27", "esther@gmail.com", 1, "esther123", "(84) 9 9818-4097", 2), (3, "Everton", "3", "1994-12-27", "everton@gmail.com", 1, "everton123", "(84) 9 9818-4097", 3);

insert into administrador (idadministrador, idusuario) values (1, 1);

insert into coordenador (idcoordenador, idusuario) values (1, 2);

insert into graduado (idgraduado, idusuario) values (1, 3);

insert into processo_seletivo (idprocesso, curso, data_inicio, data_fim, edital, idcoordenador) values (1, "TI", "2016-10-20", "2016-12-31", "../matricula.pdf", 1);

