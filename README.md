# 6TIO-DRUMMOND

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

### Comando Personalizados

    git config --global alias.lg 'log --all --graph --decorate --oneline --abbrev-commit'
    git config --global alias.ac '!git add -A && git commit -m'
    git config --global alias.envia '!git push && git rebase' --replace-all

