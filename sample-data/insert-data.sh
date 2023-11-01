#!/bin/bash

cat ./sample-data.sql | docker exec -i server-postgres-1 psql -U postgres -d aghcampus_dev