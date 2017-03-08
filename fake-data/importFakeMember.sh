#!/usr/bin/env bash
##############################################################################
##
##  Import fake name generator
##
##############################################################################
mongoimport -d profile -c members --type csv --file FakeMembers.csv --headerline

