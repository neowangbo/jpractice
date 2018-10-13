#!/bin/bash

# Following 2 ways to get bash version
#echo "Bash version: "$BASH_VERSION
echo "Bash version: "$(bash --version)


# Following 3 ways to get current directory in bash script. Last 2 ways
CURRENT_DIR=$(pwd)
#echo $BASH_SOURCE
#echo $(dirname "$0")
echo  "Location   : "${CURRENT_DIR}


# pass arguments
# $0 - <dir>/fileName.sh
# $1 - argument 1
# $2 - argument 2
# $# - the number of arguments
# $@ - all arguments
echo "Receive arguments: "$@


java -jar ${CURRENT_DIR}/../lib/soupclient-http.jar $@