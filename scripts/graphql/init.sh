#!/bin/sh

set -e  # Exit immediately if a command exits with a non-zero status
set -x  # Print commands and their arguments as they are executed

echo "Initializing submodules..."
git submodule init

echo "Updating submodules..."
git submodule update --remote --merge

echo "Changing directory to .git/modules/code/src/main/graphql..."
cd .git/modules/code/src/main/graphql || exit

echo "Creating info directory..."
mkdir -p info
cd info || exit

echo "Configuring sparse checkout..."
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

echo "Returning to the top-level directory..."
cd "$(git rev-parse --show-toplevel)" || exit

echo "Reading tree..."
git read-tree -mu HEAD

echo "Pulling latest changes..."
git pull origin "$(git rev-parse --abbrev-ref HEAD)"