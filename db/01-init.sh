#!/bin/bash
set -e
export PGPASSWORD=$POSTGRES_PASSWORD;
psql --username postgres <<-EOSQL
  CREATE DATABASE $DEV_DB;
  CREATE DATABASE $TEST_DB;
EOSQL