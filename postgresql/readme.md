# How to run postgres database using docker

## Prerequisites

You need to install docker - https://www.docker.com/

## First run
* start docker application
* go to the `../server/postgresql` folder
* paste the `data.sql` file with your data in this folder
* run `docker build -t aghcampus-postgres-db .` 
* then `docker run --name AGHCampus -p 5432:5432 aghcampus-postgres-db` 

## Run
* start docker application
* run `docker start AGHCampus`

## Additional commands

If you want to open psql terminal:\
`docker exec -it AGHCampus psql -U admin -d aghcampus -f /data.sql`

If you want to dump your data: \
`pg_dump -U admin -d aghcampus > data.sql` \
`docker cp AGHCampus:/data.sql data.sql`