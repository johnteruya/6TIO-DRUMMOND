# 6TIO-DRUMMOND

## Primeiros Inserts no Banco Mysql
### Segue a baixo insert na parte de seguranças + usuários.
### Fundamental antes de executar o programa criar uma database chamada "eventosapp".

insert into usuarios_roles values ("admin","ROLE_ADMIN");
insert into usuarios_roles values ("user","ROLE_USER");

insert into usuario values ('admin','admin','$2a$10$YgfXvTdbT7VOVtFn/xeJTOXloz/KmC7am6lttFJxwWwETiBLqBJCq');
insert into usuario values ('user','user','$2a$10$S/1O/xVWEpffUioV/EcY7e81ifeocWV3jLt5lIbcQzQW/jGyoU.PK');

insert into role values ('ROLE_ADMIN');
insert into role values ('ROLE_USER');


## Meus Git Alias
### Sempre que utilizar este, em um computador novo, introduzir ao git.
### Comando Básicos

    git config --global alias.co checkout
    git config --global alias.cm commit -m
    git config --global alias.st status -sb
    git config --global alias.tags tag -l
    git config --global alias.branches branch -a
    git config --global alias.remotes remote -a
    git config --global alias.delbr branch -D
    git config --global alias.pl pull

### Comando Personalizados

    git config --global alias.lg 'log --all --graph --decorate --oneline --abbrev-commit'
    git config --global alias.ac '!git add -A && git commit -m'
    git config --global alias.envia '!git push && git rebase' --replace-all

### Comando SOMENTE para o PROJETO SPRINGBOOT

git config --global alias.atualiza '!git checkout projeto-springboot/produção && git merge projeto-springboot/desenvolvimento && git checkout projeto-springboot/desenvolvimento'


## Alias para Checkout
### Projeto-Springboot/desenvolvimento
git config --global alias.cosbd '!git checkout projeto-springboot/desenvolvimento'

### Projeto-Springboot/produção
git config --global alias.cosbp '!git checkout projeto-springboot/produção'

### Projeto-Springboot/original
git config --global alias.cosbo '!git checkout projeto-springboot/original'
