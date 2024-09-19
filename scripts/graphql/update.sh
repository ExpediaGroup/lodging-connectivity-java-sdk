#!/bin/sh

cd code/src/main/graphql || exit

# Call it with a branch name to update the submodule to that branch, or with no arguments to update to the main branch.
BRANCH=${1:-main}

git checkout "$BRANCH"

git pull origin "$BRANCH"
