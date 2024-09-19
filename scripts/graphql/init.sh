#!/bin/sh

git submodule init
git submodule update --remote --merge

cd .git/modules/code/src/main/graphql || exit

mkdir info
cd info || exit

cat > sparse-checkout <<EOL
/*
!CHANGELOG.md
!CONTRIBUTING.md
!LICENSE
!README.md
!.github
!.gitignore
EOL

git config core.sparseCheckout true

cd "$(git rev-parse --show-toplevel)" || exit
git read-tree -mu HEAD
git pull origin "$(git rev-parse --abbrev-ref HEAD)"
