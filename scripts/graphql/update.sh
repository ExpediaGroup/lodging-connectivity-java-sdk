#!/bin/sh

cd code/src/main/graphql || exit

# Call it with a branch name to update the submodule to that branch, or with no arguments to update to the main branch.
BRANCH=${1:-main}

# Stash untracked files
git stash --include-untracked

# Checkout to the specified branch
git checkout "$BRANCH"

# Pull the latest changes from the specified branch
git pull origin "$BRANCH"

# Apply the stashed changes
git stash pop
