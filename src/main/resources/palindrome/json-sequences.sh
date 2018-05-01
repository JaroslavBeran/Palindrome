#!/bin/bash
cat json-sequences.txt | while read LINE ; do curl -vvv -i -H "Content-type: application/json" -X GET -d "$LINE"  http://localhost:8080/save; done;