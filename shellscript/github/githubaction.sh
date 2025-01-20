#!/bin/bash

# Variables
REPO_OWNER="NarayanaGolla"   # GitHub username or organization
REPO_NAME="pythonapplication"          # Repository name
WORKFLOW_FILE_NAME="blank.yml"   # Name of your workflow file
  # Replace with your PAT
REF="master"                          # Branch or tag to trigger the workflow

# API Endpoint
GITHUB_API="https://api.github.com/repos/$REPO_OWNER/$REPO_NAME/actions/workflows/$WORKFLOW_FILE_NAME/dispatches"

# Trigger the workflow
curl -X POST -H "Authorization: token $GITHUB_TOKEN" \
     -H "Accept: application/vnd.github.v3+json" \
     $GITHUB_API \
     -d "{\"ref\":\"$REF\"}"

echo "Workflow triggered for $REF branch in $REPO_OWNER/$REPO_NAME"
