#!/bin/sh

git submodule init
git submodule update --remote --merge

cd .git/modules/code/src/main/graphql || exit

mkdir -p .git/modules/code/src/main/graphql/info

cat > .git/modules/code/src/main/graphql/info/sparse-checkout <<EOL
/*
!CHANGELOG.md
!CONTRIBUTING.md
!LICENSE
!README.md
!.github
!.gitignore
EOL

git config core.sparseCheckout true

git read-tree -mu HEAD
